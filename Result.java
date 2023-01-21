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
		
		JTextField jtfViewLine=new JTextField(); //범위선택택스트창
		jtfViewLine.setText("총 log 개수는 "+smenu.getCntLine()+"개이며,"+main.getJtfLineinput().getText() +"범위의 로그분석결과입니다."); //범위선택택스트창
		jtfViewLine.setEditable(false);
		jtfViewLine.setBorder(new LineBorder(Color.BLACK,1));
		jtfViewLine.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfViewLine.setBackground(new Color(0xF3F5F7));	
		
		JTextField jtfFile=new JTextField(); //선택파일텍스트
		jtfFile.setText(smenu.getfName()); //선택한 파일 텍스트창으로
		jtfFile.setEditable(false);
		jtfFile.setBorder(new LineBorder(Color.BLACK,2));
		jtfFile.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfFile.setBackground(Color.WHITE);
		JLabel jlblFile=new JLabel("선택한 파일: "); //선택파일라벨
		
		JTextField jtfmaxKey=new JTextField(); //1번
		jtfmaxKey.setText(smenu.getMostFrequentKey()+" / "+smenu.getMostFrequentKeyV()+"개");
		 jtfmaxKey.setEditable(false);
		 jtfmaxKey.setBorder(new LineBorder(Color.BLACK,2));
		 jtfmaxKey.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		 jtfmaxKey.setBackground(Color.WHITE);
		JLabel jlblmaxKey=new JLabel("1. 최다 사용키: "); //1번 결과: 텍스트
		
		JTextField jtfbrowseronnect=new JTextField(); //2번
		jtfbrowseronnect.setText(rateText(smenu.getIe(),smenu.getCntLine()));
		jtfbrowseronnect.setEditable(false);
		jtfbrowseronnect.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfbrowseronnect.setBackground(Color.WHITE);
		JLabel jlblbrowseronnect=new JLabel("2. 브라우저: "); //2번결과: 텍스트

		
		JTextField jtfbrowseronnect1=new JTextField(); //2번_1
		jtfbrowseronnect1.setText(rateText(smenu.getFirefox(),smenu.getCntLine()));
		jtfbrowseronnect1.setEditable(false);
		jtfbrowseronnect1.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect1.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfbrowseronnect1.setBackground(Color.WHITE);
		
		JTextField jtfbrowseronnect2=new JTextField(); //2번_2
		jtfbrowseronnect2.setText(rateText(smenu.getChrome(),smenu.getCntLine()));
		jtfbrowseronnect2.setEditable(false);
		jtfbrowseronnect2.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect2.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfbrowseronnect2.setBackground(Color.WHITE);
		
		JTextField jtfbrowseronnect3=new JTextField(); //2번_3
		jtfbrowseronnect3.setText(rateText(smenu.getSafari(),smenu.getCntLine()));
		jtfbrowseronnect3.setEditable(false);
		jtfbrowseronnect3.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect3.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfbrowseronnect3.setBackground(Color.WHITE);		
		
		JTextField jtfbrowseronnect4=new JTextField(); //2번_4
		jtfbrowseronnect4.setText(rateText(smenu.getOpera(),smenu.getCntLine()));
		jtfbrowseronnect4.setEditable(false);
		jtfbrowseronnect4.setBorder(new LineBorder(Color.BLACK,2));
		jtfbrowseronnect4.setFont(new Font("맑은고딕",Font.BOLD,12)); 
		jtfbrowseronnect4.setBackground(Color.WHITE);	
		
		JTextField jtfbr1=new JTextField(); //2번브라우저 IE
		jtfbr1.setText("IE : "+smenu.getIe()+"("+Math.round(((double)smenu.getIe()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr1.setEditable(false);
		jtfbr1.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr1.setFont(new Font("맑은고딕",Font.BOLD,10)); 
		jtfbr1.setBackground(Color.WHITE);
		
		JTextField jtfbr2=new JTextField(); //2번브라우저 FireFox
		jtfbr2.setText("FireFox : "+smenu.getFirefox()+"("+Math.round(((double)smenu.getFirefox()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr2.setEditable(false);
		jtfbr2.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr2.setFont(new Font("맑은고딕",Font.BOLD,10)); 
		jtfbr2.setBackground(Color.WHITE);
		
		JTextField jtfbr3=new JTextField(); //2번브라우저 Chrome
		jtfbr3.setText("Chrome : "+smenu.getChrome()+"("+Math.round(((double)smenu.getChrome()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr3.setEditable(false);
		jtfbr3.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr3.setFont(new Font("맑은고딕",Font.BOLD,10)); 
		jtfbr3.setBackground(Color.WHITE);
		
		
		JTextField jtfbr4=new JTextField(); //2번브라우저 Safari
		jtfbr4.setText("Safari : "+smenu.getSafari()+"("+Math.round(((double)smenu.getSafari()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr4.setEditable(false);
		jtfbr4.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr4.setFont(new Font("맑은고딕",Font.BOLD,10)); 
		jtfbr4.setBackground(Color.WHITE);
		
		JTextField jtfbr5=new JTextField(); //2번브라우저 Opera
		jtfbr5.setText("Opera : "+smenu.getOpera()+"("+Math.round(((double)smenu.getOpera()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfbr5.setEditable(false);
		jtfbr5.setBorder(new LineBorder(Color.BLACK,2));
		jtfbr5.setFont(new Font("맑은고딕",Font.BOLD,10)); 
		jtfbr5.setBackground(Color.WHITE);
		
		
		
		JTextField jtfserviceSucess=new JTextField(); //3번
		jtfserviceSucess.setText(smenu.getCode200()+"개("+Math.round(((double)smenu.getCode200()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfserviceSucess.setEditable(false);
		jtfserviceSucess.setBorder(new LineBorder(Color.BLACK,2));
		jtfserviceSucess.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfserviceSucess.setBackground(Color.WHITE);
		JLabel jlblserviceSucess=new JLabel("3. 서비스 성공: "); //3번결과: 텍스트
		JLabel jlblserviceSucess1=new JLabel("성공한 서비스(200) : "); //3번결과: 텍스트
		JLabel jlblserviceSucess2=new JLabel("실패한 서비스(400) : "); //3번결과: 텍스트
		
		JTextField jtfserviceSucess1=new JTextField(); //3번_실패
		jtfserviceSucess1.setText(smenu.getCode404()+"개("+Math.round(((double)smenu.getCode404()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfserviceSucess1.setEditable(false);
		jtfserviceSucess1.setBorder(new LineBorder(Color.BLACK,2));
		jtfserviceSucess1.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfserviceSucess1.setBackground(Color.WHITE);
		
		JTextField jtfrequestTime=new JTextField(); //4번
		jtfrequestTime.setText(smenu.getMaxHourValue()+"시");
		jtfrequestTime.setEditable(false);
		jtfrequestTime.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequestTime.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfrequestTime.setBackground(Color.WHITE);
		JLabel jlblrequestTime=new JLabel("4. 요청시간: "); //4번결과: 텍스트 
		
		JTextField jtfrequest403=new JTextField(); //5번
		jtfrequest403.setText(smenu.getCode403()+"개("+Math.round(((double)smenu.getCode403()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfrequest403.setEditable(false);
		jtfrequest403.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequest403.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfrequest403.setBackground(Color.WHITE);
		JLabel jlblrequest403=new JLabel("5. 요청403: "); //아이디텍스트
		
		JTextField jtfrequest500=new JTextField(); //6번
		jtfrequest500.setText(smenu.getCode500()+"개("+Math.round(((double)smenu.getCode500()/(double)smenu.getCntLine()*100.0))+"%)");
		jtfrequest500.setEditable(false);
		jtfrequest500.setBorder(new LineBorder(Color.BLACK,2));
		jtfrequest500.setFont(new Font("맑은고딕",Font.BOLD,15)); 
		jtfrequest500.setBackground(Color.WHITE);
		JLabel jlblrequest500=new JLabel("6. 요청500: "); //아이디텍스트
		
		ImageIcon icon = new ImageIcon("C:/dev/workspace/javase_prj/src/project/result.png");//이미지객체
		ImageIcon iconSist = new ImageIcon("C:/dev/workspace/javase_prj/src/project/sist.png");//이미지객체
		JLabel img1=new JLabel(icon); //아이디텍스트
		JLabel img2=new JLabel(iconSist); //아이디텍스트
		
		JLabel bigFrame=new JLabel();//장식용 큰틀
		bigFrame.setBorder(new LineBorder(Color.BLACK,4));
		
		JLabel emphasis1=new JLabel();//선택파일창 강조라벨
		emphasis1.setBorder(new LineBorder(Color.BLACK,3));
		
		JPanel jp=new JPanel();
		jp.add(bigFrame); //장식용 큰틀
		jp.add(emphasis1); //장식용 큰틀
		jp.add(img1); //result이미지
		jp.add(img2); //sist이미지
		jp.add(jtfViewLine); //범위택스트
		jp.add(jtfFile); //파일택스트
		jp.add(jlblFile); //파일라밸
		jp.add(jtfmaxKey); //1번입력
		jp.add(jlblmaxKey); //1번출력
		jp.add(jtfbrowseronnect);//2번입력
		jp.add(jtfbrowseronnect1);//2번입력
		jp.add(jtfbrowseronnect2);//2번입력
		jp.add(jtfbrowseronnect3);//2번입력
		jp.add(jtfbrowseronnect4);//2번입력
		jp.add(jtfbr1);//2번입력
		jp.add(jtfbr2);//2번입력
		jp.add(jtfbr3);//2번입력
		jp.add(jtfbr4);//2번입력
		jp.add(jtfbr5);//2번입력
		jp.add(jlblbrowseronnect);//2번출력
		jp.add(jtfserviceSucess);//3번입력
		jp.add(jtfserviceSucess1);//3번입력
		jp.add(jlblserviceSucess); //3번출력
		jp.add(jlblserviceSucess1); //3번출력
		jp.add(jlblserviceSucess2); //3번출력
		jp.add(jtfrequestTime); //4번입력
		jp.add(jlblrequestTime); //4번출력
		jp.add(jtfrequest403); //5번입력
		jp.add(jlblrequest403); //5번출력
		jp.add(jtfrequest500); //6번입력
		jp.add(jlblrequest500); //6번출력
		jp.setLayout(null);
		jp.setBackground(new Color(0xF3F5F7));
		add(jp);
		bigFrame.setBounds(10,20,560,530);
		img1.setBounds(0,10,300,100); //이미지라벨
		img2.setBounds(420,30,130,160); //이미지라벨
		jtfViewLine.setBounds(200,515,360,25); //선택파일 텍스트
		jtfFile.setBounds(110,120,150,40); //선택파일 텍스트
		jlblFile.setBounds(20,120,100,40); //선택파일 라벨
		emphasis1.setBounds(20,170,250,3); //선택파일 라벨
		
		jtfmaxKey.setBounds(110,200,150,40); //1번입력
		jlblmaxKey.setBounds(20,200,100,40); //1번라벨
		jtfbrowseronnect.setBounds(125,275,135,20);//2번입력
		jtfbrowseronnect1.setBounds(125,300,135,20);//2번입력
		jtfbrowseronnect2.setBounds(125,325,135,20);//2번입력
		jtfbrowseronnect3.setBounds(125,350,135,20);//2번입력
		jtfbrowseronnect4.setBounds(125,375,135,20);//2번입력
		jlblbrowseronnect.setBounds(20,250,100,40);//2번출력ad
		jtfbr1.setBounds(30,275,90,20);//2번출력
		jtfbr2.setBounds(30,300,90,20);//2번출력
		jtfbr3.setBounds(30,325,90,20);//2번출력
		jtfbr4.setBounds(30,350,90,20);//2번출력
		jtfbr5.setBounds(30,375,90,20);//2번출력
		jtfserviceSucess.setBounds(140,420,120,40);//3번입력
		jtfserviceSucess1.setBounds(140,470,120,40);//3번입력
		jlblserviceSucess.setBounds(20,390,100,40); //3번라벨
		jlblserviceSucess1.setBounds(25,420,150,40); //3번라벨
		jlblserviceSucess2.setBounds(25,470,150,40); //3번라벨
		jtfrequestTime.setBounds(400,200,150,40); //4번출력
		jlblrequestTime.setBounds(300,200,100,40); //4번라벨
		jtfrequest403.setBounds(400,280,150,40); //5번입력
		jlblrequest403.setBounds(300,280,100,40); //5번라벨
		jtfrequest500.setBounds(400,380,150,40); //6번입력
		jlblrequest500.setBounds(300,380,100,40); //6번출력
		
		ResultEvt rtevt=new ResultEvt(this);

		setBounds(100, 100, 600, 600);//윈도우사이즈
		setVisible(true);
		addWindowListener(rtevt);
	}//Result
	
	public String rateText(int cnt,int totalnum) {
		String result="";
		double persent=(double)cnt/(double)totalnum*100.0;
		int temp=((int)persent/10);
		if(persent>9) {
		for(int i=0;i<temp;i++){
			result+="●";
		}
		for(int i=0;i<10-temp;i++){
			result+="○";
		}
		}else {
			if(persent !=0) {
				result="◐○○○○○○○○○";
			}else {
				result="○○○○○○○○○○";
			}
		}
		return result;
	}
	
}
