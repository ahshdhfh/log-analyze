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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.swing.JOptionPane;

public class SelectmenuEvt extends WindowAdapter implements ActionListener {

	private SelectMenu sm;
	private Login lg;
	String filePath = "C:/dev/workspace/javase_prj/src/project/";//프로젝트\1차\SIST_ANAL_01요구사항정의서;//불러운 파일 경로
	String fName="";//불러온 파일 이름
	String logTxtCreationDate;//로그파일 날짜 기록용
	String[] browser;//사용된 브라우저 기록용 배열
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	String[] log;//각 방 하나에 로그 한줄씩 
	//ex)[200][http://sist.co.kr/find/new?key=res&query=sist][ie][2023-01-16 11:11:43]
	List<String> token;//방하나에 토큰 하나씩 
	//ex) [200, [500
	
	private String data;
	private int totalCntLine;//총 호출된 횟수! ** 메서드에 사용
	private int cntLine;
	private int maxHourValue;//시간
	int[] hour= new int[24];
	
	Map<String, Integer>key=new HashMap<String, Integer>(); //1번 테스트
	

	private int ie;//브라우저 카운트
	private int firefox;//브라우저 카운트
	private int opera;//브라우저 카운트
	private int chrome;//브라우저 카운트
	private int safari;//브라우저 카운트
	
	private int code200;//코드 200이 나온 횟수
	private int code404;//코드 404이 나온 횟수
	private int code403;//코드 403이 나온 횟수
	private int code500;//코드 403이 나온 횟수
	private int startLine;
	private int endLine;
	
	private String mostFrequentHour;//가장 요청이 많은 시간
	private String mostFrequentKey;//가장 요청이 많은 키
	private int mostFrequentKeyV;//가장 요청이 많은 키의 값
	
	public int getOpera() {
		return opera;
	}

	public void setOpera(int opera) {
		this.opera = opera;
	}

	public int getIe() {
		return ie;
	}

	public int getFirefox() {
		return firefox;
	}

	public int getChrome() {
		return chrome;
	}

	public int getSafari() {
		return safari;
	}	
	
//	Map<String, Integer >mapHour;
	
	public String[] getBrowser() {
		return browser;
	}

	public void setBrowser(String[] browser) {
		this.browser = browser;
	}

	public int getTotalCntLine() {
		return totalCntLine;
	}

	public int getCntLine() {
		return cntLine;
	}

	public int getCode200() {
		return code200;
	}

	public void setCode200(int code200) {
		this.code200 = code200;
	}

	public int getCode404() {
		return code404;
	}

	public void setCode404(int code404) {
		this.code404 = code404;
	}

	public int getCode403() {
		return code403;
	}

	public void setCode403(int code403) {
		this.code403 = code403;
	}

	public int getCode500() {
		return code500;
	}

	public void setCode500(int code500) {
		this.code500 = code500;
	}

	
	public String getMostFrequentHour() {
		return mostFrequentHour;
	}

	public String getMostFrequentKey() {
		return mostFrequentKey;
	}

	public int getMaxHourValue() {
		return maxHourValue;
	}


	
	public void resetVariable() {
		data="";
		code200=0;//코드 200이 나온 횟수
		code404=0;//코드 404이 나온 횟수
		code403=0;//코드 403이 나온 횟수
		code500=0;//코드 403이 나온 횟수
		
		mostFrequentHour="";//가장 요청이 많은 시간
		mostFrequentKey="";//가장 요청이 많은 키
		mostFrequentKeyV=0;//가장 요청이 많은 키의 값
		
		ie=0;//브라우저 카운트
		firefox=0;//브라우저 카운트
		opera=0;//브라우저 카운트
		chrome=0;//브라우저 카운트
		safari=0;//브라우저 카운트
		
		cntLine=0;
		totalCntLine=0;//총 호출된 횟수! ** 메서드에 사용
		
		maxHourValue=0;
		hour= new int[24];
		
		key=new HashMap<String, Integer>();
	}
	
	public int getMostFrequentKeyV() {
		return mostFrequentKeyV;
	}

	public SelectmenuEvt(SelectMenu sm,Login lg) {
		this.sm=sm;
		this.lg=lg;
	}//loginEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		sm.dispose();
	}//windowClosing
	
	/**
	 * 버튼 누를시 발생하는 메서드 입력하기
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sm.getJbtnView()) {
			
			
			if(fName.equals("sist_input_1.log")||fName.equals("sist_input_2.log")) {
			if(sm.getJtfLineinput().getText().equals("")) {
				startLine=0;
				endLine=20000;
			}else {
				try {
				int index=sm.getJtfLineinput().getText().indexOf("~");		
				startLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(0,index));
				endLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(index+1,sm.getJtfLineinput().getText().length()));
				}catch(Exception e) {
					
				}
			}
			if(endLine>startLine || endLine==startLine) {
			try {
				readLog();
				System.out.println(endLine+"/"+startLine);
				calTime();
				System.out.println("2");
				calMostFrequentKey();
				System.out.println("3");
				// max값 구하는 메소드
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Result(sm,this);
			}else {
				JOptionPane.showMessageDialog(sm, "다시입력해주세요");
			}
			}else {
				JOptionPane.showMessageDialog(sm, "지원하는 파일 형식이 아닙니다. 파일을 다시 선택해주세요");
			}
			
		}//end if
		
		if(ae.getSource()==sm.getJbtnReport()) {
			if(fName.equals("sist_input_1.log")||fName.equals("sist_input_2.log")) {
			if(sm.getJtfLineinput().getText().equals("")) {
				startLine=0;
				endLine=20000;
			}else {
				try {
				int index=sm.getJtfLineinput().getText().indexOf("~");		
				startLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(0,index));
				endLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(index+1,sm.getJtfLineinput().getText().length()));
				}catch(Exception e) {
					
				}
			}
			if(endLine>startLine || endLine==startLine) {
			if(lg.getId().equals("root")) {
				JOptionPane.showMessageDialog(sm, "문서를 생성할 수 있는 권한이 없음");
			}else {
				try {
					readLog();
					calTime();
					calMostFrequentKey();
					showResult();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}else {
				JOptionPane.showMessageDialog(sm, "다시입력해주세요");
			}
			}else {
				JOptionPane.showMessageDialog(sm, "지원하는 파일 형식이 아닙니다. 파일을 다시 선택해주세요");
			}
		}//end if
		
		if(ae.getSource()==sm.getJbtnFileSelect()) {
			FileDialog fdOpen=new FileDialog(sm, "파일 열기", FileDialog.LOAD);
			fdOpen.setVisible(true);
			filePath=fdOpen.getDirectory();
			fName=fdOpen.getFile();
			sm.JtextFilememo(fName);
		}//end if
	}//actionPerformed
	
	
	public void readLog() throws IOException {
		resetVariable();//시작전 iv 초기화
//		if(sm.getJtfLineinput().getText().equals("")) {
//			startLine=0;
//			endLine=20000;
//		}else {
//			int index=sm.getJtfLineinput().getText().indexOf("~");		
//			startLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(0,index));
//			endLine=Integer.parseInt(sm.getJtfLineinput().getText().substring(index+1,sm.getJtfLineinput().getText().length()));
//		}
		
//		fName = sm.getJtfFileNameInput().getText()+"";
		if (filePath != null) {

			File file = new File(filePath+fName);		
			
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
					token=new ArrayList<String>();
					int i=0;
					while ((data = br.readLine()) != null) {
						totalCntLine++;  
						
						if(totalCntLine>=startLine && totalCntLine<=endLine) {
							cntLine++;
						i=0;
						StringTokenizer stk = new StringTokenizer(data, "][");
						while(stk.hasMoreTokens()) {
							token.add(i,  stk.nextToken());
							i++;	
						}//end while			
						if(!token.isEmpty()) {
							cntCode(token.get(0));
							countKey(token.get(1));
							countBrowser(token.get(2));
							calMostFrequentHour(token.get(3));
						}//end if						
						}
					}//end while					
				} finally {
					if (br != null) {br.close();
					}//end if
				}//end finally
		} // end if
	}//read

	

	/**
	 * 1번 문제 
	 * 가장많이 나온 key 찾아내는 메서드
	 */
	public void countKey(String token) {
		int values = 0;
			if(token.indexOf("&")!=-1) {
				token=token.substring(token.indexOf("key=")+4,token.indexOf("&"));
			}else {
//				System.out.println(1);
			}
			if (!(key.containsKey(token))) {// 키가 없으면?
				key.put(token, 1);// 새로운 키, 값을 설정
			} else if (key.containsKey(token)) {// 키가 있을때
				values = key.get(token);// 현재 저장된 값을 빼주기
				values += 1;// 값에 1 카운트
				key.put(token, values);// 카운팅 된 값을 넣기
			} // end else if
	}//calMostFrequentKey
	
	public void calMostFrequentKey() {
		mostFrequentKey="";
		int maxValue = Collections.max(key.values());
		//key7에 카운트된 값들중 collections.max을 통해 가장 많이 카운트된 횟수를 도출한다.
		for (String r : key.keySet()) {//key에 key1을 통해 얻은 모든 키를 얻는다.
			if (key.get(r) == maxValue) {//key의 키값 중 가장 많은 횟수를 얻은 키가 있을 경우
				mostFrequentKey = r+"";//그 "키값을 최다사용 키"로 지정한다.
				mostFrequentKeyV=maxValue;
				break;     
			} // end if
		} // end for
	}// calMostFrequentKey
	

	
	/**
	 * 2번문제
	 * 브라우저별 접속 횟수, 비율구하기
	 */
	public void countBrowser(String token) {
		if(token.equals("ie")) {
			this.ie++;
		}else if(token.equals("Chrome")){
			this.chrome++;
		}else if(token.equals("firefox")){
			this.firefox++;
		}else if(token.equals("opera")){
			this.opera++;
		}else if(token.equals("Safari")) {
			this.safari++;
		}

		
	}// countBowser
	
	
	
	
//	Iterator<String> iterator;
	
	
	/**
	 * 3번, 5번, 6번문제
	 * @param token
	 */
	public void cntCode(String token) {
		switch (Integer.parseInt(token)) {
		case 200:	code200++;		break;
		case 403:	code403++;		break;
		case 404:	code404++;		break;
		case 500:	code500++;		break;
		}//end switch
	}//cntCode
	
	/**
	 * 4번문제
	 * 가장많이 접속한 시간 찾는 메서드 
	 */
	public void calTime() {
		for(int h=1;h<hour.length;h++) {
			if(hour[h]>hour[h-1]) {
				maxHourValue=h;
		}
		}
	} //calTIme
		
	public void calMostFrequentHour(String token) {
		/**
		 * 4번문제
		 * 가장많이 접속한 시간 찾는 메서드 
		 */
		token =token.substring(11, 13);
		int num=Integer.parseInt(token);
		hour[num]++;
		
		} //calMostFrequentHour

	/**
	 * 8번문제 1~7번 결과 다이얼로그로 보여주기 report생성 버튼이 클릭되면 c:/dev/report폴더를 생성한 후
	 * “report_생성날짜.dat” 파일을 생성하여 1~6까지의 작업을 모두 출력한다. 파일명 예)
	 * report_1628605156919.dat
	 */
	public void showResult() throws IOException {
		Date date = new Date();
		File dir = new File("C:/dev/report");
		if (!dir.exists()) {
			dir.mkdirs();// 디렉토리 생성
		} // end if

		BufferedWriter bw = null;
		File saveFile = new File(dir.getAbsolutePath() + "/report_" + date.getTime() + ".dat");
		try {
			bw = new BufferedWriter(new FileWriter(saveFile));

			bw.write("1번\n가장많이 접속한 브라우저 : "+getMostFrequentKey()+", 횟수 : "+getMostFrequentKeyV()+"\n");//1번문제
			bw.write("2번\nIE : "+getIe()+"("+Math.round(((double)getIe()/(double)getCntLine()*100.0))+"%)"//2번문제
					+", FireFox : "+getFirefox()+"("+Math.round(((double)getFirefox()/(double)getCntLine()*100.0))+"%)"
					+", Chrome : "+getChrome()+"("+Math.round(((double)getChrome()/(double)getCntLine()*100.0))+"%)"
					+", Safari : "+getSafari()+"("+Math.round(((double)getSafari()/(double)getCntLine()*100.0))+"%)"
					+", Opera : "+getOpera()+"("+Math.round(((double)getOpera()/(double)getCntLine()*100.0))+"%)\n"
					);
			bw.write("3번\n성공 횟수(200) : "+getCode200()+", 실패 횟수(404) : "+ getCode404() + "\n" );//3번문제
			bw.write("4번\n요청이 가장 많은 시간대: "+getMaxHourValue()+"시\n");//4번문제
			bw.write("5번\n비정상적인 요청 (403)" + getCode403()+ "번, 비율 : "+ getCode403()+"%\n");//5번문제
			bw.write("6번\n요청에 대한 에러 (500)" + getCode500()+ "번, 비율 : "+ getCode500()+"%\n");//6번문제
			bw.flush();// 분출

		} finally {
			if (bw != null) {
				bw.close();
			} // 스트림에 남아있는 내용을 목적지로 분출(flush)하고 연결을 끊는다.
		} // end finallyy
	}
}




