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
	

	private JButton jbtnView; //���ư
	private JButton jbtnReport;//����Ʈ��ư
	private JTextField jtfLineinput;//���ϴ� �� �Է��ؽ�Ʈ�ʵ�
	private JTextField jtfFileNameInput;//���ϴ� �� �Է��ؽ�Ʈ�ʵ�
	private JButton jbtnFileSelect;//���ϼ����Ѱ� ���¿뵵
	

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
		lg.dispose(); //�α���â �ݾƹ�����
		System.out.println(lg.getId());
		jtfLineinput=new JTextField(); //���Է�â
		jtfLineinput.setBorder(new LineBorder(Color.BLACK,2));
		JLabel jlblLineinput=new JLabel("���ϴ� ���� ������ �Է����ּ���. ex)100~1500"); //���Է�
		jlblLineinput.setFont(new Font("�������",Font.BOLD,18));	
		JLabel jlblLineinput1=new JLabel("ex)100~1500"); //���Է�
		jlblLineinput1.setFont(new Font("�������",Font.ITALIC,12));	
		
		
		jbtnView=new JButton("View"); //���ư 
		jbtnView.setFont(new Font("�������",Font.ITALIC,25));
		jbtnView.setBackground(new Color(0x5929D0));
		jbtnView.setForeground(Color.WHITE);
		jbtnView.setBorder(new LineBorder(Color.BLACK,2));
		
		jbtnReport=new JButton("Report"); //����Ʈ��ư 
		jbtnReport.setFont(new Font("�������",Font.ITALIC,25));
		jbtnReport.setBackground(new Color(0x5929D0));
		jbtnReport.setForeground(Color.WHITE);
		jbtnReport.setBorder(new LineBorder(Color.BLACK,2));
		
		JLabel jlblFile=new JLabel("�м��� ������ �������ּ���"); //���ϼ��ö�
		jlblFile.setFont(new Font("�������",Font.BOLD,18)); //���ϼ��ö� ��Ʈ
		
		jbtnFileSelect=new JButton("���ϼ���"); //���ư 
		jbtnFileSelect.setFont(new Font("�������",Font.ITALIC,12));
		jbtnFileSelect.setBackground(new Color(0x5929D0));
		jbtnFileSelect.setForeground(Color.WHITE);
		jbtnFileSelect.setBorder(new LineBorder(Color.BLACK,2));
		
		jtfFileNameInput=new JTextField(); //���Է�â
		jtfFileNameInput.setEditable(false);
		jtfFileNameInput.setBorder(new LineBorder(Color.BLACK,1));
		jtfFileNameInput.setFont(new Font("�������",Font.BOLD,12)); 
		jtfFileNameInput.setBackground(new Color(0xF3F5F7));	

		JPanel jp=new JPanel();		
		jp.setLayout(null);
		jp.setBackground(new Color(0xF3F5F7));
		//4.��ġ
		jp.add(jtfLineinput);// ���Է��ؽ�Ʈâ
		jp.add(jlblLineinput);//���Է¶�
		jp.add(jlblLineinput1);//���Է¶�
		jp.add(jbtnView);// view��ư
		jp.add(jbtnReport);//report��ư
		jp.add(jlblFile);//report��ư
		jp.add(jtfFileNameInput);//
		jp.add(jbtnFileSelect);//
		add(jp);
		jlblFile.setBounds(100, 50, 300, 50); // ���Է¶�
		jtfFileNameInput.setBounds(100, 100, 200, 30); // ���ϼ����Ѱ� ������
		jbtnFileSelect.setBounds(305, 100, 95, 30); // ���ϼ��ù�ư
		jlblLineinput.setBounds(100, 160, 300, 30); // ���Է¶�
		jlblLineinput1.setBounds(100, 180, 300, 30); // ���Է¶�
		jtfLineinput.setBounds(100, 210, 300, 30); // ���Է��ؽ�Ʈâ
		jbtnView.setBounds(100,280,300,50); // ���ư
		jbtnReport.setBounds(100,350,300,50); // ����Ʈ��ư
		
		SelectmenuEvt selectEvt=new SelectmenuEvt(this,lg); //�̺�Ʈ ��ü ����
		jbtnView.addActionListener(selectEvt); //�׼��̺�Ʈ
		jbtnReport.addActionListener(selectEvt); //�׼��̺�Ʈ
		jbtnFileSelect.addActionListener(selectEvt);
		setBounds(100, 100, 500, 500);//�����������
		setVisible(true);//����ȭ
		addWindowListener(selectEvt);
		
	}
	
}
