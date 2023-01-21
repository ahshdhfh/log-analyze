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
	String filePath = "C:/dev/workspace/javase_prj/src/project/";//������Ʈ\1��\SIST_ANAL_01�䱸�������Ǽ�;//�ҷ��� ���� ���
	String fName;//�ҷ��� ���� �̸�
	String logTxtCreationDate;//�α����� ��¥ ��Ͽ�
	String[] browser;//���� ������ ��Ͽ� �迭
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

	String[] log;//�� �� �ϳ��� �α� ���پ� 
	//ex)[200][http://sist.co.kr/find/new?key=res&query=sist][ie][2023-01-16 11:11:43]
	List<String> token;//���ϳ��� ��ū �ϳ��� 
	//ex) [200, [500
	
	private String data;
	private int totalCntLine;//�� ȣ��� Ƚ��! ** �޼��忡 ���
	private int cntLine;
	private int maxHourValue;//�ð�
	int[] hour= new int[24];
	
	Map<String, Integer>key=new HashMap<String, Integer>(); //1�� �׽�Ʈ
	

	private int ie;//������ ī��Ʈ
	private int firefox;//������ ī��Ʈ
	private int opera;//������ ī��Ʈ
	private int chrome;//������ ī��Ʈ
	private int safari;//������ ī��Ʈ
	
	private int code200;//�ڵ� 200�� ���� Ƚ��
	private int code404;//�ڵ� 404�� ���� Ƚ��
	private int code403;//�ڵ� 403�� ���� Ƚ��
	private int code500;//�ڵ� 403�� ���� Ƚ��
	private int startLine;
	private int endLine;
	
	private String mostFrequentHour;//���� ��û�� ���� �ð�
	private String mostFrequentKey;//���� ��û�� ���� Ű
	private int mostFrequentKeyV;//���� ��û�� ���� Ű�� ��
	
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
		code200=0;//�ڵ� 200�� ���� Ƚ��
		code404=0;//�ڵ� 404�� ���� Ƚ��
		code403=0;//�ڵ� 403�� ���� Ƚ��
		code500=0;//�ڵ� 403�� ���� Ƚ��
		
		mostFrequentHour="";//���� ��û�� ���� �ð�
		mostFrequentKey="";//���� ��û�� ���� Ű
		mostFrequentKeyV=0;//���� ��û�� ���� Ű�� ��
		
		ie=0;//������ ī��Ʈ
		firefox=0;//������ ī��Ʈ
		opera=0;//������ ī��Ʈ
		chrome=0;//������ ī��Ʈ
		safari=0;//������ ī��Ʈ
		
		cntLine=0;
		totalCntLine=0;//�� ȣ��� Ƚ��! ** �޼��忡 ���
		
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
	 * ��ư ������ �߻��ϴ� �޼��� �Է��ϱ�
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
				// max�� ���ϴ� �޼ҵ�
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Result(sm,this);
			}else {
				JOptionPane.showMessageDialog(sm, "�ٽ��Է����ּ���");
			}
			}else {
				JOptionPane.showMessageDialog(sm, "�����ϴ� ���� ������ �ƴմϴ�. ������ �ٽ� �������ּ���");
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
				JOptionPane.showMessageDialog(sm, "������ ������ �� �ִ� ������ ����");
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
				JOptionPane.showMessageDialog(sm, "�ٽ��Է����ּ���");
			}
			}else {
				JOptionPane.showMessageDialog(sm, "�����ϴ� ���� ������ �ƴմϴ�. ������ �ٽ� �������ּ���");
			}
		}//end if
		
		if(ae.getSource()==sm.getJbtnFileSelect()) {
			FileDialog fdOpen=new FileDialog(sm, "���� ����", FileDialog.LOAD);
			fdOpen.setVisible(true);
			filePath=fdOpen.getDirectory();
			fName=fdOpen.getFile();
			sm.JtextFilememo(fName);
		}//end if
	}//actionPerformed
	
	
	public void readLog() throws IOException {
		resetVariable();//������ iv �ʱ�ȭ
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
	 * 1�� ���� 
	 * ���帹�� ���� key ã�Ƴ��� �޼���
	 */
	public void countKey(String token) {
		int values = 0;
			if(token.indexOf("&")!=-1) {
				token=token.substring(token.indexOf("key=")+4,token.indexOf("&"));
			}else {
//				System.out.println(1);
			}
			if (!(key.containsKey(token))) {// Ű�� ������?
				key.put(token, 1);// ���ο� Ű, ���� ����
			} else if (key.containsKey(token)) {// Ű�� ������
				values = key.get(token);// ���� ����� ���� ���ֱ�
				values += 1;// ���� 1 ī��Ʈ
				key.put(token, values);// ī���� �� ���� �ֱ�
			} // end else if
	}//calMostFrequentKey
	
	public void calMostFrequentKey() {
		mostFrequentKey="";
		int maxValue = Collections.max(key.values());
		//key7�� ī��Ʈ�� ������ collections.max�� ���� ���� ���� ī��Ʈ�� Ƚ���� �����Ѵ�.
		for (String r : key.keySet()) {//key�� key1�� ���� ���� ��� Ű�� ��´�.
			if (key.get(r) == maxValue) {//key�� Ű�� �� ���� ���� Ƚ���� ���� Ű�� ���� ���
				mostFrequentKey = r+"";//�� "Ű���� �ִٻ�� Ű"�� �����Ѵ�.
				mostFrequentKeyV=maxValue;
				break;     
			} // end if
		} // end for
	}// calMostFrequentKey
	

	
	/**
	 * 2������
	 * �������� ���� Ƚ��, �������ϱ�
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
	 * 3��, 5��, 6������
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
	 * 4������
	 * ���帹�� ������ �ð� ã�� �޼��� 
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
		 * 4������
		 * ���帹�� ������ �ð� ã�� �޼��� 
		 */
		token =token.substring(11, 13);
		int num=Integer.parseInt(token);
		hour[num]++;
		
		} //calMostFrequentHour

	/**
	 * 8������ 1~7�� ��� ���̾�α׷� �����ֱ� report���� ��ư�� Ŭ���Ǹ� c:/dev/report������ ������ ��
	 * ��report_������¥.dat�� ������ �����Ͽ� 1~6������ �۾��� ��� ����Ѵ�. ���ϸ� ��)
	 * report_1628605156919.dat
	 */
	public void showResult() throws IOException {
		Date date = new Date();
		File dir = new File("C:/dev/report");
		if (!dir.exists()) {
			dir.mkdirs();// ���丮 ����
		} // end if

		BufferedWriter bw = null;
		File saveFile = new File(dir.getAbsolutePath() + "/report_" + date.getTime() + ".dat");
		try {
			bw = new BufferedWriter(new FileWriter(saveFile));

			bw.write("1��\n���帹�� ������ ������ : "+getMostFrequentKey()+", Ƚ�� : "+getMostFrequentKeyV()+"\n");//1������
			bw.write("2��\nIE : "+getIe()+"("+Math.round(((double)getIe()/(double)getCntLine()*100.0))+"%)"//2������
					+", FireFox : "+getFirefox()+"("+Math.round(((double)getFirefox()/(double)getCntLine()*100.0))+"%)"
					+", Chrome : "+getChrome()+"("+Math.round(((double)getChrome()/(double)getCntLine()*100.0))+"%)"
					+", Safari : "+getSafari()+"("+Math.round(((double)getSafari()/(double)getCntLine()*100.0))+"%)"
					+", Opera : "+getOpera()+"("+Math.round(((double)getOpera()/(double)getCntLine()*100.0))+"%)\n"
					);
			bw.write("3��\n���� Ƚ��(200) : "+getCode200()+", ���� Ƚ��(404) : "+ getCode404() + "\n" );//3������
			bw.write("4��\n��û�� ���� ���� �ð���: "+getMaxHourValue()+"��\n");//4������
			bw.write("5��\n���������� ��û (403)" + getCode403()+ "��, ���� : "+ getCode403()+"%\n");//5������
			bw.write("6��\n��û�� ���� ���� (500)" + getCode500()+ "��, ���� : "+ getCode500()+"%\n");//6������
			bw.flush();// ����

		} finally {
			if (bw != null) {
				bw.close();
			} // ��Ʈ���� �����ִ� ������ �������� ����(flush)�ϰ� ������ ���´�.
		} // end finallyy
	}
}




