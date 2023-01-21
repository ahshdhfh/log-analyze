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
	
	public Result(SelectMenu main,SelectmenuEvt smenu) {
		super(main, "Result", false);
		
		JTextField jtfViewLine=new JTextField(); //���������ý�Ʈâ
		jtfViewLine.setText("�� log ������ "+smenu.getCntLine()+"���̸�,"+main.getJtfLineinput().getText() +"������ �α׺м�����Դϴ�."); //���������ý�Ʈâ
		jtfViewLine.setEditable(false);
		jtfViewLine.setBorder(new LineBorder(Color.BLACK,1));
		jtfViewLine.setFont(new Font("�������",Font.BOLD,12)); 
		jtfViewLine.setBackground(new Color(0xF3F5F7));	
		
		JTextField jtfFile=new JTextField(); //���������ؽ�Ʈ
		jtfFile.setText(smenu.getfName()); //������ ���� �ؽ�Ʈâ����
		jtfFile.setEditable(false);
		jtfFile.setBorder(new LineBorder(Color.BLACK,2));
		jtfFile.setFont(new Font("�������",Font.BOLD,15)); 
		jtfFile.setBackground(Color.WHITE);
		JLabel jlblFile=new JLabel("������ ����: "); //�������϶�
		
		JTextField jtfmaxKey=new JTextField(); //1��
		jtfmaxKey.setText(smenu.getMostFrequentKey()+" / "+smenu.getMostFrequentKeyV()+"��");
		 jtfmaxKey.setEditable(false);
		 jtfmaxKey.setBorder(new LineBorder(Color.BLACK,2));
		 jtfmaxKey.setFont(new Font("�������",Font.BOLD,15)); 
		 jtfmaxKey.setBackground(Color.WHITE);
		JLabel jlblmaxKey=new JLabel("1. �ִ� ���Ű: "); //1�� ���: �ؽ�Ʈ
		
		JTextField jtfbrowseronnect=new JTextField(); //2��
		jtfbrowseronnect.setText(rateText(smenu.getIe(),smenu.getCntLine()));
		jtfbrowseronnect.setEditable(false);
		jtfbrowseronnect.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect.setFont(new Font("�������",Font.BOLD,12)); 
		jtfbrowseronnect.setBackground(Color.WHITE);
		JLabel jlblbrowseronnect=new JLabel("2. ������: "); //2�����: �ؽ�Ʈ

		
		JTextField jtfbrowseronnect1=new JTextField(); //2��_1
		jtfbrowseronnect1.setText(rateText(smenu.getFirefox(),smenu.getCntLine()));
		jtfbrowseronnect1.setEditable(false);
		jtfbrowseronnect1.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect1.setFont(new Font("�������",Font.BOLD,12)); 
		jtfbrowseronnect1.setBackground(Color.WHITE);
		
		JTextField jtfbrowseronnect2=new JTextField(); //2��_2
		jtfbrowseronnect2.setText(rateText(smenu.getChrome(),smenu.getCntLine()));
		jtfbrowseronnect2.setEditable(false);
		jtfbrowseronnect2.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect2.setFont(new Font("�������",Font.BOLD,12)); 
		jtfbrowseronnect2.setBackground(Color.WHITE);
		
		JTextField jtfbrowseronnect3=new JTextField(); //2��_3
		jtfbrowseronnect3.setText(rateText(smenu.getSafari(),smenu.getCntLine()));
		jtfbrowseronnect3.setEditable(false);
		jtfbrowseronnect3.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect3.setFont(new Font("�������",Font.BOLD,12)); 
		jtfbrowseronnect3.setBackground(Color.WHITE);		
		
		JTextField jtfbrowseronnect4=new JTextField(); //2��_4
		jtfbrowseronnect4.setText(rateText(smenu.getOpera(),smenu.getCntLine()));
		jtfbrowseronnect4.setEditable(false);
		jtfbrowseronnect4.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect4.setFont(new Font("�������",Font.BOLD,12)); 
		jtfbrowseronnect4.setBackground(Color.WHITE);	
		
		JTextField jtfbr1=new JTextField(); //2�������� IE
		jtfbr1.setText("IE : "+smenu.getIe()+"("+Math.round(((double)smenu.getIe()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr1.setEditable(false);
		jtfbr1.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr1.setFont(new Font("�������",Font.BOLD,10)); 
		jtfbr1.setBackground(Color.WHITE);
		
		JTextField jtfbr2=new JTextField(); //2�������� FireFox
		jtfbr2.setText("FireFox : "+smenu.getFirefox()+"("+Math.round(((double)smenu.getFirefox()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr2.setEditable(false);
		jtfbr2.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr2.setFont(new Font("�������",Font.BOLD,10)); 
		jtfbr2.setBackground(Color.WHITE);
		
		JTextField jtfbr3=new JTextField(); //2�������� Chrome
		jtfbr3.setText("Chrome : "+smenu.getChrome()+"("+Math.round(((double)smenu.getChrome()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr3.setEditable(false);
		jtfbr3.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr3.setFont(new Font("�������",Font.BOLD,10)); 
		jtfbr3.setBackground(Color.WHITE);
		
		
		JTextField jtfbr4=new JTextField(); //2�������� Safari
		jtfbr4.setText("Safari : "+smenu.getSafari()+"("+Math.round(((double)smenu.getSafari()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr4.setEditable(false);
		jtfbr4.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr4.setFont(new Font("�������",Font.BOLD,10)); 
		jtfbr4.setBackground(Color.WHITE);
		
		JTextField jtfbr5=new JTextField(); //2�������� Opera
		jtfbr5.setText("Opera : "+smenu.getOpera()+"("+Math.round(((double)smenu.getOpera()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr5.setEditable(false);
		jtfbr5.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr5.setFont(new Font("�������",Font.BOLD,10)); 
		jtfbr5.setBackground(Color.WHITE);
		
		
		
		JTextField jtfserviceSucess=new JTextField(); //3��
		jtfserviceSucess.setText(smenu.getCode200()+"��("+Math.round(((double)smenu.getCode200()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfserviceSucess.setEditable(false);
		jtfserviceSucess.setBorder(new LineBorder(Color.BLACK,2));
		jtfserviceSucess.setFont(new Font("�������",Font.BOLD,15)); 
		jtfserviceSucess.setBackground(Color.WHITE);
		JLabel jlblserviceSucess=new JLabel("3. ���� ����: "); //3�����: �ؽ�Ʈ
		JLabel jlblserviceSucess1=new JLabel("������ ����(200) : "); //3�����: �ؽ�Ʈ
		JLabel jlblserviceSucess2=new JLabel("������ ����(400) : "); //3�����: �ؽ�Ʈ
		
		JTextField jtfserviceSucess1=new JTextField(); //3��_����
		jtfserviceSucess1.setText(smenu.getCode404()+"��("+Math.round(((double)smenu.getCode404()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfserviceSucess1.setEditable(false);
		jtfserviceSucess1.setBorder(new LineBorder(Color.BLACK,2));
		jtfserviceSucess1.setFont(new Font("�������",Font.BOLD,15)); 
		jtfserviceSucess1.setBackground(Color.WHITE);
		
		JTextField jtfrequestTime=new JTextField(); //4��
		jtfrequestTime.setText(smenu.getMaxHourValue()+"��");
		jtfrequestTime.setEditable(false);
		jtfrequestTime.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequestTime.setFont(new Font("�������",Font.BOLD,15)); 
		jtfrequestTime.setBackground(Color.WHITE);
		JLabel jlblrequestTime=new JLabel("4. ��û�ð�: "); //4�����: �ؽ�Ʈ 
		
		JTextField jtfrequest403=new JTextField(); //5��
		jtfrequest403.setText(smenu.getCode403()+"��("+Math.round(((double)smenu.getCode403()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfrequest403.setEditable(false);
		jtfrequest403.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequest403.setFont(new Font("�������",Font.BOLD,15)); 
		jtfrequest403.setBackground(Color.WHITE);
		JLabel jlblrequest403=new JLabel("5. ��û403: "); //���̵��ؽ�Ʈ
		
		JTextField jtfrequest500=new JTextField(); //6��
		jtfrequest500.setText(smenu.getCode500()+"��("+Math.round(((double)smenu.getCode500()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfrequest500.setEditable(false);
		jtfrequest500.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequest500.setFont(new Font("�������",Font.BOLD,15)); 
		jtfrequest500.setBackground(Color.WHITE);
		JLabel jlblrequest500=new JLabel("6. ��û500: "); //���̵��ؽ�Ʈ
		
		ImageIcon icon = new ImageIcon("C:/dev/workspace/javase_prj/src/project/result.png");//�̹�����ü
		ImageIcon iconSist = new ImageIcon("C:/dev/workspace/javase_prj/src/project/sist.png");//�̹�����ü
		JLabel img1=new JLabel(icon); //���̵��ؽ�Ʈ
		JLabel img2=new JLabel(iconSist); //���̵��ؽ�Ʈ
		
		JLabel bigFrame=new JLabel();//��Ŀ� ūƲ
		bigFrame.setBorder(new LineBorder(Color.BLACK,4));
		
		JLabel emphasis1=new JLabel();//��������â ������
		emphasis1.setBorder(new LineBorder(Color.BLACK,3));
		
		JPanel jp=new JPanel();
		jp.add(bigFrame); //��Ŀ� ūƲ
		jp.add(emphasis1); //��Ŀ� ūƲ
		jp.add(img1); //result�̹���
		jp.add(img2); //sist�̹���
		jp.add(jtfViewLine); //�����ý�Ʈ
		jp.add(jtfFile); //�����ý�Ʈ
		jp.add(jlblFile); //���϶��
		jp.add(jtfmaxKey); //1���Է�
		jp.add(jlblmaxKey); //1�����
		jp.add(jtfbrowseronnect);//2���Է�
		jp.add(jtfbrowseronnect1);//2���Է�
		jp.add(jtfbrowseronnect2);//2���Է�
		jp.add(jtfbrowseronnect3);//2���Է�
		jp.add(jtfbrowseronnect4);//2���Է�
		jp.add(jtfbr1);//2���Է�
		jp.add(jtfbr2);//2���Է�
		jp.add(jtfbr3);//2���Է�
		jp.add(jtfbr4);//2���Է�
		jp.add(jtfbr5);//2���Է�
		jp.add(jlblbrowseronnect);//2�����
		jp.add(jtfserviceSucess);//3���Է�
		jp.add(jtfserviceSucess1);//3���Է�
		jp.add(jlblserviceSucess); //3�����
		jp.add(jlblserviceSucess1); //3�����
		jp.add(jlblserviceSucess2); //3�����
		jp.add(jtfrequestTime); //4���Է�
		jp.add(jlblrequestTime); //4�����
		jp.add(jtfrequest403); //5���Է�
		jp.add(jlblrequest403); //5�����
		jp.add(jtfrequest500); //6���Է�
		jp.add(jlblrequest500); //6�����
		jp.setLayout(null);
		jp.setBackground(new Color(0xF3F5F7));
		add(jp);
		bigFrame.setBounds(10,20,560,530);
		img1.setBounds(0,10,300,100); //�̹�����
		img2.setBounds(420,30,130,160); //�̹�����
		jtfViewLine.setBounds(200,515,360,25); //�������� �ؽ�Ʈ
		jtfFile.setBounds(110,120,150,40); //�������� �ؽ�Ʈ
		jlblFile.setBounds(20,120,100,40); //�������� ��
		emphasis1.setBounds(20,170,250,3); //�������� ��
		
		jtfmaxKey.setBounds(110,200,150,40); //1���Է�
		jlblmaxKey.setBounds(20,200,100,40); //1����
		jtfbrowseronnect.setBounds(125,275,135,20);//2���Է�
		jtfbrowseronnect1.setBounds(125,300,135,20);//2���Է�
		jtfbrowseronnect2.setBounds(125,325,135,20);//2���Է�
		jtfbrowseronnect3.setBounds(125,350,135,20);//2���Է�
		jtfbrowseronnect4.setBounds(125,375,135,20);//2���Է�
		jlblbrowseronnect.setBounds(20,250,100,40);//2�����ad
		jtfbr1.setBounds(30,275,90,20);//2�����
		jtfbr2.setBounds(30,300,90,20);//2�����
		jtfbr3.setBounds(30,325,90,20);//2�����
		jtfbr4.setBounds(30,350,90,20);//2�����
		jtfbr5.setBounds(30,375,90,20);//2�����
		jtfserviceSucess.setBounds(140,420,120,40);//3���Է�
		jtfserviceSucess1.setBounds(140,470,120,40);//3���Է�
		jlblserviceSucess.setBounds(20,390,100,40); //3����
		jlblserviceSucess1.setBounds(25,420,150,40); //3����
		jlblserviceSucess2.setBounds(25,470,150,40); //3����
		jtfrequestTime.setBounds(400,200,150,40); //4�����
		jlblrequestTime.setBounds(300,200,100,40); //4����
		jtfrequest403.setBounds(400,280,150,40); //5���Է�
		jlblrequest403.setBounds(300,280,100,40); //5����
		jtfrequest500.setBounds(400,380,150,40); //6���Է�
		jlblrequest500.setBounds(300,380,100,40); //6�����
		
		ResultEvt rtevt=new ResultEvt(this);

		setBounds(100, 100, 600, 600);//�����������
		setVisible(true);
		addWindowListener(rtevt);
	}//Result
	
	public String rateText(int cnt,int totalnum) {
		String result="";
		double persent=(double)cnt/(double)totalnum*100.0;
		int temp=((int)persent/10);
		if(persent>9) {
		for(int i=0;i<temp;i++){
			result+="��";
		}
		for(int i=0;i<10-temp;i++){
			result+="��";
		}
		}else {
			if(persent !=0) {
				result="�ġۡۡۡۡۡۡۡۡ�";
			}else {
				result="�ۡۡۡۡۡۡۡۡۡ�";
			}
		}
		return result;
	}
	
}
