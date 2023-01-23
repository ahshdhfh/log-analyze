package project;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class SelectmenuEvt extends WindowAdapter implements ActionListener {

	private SelectMenu sm; // select menu 객체
	private Login lg; // 로그인클래스 겍체
	private LogVO lv = new LogVO(); // 로그정보객체
	private LogDecomposition ldp = new LogDecomposition(lv); // 로그분해 및 카운트 객체

	private String filePath = "";// 불러운 파일 경로
	private String fName = "";// 불러온 파일 이름
	private List<String> token;// 방하나에 토큰 하나씩
	private String data; // 파일읽어온 글자들 저장할 변수

	private int totalCntLine;// 총 호출된 횟수! ** 메서드에 사용
	private int cntLine; // 읽어온 라인수 새는 변수
	private int startLine; // 시작라인 설정할 변수

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	private int endLine; // 끝라인 설정할 변수

	public String getFilePath() {
		return filePath;
	}// getFilePath

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}// setFilePath

	public String getfName() {
		return fName;
	}// getfName

	public void setfName(String fName) {
		this.fName = fName;
	}// setfName

	public int getTotalCntLine() {
		return totalCntLine;
	}// getTotalCntLine

	public int getCntLine() {
		return cntLine;
	}// getCntLine

	/**
	 * 값 초기화용 메소드 또 실행했을때 누적되는것을 방지
	 */
	public void resetVariable() {
		data = ""; // 읽어온 스트링 값 넣는 변수
		cntLine = 0; // 총 돌아간 라인수
		totalCntLine = 0;// 총 호출된 횟수! ** 메서드에 사용
	}// resetVariable

	public SelectmenuEvt(SelectMenu sm, Login lg) {
		this.sm = sm;
		this.lg = lg;
	}// SelectmenuEvt

	@Override
	public void windowClosing(WindowEvent we) {
		System.exit(0); // select menu 닫히면 전부 닫아버리기
	}// windowClosing

	/**
	 * 버튼 누를시 발생하는 메서드 입력하기
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == sm.getJbtnView()) { // view 버튼이 눌리면
			if (ExecuteCondition()) {
				try {
					readLog(); // 파일 읽기
					ldp.calTime(); // 가장 많이 호출된 시간계산
					ldp.calMostFrequentKey(); // 가장 많이 사용된 키값 계산
				} catch (IOException e) {
					e.printStackTrace();
				} // end catch
				new Result(sm, this, lv); // result 창 띄우기
			}
		} // end if

		if (ae.getSource() == sm.getJbtnReport()) { // 레포트 버튼이 눌리면
			if (ExecuteCondition()) {
				if (lg.getId().equals("root")) {
					JOptionPane.showMessageDialog(sm, "문서를 생성할 수 있는 권한이 없음");
				} else {
					try {
						readLog();// 파일 읽기
						ldp.calTime();// 가장 많이 호출된 시간계산
						ldp.calMostFrequentKey(); // 가장 많이 사용된 키값 계산
						showResult(); // 파일을 만들 메소드
					} catch (IOException e) {
						e.printStackTrace();
					} // end catch
				} // end else
			}
		} // end if

		if (ae.getSource() == sm.getJbtnFileSelect()) { // 파일선택 버튼이 눌리면
			FileDialog fdOpen = new FileDialog(sm, "파일 열기", FileDialog.LOAD); // 파일 DIalog 열기
			fdOpen.setVisible(true); // 다이얼로그가 보이게 디폴트 값이 false임으로 true로 선언해줘야함
			if(!filePath.equals("")&&!fName.equals("")) {
				filePath = fdOpen.getDirectory(); // 파일골랐으면 경로값 저장
				fName = fdOpen.getFile(); // 파일골랐으면 파일 이름값 저장				
			}else {
				filePath=""; //안고르고 취소누르면 null값 넣기
				fName=""; //안고르고 취소누르면 null값 넣기
			}
			sm.JtextFilememo(fName); // 파일이름을 사용자가 고른 파일이름으로 텍스트창에 보여주기
		} // end if
	}// actionPerformed

	public boolean ExecuteCondition() {
		boolean result = false;
		if (fName.equals("sist_input_1.log") || fName.equals("sist_input_2.log")) { // 파일이 지원하는 형식인지
			lineCheck();// 원하는 라인입력값확인
			if (totalCntLine < startLine || totalCntLine < endLine) {//
				JOptionPane.showMessageDialog(sm, "지정된 수가 너무 큽니다! " + totalCntLine + "줄 내에서 설정해주세요!");
			} else if ((endLine > startLine || endLine == startLine) && (startLine > -1 && endLine > -1)) { // 라인 입력값
																											// 형식이 맞는지
				result = true;
			} else {
				JOptionPane.showMessageDialog(sm, "라인 수를 다시입력해주세요"); // 라인수 형식이 맞지 않음
			} // end else
		} else {
			JOptionPane.showMessageDialog(sm, "지원하는 파일 형식이 아닙니다. 파일을 다시 선택해주세요"); // 지원하는 파일 형식이 아님
		} // end else
		return result;
	}

	public void lineCheck() {
		///////////////// 수정된부분//////////////////////
		File file = new File(filePath + fName); // 파일을 읽어오기 위해 경로 설정할 file객체생성

		BufferedReader br = null; // BufferedReader 객체 변수명 설정
		totalCntLine = 0;// 다른 작업중 지정된 totalCntLine을 0으로 설정

		try {// 다른작업은 하지않고 totalCntLine만 세는 작업
			br = new BufferedReader(new FileReader(file));
			while ((data = br.readLine()) != null) {
				totalCntLine++;// 줄 수만큼 읽어들임
			} // end while
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
			///////////////// 수정된부분//////////////////////

		if (sm.getJtfLineinput().getText().equals("")) { // 라인입력 값이 없으면
			startLine = 0; // 디폴트값 0넣기
			endLine = totalCntLine;// 디폴트값넣기
		} else {
			try {
				int index = sm.getJtfLineinput().getText().indexOf("~"); // ~표시 찾아서 인덱스 값을 변수에 넣기
				startLine = Integer.parseInt(sm.getJtfLineinput().getText().substring(0, index)); // start 짜르기
				endLine = Integer.parseInt(
						sm.getJtfLineinput().getText().substring(index + 1, sm.getJtfLineinput().getText().length())); // end
																														// 짜르기
			} catch (Exception e) { // 사용자가 숫자입력안해서 parseInt가 안먹으면 에러가 나고 에러나면 -1로 세팅해라
				startLine = -1;
				endLine = -1;
			} // end catch
		} // end else
	}// lineCheck

	/**
	 * 파일 읽어오는 메소드
	 * 
	 * @throws IOException
	 */
	public void readLog() throws IOException {
		lv.resetVariable();// 시작전 iv 초기화 누를때마다 계속 쌓이는걸 방지
		resetVariable();// 시작전 iv 초기화 누를때마다 계속 쌓이는걸 방지
		if (filePath != null) { // 파일을 골랐는지? 안골랐으면 실행안되게 하고 메시지 띄움 골르라고

			File file = new File(filePath + fName); // 파일을 읽어오기 위해 경로 설정할 file객체생성

			BufferedReader br = null; // BufferedReader 객체 변수명 설정
			try {
				br = new BufferedReader(new FileReader(file)); // BufferedReader에 경로 설정한 file객체 매개변수로 넣기
				token = new ArrayList<String>(); // 로그를 토큰으로 자르기 위해 선언
				int i = 0;
				while ((data = br.readLine()) != null) {
					totalCntLine++;

					if (totalCntLine >= startLine && totalCntLine <= endLine) {
						cntLine++;
						i = 0; // [200]=0 [key]=1 [ie]=2 [날짜]=3
						StringTokenizer stk = new StringTokenizer(data, "]["); // 로그를 ][ 기준으로 자르기
						while (stk.hasMoreTokens()) { // 토큰이 없으면 while 끝내기
							token.add(i, stk.nextToken()); // 토큰 자를때마다 저장
							i++; // i++하면서 토큰에 값 넣기
						} // end while
						if (!token.isEmpty()) { // 토큰이 없으면 메소드 실행 못하게
							ldp.cntCode(token.get(0)); // code카운트 메소드
							ldp.countKey(token.get(1)); // 키값 카운터메소드
							ldp.countBrowser(token.get(2));// 브라우저 카운트메소드
							ldp.calMostFrequentHour(token.get(3));// 시간 카운트메소드
						} // end if
					}
				} // end while
			} finally {
				if (br != null) {
					br.close(); // 파일 닫기
				} // end if
			} // end finally
		} // end if
	}// read

	/**
	 * 8번문제 1~7번 결과 다이얼로그로 보여주기 report생성 버튼이 클릭되면 c:/dev/report폴더를 생성한 후
	 * “report_생성날짜.dat” 파일을 생성하여 1~6까지의 작업을 모두 출력한다. 파일명 예)
	 * report_1628605156919.dat
	 */
	public void showResult() throws IOException {
		Date date = new Date(); // 시간나타낼 객체생성
		File dir = new File("C:/dev/report"); // 파일을 여기다가 저장
		if (!dir.exists()) { // 디렉토리 없니?
			dir.mkdirs();// 디렉토리 생성
		} // end if

		BufferedWriter bw = null; // BufferedWriter
		File saveFile = new File(dir.getAbsolutePath() + "/report_" + date.getTime() + ".dat"); // 파일이름설정
		try {
			bw = new BufferedWriter(new FileWriter(saveFile)); // 해당 파일이름으로 저장해라

			bw.write("1번\n가장많이 접속한 브라우저 : " + lv.getMostFrequentKey() + ", 횟수 : " + lv.getMostFrequentKeyV() + "\n");// 1번문제
			bw.write("2번\nIE : " + lv.getIe() + "(" + Math.round(((double) lv.getIe() / (double) getCntLine() * 100.0))
					+ "%)"// 2번문제
					+ ", FireFox : " + lv.getFirefox() + "("
					+ Math.round(((double) lv.getFirefox() / (double) getCntLine() * 100.0)) + "%)" + ", Chrome : "
					+ lv.getChrome() + "(" + Math.round(((double) lv.getChrome() / (double) getCntLine() * 100.0))
					+ "%)" + ", Safari : " + lv.getSafari() + "("
					+ Math.round(((double) lv.getSafari() / (double) getCntLine() * 100.0)) + "%)" + ", Opera : "
					+ lv.getOpera() + "(" + Math.round(((double) lv.getOpera() / (double) getCntLine() * 100.0))
					+ "%)\n");
			bw.write("3번\n성공 횟수(200) : " + lv.getCode200() + ", 실패 횟수(404) : " + lv.getCode404() + "\n");// 3번문제
			bw.write("4번\n요청이 가장 많은 시간대: " + lv.getMaxHourValue() + "시\n");// 4번문제
			bw.write("5번\n비정상적인 요청 (403)" + lv.getCode403() + "번, 비율 : "
					+ Math.round(((double) lv.getCode403() / (double) getCntLine() * 100.0)) + "%\n");// 5번문제
			bw.write("6번\n요청에 대한 에러 (500)" + lv.getCode500() + "번, 비율 : "
					+ Math.round(((double) lv.getCode500() / (double) getCntLine() * 100.0)) + "%\n");// 6번문제
			bw.flush();// 분출

		} finally {
			if (bw != null) {
				bw.close(); // 닫기
			} // 스트림에 남아있는 내용을 목적지로 분출(flush)하고 연결을 끊는다.
		} // end finally
	}// showResult

}// class
