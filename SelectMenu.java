package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SelectMenu extends JDialog {
	

	private JButton jbtnView; //뷰버튼
	private JButton jbtnReport;//레포트버튼
	private JTextField jtfLineinput;//원하는 줄 입력텍스트필드
	private JTextField jtfFileNameInput;//원하는 줄 입력텍스트필드
	private JButton jbtnFileSelect;//파일선택한거 띄우는용도
	

	public void JtextFilememo(String name) {
		jtfFileNameInput.setText(name);
	}
	
	
	public JButton getJbtnView() {
		return jbtnView;
	}

	public JTextField getJtfFileNameInput() {
		return jtfFileNameInput;
	}



	public JButton getJbtnFileSelect() {
		return jbtnFileSelect;
	}

	public void setJbtnFileSelect(JButton jbtnFileSelect) {
		this.jbtnFileSelect = jbtnFileSelect;
	}

	public void setJbtnView(JButton jbtnView) {
		this.jbtnView = jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

	public void setJbtnReport(JButton jbtnReport) {
		this.jbtnReport = jbtnReport;
	}

	public JTextField getJtfLineinput() {
		return jtfLineinput;
	}

	public void setJtfLineinput(JTextField jtfLineinput) {
		this.jtfLineinput = jtfLineinput;
	}

	public SelectMenu(Login lg) {
		super(lg, "Select Menu", false);
		lg.dispose(); //로그인창 닫아버리기
		System.out.println(lg.getId());
		jtfLineinput=new JTextField(); //줄입력창
		jtfLineinput.setBorder(new LineBorder(Color.BLACK,2));
		JLabel jlblLineinput=new JLabel("원하는 라인 범위를 입력해주세요. ex)100~1500"); //줄입력
		jlblLineinput.setFont(new Font("맑은고딕",Font.BOLD,18));	
		JLabel jlblLineinput1=new JLabel("ex)100~1500"); //줄입력
		jlblLineinput1.setFont(new Font("맑은고딕",Font.ITALIC,12));	
		
		
		jbtnView=new JButton("View"); //뷰버튼 
		jbtnView.setFont(new Font("맑은고딕",Font.ITALIC,25));
		jbtnView.setBackground(new Color(0x5929D0));
		jbtnView.setForeground(Color.WHITE);
		jbtnView.setBorder(new LineBorder(Color.BLACK,2));
		
		jbtnReport=new JButton("Report"); //레포트버튼 
		jbtnReport.setFont(new Font("맑은고딕",Font.ITALIC,25));
		jbtnReport.setBackground(new Color(0x5929D0));
		jbtnReport.setForeground(Color.WHITE);
		jbtnReport.setBorder(new LineBorder(Color.BLACK,2));
		
		JLabel jlblFile=new JLabel("분석할 파일을 선택해주세요"); //파일선택라벨
		jlblFile.setFont(new Font("맑은고딕",Font.BOLD,18)); //파일선택라벨 폰트
		
		jbtnFileSelect=new JButton("파일선택"); //뷰버튼 
		jbtnFileSelect.setFont(new Font("맑은고딕",Font.ITALIC,12));
		jbtnFileSelect.setBackground(new Color(0x5929D0));
		jbtnFileSelect.setForeground(Color.WHITE);
		jbtnFileSelect.setBorder(new LineBorder(Color.BLACK,2));
		
		jtfFileNameInput=new JTextField(); //줄입력창
		jtfFileNameInput.setEditable(false);
		jtfFileNameInput.setBorder(new LineBorder(Color.BLACK,1));
		jtfFileNameInput.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfFileNameInput.setBackground(new Color(0xF3F5F7));	

		JPanel jp=new JPanel();		
		jp.setLayout(null);
		jp.setBackground(new Color(0xF3F5F7));
		//4.배치
		jp.add(jtfLineinput);// 줄입력텍스트창
		jp.add(jlblLineinput);//줄입력라벨
		jp.add(jlblLineinput1);//줄입력라벨
		jp.add(jbtnView);// view버튼
		jp.add(jbtnReport);//report버튼
		jp.add(jlblFile);//report버튼
		jp.add(jtfFileNameInput);//
		jp.add(jbtnFileSelect);//
		add(jp);
		jlblFile.setBounds(100, 50, 300, 50); // 줄입력라벨
		jtfFileNameInput.setBounds(100, 100, 200, 30); // 파일선택한거 보여줌
		jbtnFileSelect.setBounds(305, 100, 95, 30); // 파일선택버튼
		jlblLineinput.setBounds(100, 160, 300, 30); // 줄입력라벨
		jlblLineinput1.setBounds(100, 180, 300, 30); // 줄입력라벨
		jtfLineinput.setBounds(100, 210, 300, 30); // 줄입력텍스트창
		jbtnView.setBounds(100,280,300,50); // 뷰버튼
		jbtnReport.setBounds(100,350,300,50); // 레포트버튼
		
		SelectmenuEvt selectEvt=new SelectmenuEvt(this,lg); //이벤트 객체 생성
		jbtnView.addActionListener(selectEvt); //액션이벤트
		jbtnReport.addActionListener(selectEvt); //액션이벤트
		jbtnFileSelect.addActionListener(selectEvt);
		setBounds(100, 100, 500, 500);//윈도우사이즈
		setVisible(true);//가시화
		addWindowListener(selectEvt);
		
	}
	
}
