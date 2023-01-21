package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JTextField jtfId; // id를 입력받을 아이디창
	private JPasswordField jpfPass; // password를 입력받을 패스워드창
	private String id; // 입력한 id 값

	public String getId() {
		return id;
	}// getId

	public void setId(String id) {
		this.id = id;
	}// setId

	public JTextField getJtfId() {
		return jtfId;
	}// getJtfId

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}// setJtfId

	public JTextField getJpfPass() {
		return jpfPass;
	}// getJpfPass

	public void setJpfPass(JPasswordField jpfPass) {
		this.jpfPass = jpfPass;
	}// setJpfPass

	public Login() {

		super("Login Page");
		JLabel jlblinfo = new JLabel("<html><body>안녕하세요<br>" + "<strong>4조 로그분석<strong> 프로그램입니다.</body></html>"); // 설명라벨
		jlblinfo.setFont(new Font("맑은고딕", Font.BOLD, 20)); // 폰트설정
		jtfId = new JTextField(); // 아이디입력창
		JLabel jlblId = new JLabel("ID"); // 아이디텍스트
		jtfId.setBorder(new LineBorder(Color.BLACK, 2)); // 라인보드로 강조역할
		jlblId.setFont(new Font("맑은고딕", Font.ITALIC, 12)); // 아이디라벨 폰트
		jlblId.setForeground(Color.BLACK); // 아이디라벨 색깔

		jpfPass = new JPasswordField("비밀번호"); // 패스워드입력창
		jpfPass.setBorder(new LineBorder(Color.BLACK, 2));// 라인보드로 강조역할
		jpfPass.setText(""); // 패스워드 초기세팅
		JLabel jlblPw = new JLabel("Password"); // 패스워드텍스트
		jlblPw.setFont(new Font("맑은고딕", Font.ITALIC, 12)); // 패스워드라벨 폰트

		JButton jbtnlogin = new JButton("로그인 하기"); // 로그인버튼
		jbtnlogin.setFont(new Font("맑은고딕", Font.BOLD, 23));// 로그인버튼 폰트
		jbtnlogin.setBackground(new Color(0x5929D0)); // 로그인버튼 색상
		jbtnlogin.setForeground(Color.WHITE); // 색상설정
		jbtnlogin.setBorder(new LineBorder(Color.BLACK, 2));// 라인보드로 강조역할

		JPanel jp = new JPanel();
		jp.setBackground(new Color(0xF3F5F7)); // 패널색상설정
		jp.setLayout(null); // 3. 배치관리자 설정

		// 4.배치
		jlblinfo.setBounds(100, 70, 300, 50); // 라벨
		jlblId.setBounds(100, 140, 300, 30); // 로그인텍스트
		jtfId.setBounds(100, 170, 300, 40); // 로그인입력창
		jlblPw.setBounds(100, 220, 300, 30); // 패스워드텍스트
		jpfPass.setBounds(100, 250, 300, 40);// 패스워드 입력창
		jbtnlogin.setBounds(100, 350, 300, 40); // 로그인버튼

		jp.add(jlblId); // 아이디라벨
		jp.add(jtfId); // 아이디입력창
		jp.add(jpfPass); // 패스워드입력창
		jp.add(jlblPw); // 패스워드라벨
		jp.add(jbtnlogin); // 로그인입력버튼
		jp.add(jlblinfo); // 로그인입력버튼

		add(jp); // JPanel추가
		LoginEvt lgevt = new LoginEvt(this); // 이벤트 객체 생성
		jbtnlogin.addActionListener(lgevt); // 액션이벤트
		setBounds(100, 100, 500, 500);// 윈도우사이즈
		setResizable(false); // 크기못줄이게
		setVisible(true);// 가시화
		addWindowListener(lgevt); // 윈도우이벤트 추가
	}// login

}
