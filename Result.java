package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Result extends JDialog {

	public Result(SelectMenu main, SelectmenuEvt smenu, LogVO lv) {
		super(main, "Result", false); // JDialog

		JTextField jtfViewLine = new JTextField(); // 범위선택택스트창
		jtfViewLine.setText(
				"총 log 개수는 " + smenu.getCntLine() + "개이며," + main.getJtfLineinput().getText() + "범위의 로그분석결과입니다."); // 범위선택택스트창
		jtfViewLine.setEditable(false); // 사용자가 못건들게
		jtfViewLine.setBorder(new LineBorder(Color.BLACK, 1)); // 강조를 위한 LineBorder
		jtfViewLine.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfViewLine.setBackground(new Color(0xF3F5F7)); // 색상설정

		JTextField jtfFile = new JTextField(); // 선택파일텍스트
		jtfFile.setText(smenu.getfName()); // 선택한 파일 텍스트창으로
		jtfFile.setEditable(false); // 사용자가 못건들게
		jtfFile.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfFile.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfFile.setBackground(Color.WHITE);// 색상설정
		JLabel jlblFile = new JLabel("선택한 파일: "); // 선택파일라벨

		JTextField jtfmaxKey = new JTextField(); // 1번
		jtfmaxKey.setText(lv.getMostFrequentKey() + " / " + lv.getMostFrequentKeyV() + "개"); // 가장 많이 사용한 키 와 갯수
		jtfmaxKey.setEditable(false); // 사용자가 못건들게
		jtfmaxKey.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfmaxKey.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfmaxKey.setBackground(Color.WHITE);// 색상설정
		JLabel jlblmaxKey = new JLabel("1. 최다 사용키: "); // 1번 결과: 텍스트

		JTextField jtfbrowseronnect = new JTextField(); // 2번
		jtfbrowseronnect.setText(rateText(lv.getIe(), smenu.getCntLine())); // ie 브라우저 비율 시각화
		jtfbrowseronnect.setEditable(false); // 사용자가 못건들게
		jtfbrowseronnect.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbrowseronnect.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfbrowseronnect.setBackground(Color.WHITE); // 색상설정
		JLabel jlblbrowseronnect = new JLabel("2. 브라우저: "); // 2번결과: 텍스트

		JTextField jtfbrowseronnect1 = new JTextField(); // 2번_1
		jtfbrowseronnect1.setText(rateText(lv.getFirefox(), smenu.getCntLine())); // Firefox 브라우저 비율 시각화
		jtfbrowseronnect1.setEditable(false); // 사용자가 못건들게
		jtfbrowseronnect1.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbrowseronnect1.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfbrowseronnect1.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbrowseronnect2 = new JTextField(); // 2번_2
		jtfbrowseronnect2.setText(rateText(lv.getChrome(), smenu.getCntLine())); // Chrome 브라우저 비율 시각화
		jtfbrowseronnect2.setEditable(false); // 사용자가 못건들게
		jtfbrowseronnect2.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbrowseronnect2.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfbrowseronnect2.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbrowseronnect3 = new JTextField(); // 2번_3
		jtfbrowseronnect3.setText(rateText(lv.getSafari(), smenu.getCntLine())); // Safari 브라우저 비율 시각화
		jtfbrowseronnect3.setEditable(false); // 사용자가 못건들게
		jtfbrowseronnect3.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbrowseronnect3.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfbrowseronnect3.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbrowseronnect4 = new JTextField(); // 2번_4
		jtfbrowseronnect4.setText(rateText(lv.getOpera(), smenu.getCntLine())); // Opera 브라우저 비율 시각화
		jtfbrowseronnect4.setEditable(false); // 사용자가 못건들게
		jtfbrowseronnect4.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbrowseronnect4.setFont(new Font("맑은고딕", Font.BOLD, 12)); // 폰트설정
		jtfbrowseronnect4.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbr1 = new JTextField(); // 2번브라우저 IE
		jtfbr1.setText("IE : " + lv.getIe() + "("
				+ Math.round(((double) lv.getIe() / (double) smenu.getCntLine() * 100.0)) + "%)"); // ie 값과 비율 가져오기
		jtfbr1.setEditable(false); // 사용자가 못건들게
		jtfbr1.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbr1.setFont(new Font("맑은고딕", Font.BOLD, 10)); // 폰트설정
		jtfbr1.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbr2 = new JTextField(); // 2번브라우저 FireFox
		jtfbr2.setText("FireFox : " + lv.getFirefox() + "("
				+ Math.round(((double) lv.getFirefox() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Firefox 값과 비율
																										// 가져오기
		jtfbr2.setEditable(false); // 사용자가 못건들게
		jtfbr2.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbr2.setFont(new Font("맑은고딕", Font.BOLD, 10)); // 폰트설정
		jtfbr2.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbr3 = new JTextField(); // 2번브라우저 Chrome
		jtfbr3.setText("Chrome : " + lv.getChrome() + "("
				+ Math.round(((double) lv.getChrome() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Chrome 값과 비율
																										// 가져오기
		jtfbr3.setEditable(false); // 사용자가 못건들게
		jtfbr3.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbr3.setFont(new Font("맑은고딕", Font.BOLD, 10)); // 폰트설정
		jtfbr3.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbr4 = new JTextField(); // 2번브라우저 Safari
		jtfbr4.setText("Safari : " + lv.getSafari() + "("
				+ Math.round(((double) lv.getSafari() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Safari 값과 비율
																										// 가져오기
		jtfbr4.setEditable(false); // 사용자가 못건들게
		jtfbr4.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbr4.setFont(new Font("맑은고딕", Font.BOLD, 10)); // 폰트설정
		jtfbr4.setBackground(Color.WHITE);// 색상설정

		JTextField jtfbr5 = new JTextField(); // 2번브라우저 Opera
		jtfbr5.setText("Opera : " + lv.getOpera() + "("
				+ Math.round(((double) lv.getOpera() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Opera 값과 비율
																										// 가져오기
		jtfbr5.setEditable(false); // 사용자가 못건들게
		jtfbr5.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfbr5.setFont(new Font("맑은고딕", Font.BOLD, 10)); // 폰트설정
		jtfbr5.setBackground(Color.WHITE); // 색상설정

		JTextField jtfserviceSucess = new JTextField(); // 3번
		jtfserviceSucess.setText(lv.getCode200() + "개("
				+ Math.round(((double) lv.getCode200() / (double) smenu.getCntLine() * 100.0)) + "%)");// Code200 값과 비율
																										// 가져오기
		jtfserviceSucess.setEditable(false); // 사용자가 못건들게
		jtfserviceSucess.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfserviceSucess.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfserviceSucess.setBackground(Color.WHITE);
		JLabel jlblserviceSucess = new JLabel("3. 서비스 성공: "); // 3번결과: 텍스트
		JLabel jlblserviceSucess1 = new JLabel("성공한 서비스(200) : "); // 3번결과: 텍스트
		JLabel jlblserviceSucess2 = new JLabel("실패한 서비스(400) : "); // 3번결과: 텍스트

		JTextField jtfserviceSucess1 = new JTextField(); // 3번_실패
		jtfserviceSucess1.setText(lv.getCode404() + "개("
				+ Math.round(((double) lv.getCode404() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Code404 값과 비율
																										// 가져오기
		jtfserviceSucess1.setEditable(false); // 사용자가 못건들게
		jtfserviceSucess1.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfserviceSucess1.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfserviceSucess1.setBackground(Color.WHITE);

		JTextField jtfrequestTime = new JTextField(); // 4번
		jtfrequestTime.setText(lv.getMaxHourValue() + "시"); // 가장 많이 나온 시간 값 가져오기
		jtfrequestTime.setEditable(false); // 사용자가 못건들게
		jtfrequestTime.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfrequestTime.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfrequestTime.setBackground(Color.WHITE); // 색상설정
		JLabel jlblrequestTime = new JLabel("4. 요청시간: "); // 4번결과: 텍스트

		JTextField jtfrequest403 = new JTextField(); // 5번
		jtfrequest403.setText(lv.getCode403() + "개("
				+ Math.round(((double) lv.getCode403() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Code403 갯수랑
																										// 비율가져오기
		jtfrequest403.setEditable(false); // 사용자가 못건들게
		jtfrequest403.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfrequest403.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfrequest403.setBackground(Color.WHITE); // 색상설정
		JLabel jlblrequest403 = new JLabel("5. 요청403: "); // 아이디텍스트

		JTextField jtfrequest500 = new JTextField(); // 6번
		jtfrequest500.setText(lv.getCode500() + "개("
				+ Math.round(((double) lv.getCode500() / (double) smenu.getCntLine() * 100.0)) + "%)"); // Code500 갯수랑
																										// 비율가져오기
		jtfrequest500.setEditable(false); // 사용자가 못건들게
		jtfrequest500.setBorder(new LineBorder(Color.BLACK, 2)); // 강조를 위한 LineBorder
		jtfrequest500.setFont(new Font("맑은고딕", Font.BOLD, 15)); // 폰트설정
		jtfrequest500.setBackground(Color.WHITE); // 색상설정
		JLabel jlblrequest500 = new JLabel("6. 요청500: "); // 아이디텍스트

		ImageIcon icon = new ImageIcon("C:/dev/workspace/javase_prj/src/project/result.png");// 이미지객체
		ImageIcon iconSist = new ImageIcon("C:/dev/workspace/javase_prj/src/project/sist.png");// 이미지객체
		JLabel img1 = new JLabel(icon); // 아이디텍스트
		JLabel img2 = new JLabel(iconSist); // 아이디텍스트

		JLabel bigFrame = new JLabel();// 장식용 큰틀
		bigFrame.setBorder(new LineBorder(Color.BLACK, 4)); // 강조를 위한 LineBorder

		JLabel emphasis1 = new JLabel();// 선택파일창 강조라벨
		emphasis1.setBorder(new LineBorder(Color.BLACK, 3)); // 강조를 위한 LineBorder

		JPanel jp = new JPanel();
		jp.add(bigFrame); // 장식용 큰틀
		jp.add(emphasis1); // 장식용 큰틀
		jp.add(img1); // result이미지
		jp.add(img2); // sist이미지
		jp.add(jtfViewLine); // 범위택스트
		jp.add(jtfFile); // 파일택스트
		jp.add(jlblFile); // 파일라밸
		jp.add(jtfmaxKey); // 1번입력
		jp.add(jlblmaxKey); // 1번출력
		jp.add(jtfbrowseronnect);// 2번입력
		jp.add(jtfbrowseronnect1);// 2번입력
		jp.add(jtfbrowseronnect2);// 2번입력
		jp.add(jtfbrowseronnect3);// 2번입력
		jp.add(jtfbrowseronnect4);// 2번입력
		jp.add(jtfbr1);// 2번입력
		jp.add(jtfbr2);// 2번입력
		jp.add(jtfbr3);// 2번입력
		jp.add(jtfbr4);// 2번입력
		jp.add(jtfbr5);// 2번입력
		jp.add(jlblbrowseronnect);// 2번출력
		jp.add(jtfserviceSucess);// 3번입력
		jp.add(jtfserviceSucess1);// 3번입력
		jp.add(jlblserviceSucess); // 3번출력
		jp.add(jlblserviceSucess1); // 3번출력
		jp.add(jlblserviceSucess2); // 3번출력
		jp.add(jtfrequestTime); // 4번입력
		jp.add(jlblrequestTime); // 4번출력
		jp.add(jtfrequest403); // 5번입력
		jp.add(jlblrequest403); // 5번출력
		jp.add(jtfrequest500); // 6번입력
		jp.add(jlblrequest500); // 6번출력

		jp.setLayout(null); // 사용자지정으로 꾸미기 위해
		jp.setBackground(new Color(0xF3F5F7)); // 패널색상
		add(jp); // 패널 추가

		bigFrame.setBounds(10, 20, 560, 530);
		img1.setBounds(0, 10, 300, 100); // 이미지라벨
		img2.setBounds(420, 30, 130, 160); // 이미지라벨
		jtfViewLine.setBounds(200, 515, 360, 25); // 선택파일 텍스트
		jtfFile.setBounds(110, 120, 150, 40); // 선택파일 텍스트
		jlblFile.setBounds(20, 120, 100, 40); // 선택파일 라벨
		emphasis1.setBounds(20, 170, 250, 3); // 선택파일 라벨

		jtfmaxKey.setBounds(110, 200, 150, 40); // 1번입력
		jlblmaxKey.setBounds(20, 200, 100, 40); // 1번라벨
		jtfbrowseronnect.setBounds(125, 275, 135, 20);// 2번입력
		jtfbrowseronnect1.setBounds(125, 300, 135, 20);// 2번입력
		jtfbrowseronnect2.setBounds(125, 325, 135, 20);// 2번입력
		jtfbrowseronnect3.setBounds(125, 350, 135, 20);// 2번입력
		jtfbrowseronnect4.setBounds(125, 375, 135, 20);// 2번입력
		jlblbrowseronnect.setBounds(20, 250, 100, 40);// 2번출력

		jtfbr1.setBounds(30, 275, 90, 20);// 2번문제출력
		jtfbr2.setBounds(30, 300, 90, 20);// 2번문제출력
		jtfbr3.setBounds(30, 325, 90, 20);// 2번문제출력
		jtfbr4.setBounds(30, 350, 90, 20);// 2번문제출력
		jtfbr5.setBounds(30, 375, 90, 20);// 2번문제출력

		jtfserviceSucess.setBounds(140, 420, 120, 40);// 3번입력
		jtfserviceSucess1.setBounds(140, 470, 120, 40);// 3번입력
		jlblserviceSucess.setBounds(20, 390, 100, 40); // 3번라벨
		jlblserviceSucess1.setBounds(25, 420, 150, 40); // 3번라벨
		jlblserviceSucess2.setBounds(25, 470, 150, 40); // 3번라벨
		jtfrequestTime.setBounds(400, 200, 150, 40); // 4번출력
		jlblrequestTime.setBounds(300, 200, 100, 40); // 4번라벨
		jtfrequest403.setBounds(400, 280, 150, 40); // 5번입력
		jlblrequest403.setBounds(300, 280, 100, 40); // 5번라벨
		jtfrequest500.setBounds(400, 380, 150, 40); // 6번입력
		jlblrequest500.setBounds(300, 380, 100, 40); // 6번출력

		ResultEvt rtevt = new ResultEvt(this); // resultEvt 객체

		setBounds(100, 100, 600, 600);// 윈도우사이즈
		setVisible(true); // 화면 보이게
		addWindowListener(rtevt); // 윈도우 이벤트
	}// Result

	/**
	 * 퍼센트를 시각화하기 위해 만든 메소드
	 * 
	 * @param cnt
	 * @param totalnum
	 * @return
	 */
	public String rateText(int cnt, int totalnum) {
		String result = "";
		double persent = (double) cnt / (double) totalnum * 100.0;
		int temp = ((int) persent / 10);
		if (persent > 9) {
			for (int i = 0; i < temp; i++) {
				result += "●";
			} // end for
			for (int i = 0; i < 10 - temp; i++) {
				result += "○";
			} // end for
		} else {
			if (persent != 0) {
				result = "◐○○○○○○○○○";
			} else {
				result = "○○○○○○○○○○";
			} // end else
		} // end else
		return result;
	}// rateTest

}// class
