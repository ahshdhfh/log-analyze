package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {

		private JTextField jtfId;
		private JPasswordField jpfPass;
		private String id;

	
	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}


	public JTextField getJtfId() {
			return jtfId;
		}


		public void setJtfId(JTextField jtfId) {
			this.jtfId = jtfId;
		}


		public JTextField getJpfPass() {
			return jpfPass;
		}


		public void setJpfPass(JPasswordField jpfPass) {
			this.jpfPass = jpfPass;
		}


	public Login() {
		
		super("Login Page");
		JLabel jlblinfo=new JLabel("<html><body>�ȳ��ϼ���<br>" + "<strong>4�� �α׺м�<strong> ���α׷��Դϴ�.</body></html>"); //�����
		jlblinfo.setFont(new Font("�������",Font.BOLD,20)); //
		jtfId=new JTextField(); //���̵��Է�â
		JLabel jlblId=new JLabel("ID"); //���̵��ؽ�Ʈ
		jtfId.setBorder(new LineBorder(Color.BLACK,2));
		jlblId.setFont(new Font("�������",Font.ITALIC,12)); //���̵�� ��Ʈ
		jlblId.setForeground(Color.BLACK); //���̵�� ����
		
		jpfPass=new JPasswordField("��й�ȣ"); //�н������Է�â
		jpfPass.setBorder(new LineBorder(Color.BLACK,2));
		jpfPass.setText("");
		JLabel jlblPw=new JLabel("Password"); //�н������ؽ�Ʈ
		jlblPw.setFont(new Font("�������",Font.ITALIC,12)); //�н������ ��Ʈ
		
		JButton jbtnlogin=new JButton("�α��� �ϱ�"); //�α��ι�ư 
		jbtnlogin.setFont(new Font("�������",Font.BOLD,23));//�α��ι�ư ��Ʈ
		jbtnlogin.setBackground(new Color(0x5929D0)); //�α��ι�ư ����
		jbtnlogin.setForeground(Color.WHITE);
		jbtnlogin.setBorder(new LineBorder(Color.BLACK,2));
		
		ImageIcon icon = new ImageIcon("E:/dev/workspace/javase_prj/src/project/as.jpg");//�̹�����ü 
		//JPanel�� �߰�
//		JPanel jp=new JPanel() {
//			public void paintComponent(Graphics g) {//�׸��� �Լ�
//				g.drawImage(icon.getImage(), 100,250,200,50,null);//background�� �׷���		
//				setOpaque(false); //����ȭ
//				super.paintComponent(g);
//			}
//		};
		JPanel jp=new JPanel();
		jp.setBackground(new Color(0xF3F5F7));
		jp.setLayout(null);	//3. ��ġ������ ����
		//4.��ġ
		jlblinfo.setBounds(100, 70, 300, 50); //
		jlblId.setBounds(100, 140, 300, 30); //�α����ؽ�Ʈ
		jtfId.setBounds(100, 170, 300, 40); //�α����Է�â
		jlblPw.setBounds(100, 220, 300, 30); //�н������ؽ�Ʈ
		jpfPass.setBounds(100, 250, 300, 40);//�н����� �Է�â
		jbtnlogin.setBounds(100,350,300,40); //�α��ι�ư 
		
		jp.add(jlblId);	//���̵��
		jp.add(jtfId);	//���̵��Է�â
		jp.add(jpfPass);	//�н������Է�â
		jp.add(jlblPw);	//�н������
		jp.add(jbtnlogin); //�α����Է¹�ư 
		jp.add(jlblinfo); //�α����Է¹�ư 
		
		add(jp); //JPanel�߰�
		LoginEvt lgevt=new LoginEvt(this); //�̺�Ʈ ��ü ����
		jbtnlogin.addActionListener(lgevt); //�׼��̺�Ʈ
		setBounds(100, 100, 500, 500);//�����������
		setResizable(false);
		setVisible(true);//����ȭ
		addWindowListener(lgevt);
	}//login
	
}
