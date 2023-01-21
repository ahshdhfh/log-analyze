package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import day0104.MainWindow;
import day0104.SubWindow;

public class LoginEvt extends WindowAdapter implements ActionListener {

	private Login login;
	private String pw;
	private Map<String, String> map; //���̵��н����尪�� ������ map��ü
	
	public LoginEvt(Login login) {
		this.login=login;
		map=new Hashtable<String, String>();
		//2. �� �Ҵ�)
		map.put("admin","1234");
		map.put("root", "1111");
		map.put("administrator","12345");
	}//loginEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		login.dispose(); //����������
	}//windowClosing
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String id=login.getJtfId().getText();
		pw=login.getJpfPass().getText();
		System.out.println(id+""+pw);
		if(loginAuth(id,pw)) {
			login.setId(id);
			new SelectMenu(login); 
		}else {
			JOptionPane.showMessageDialog(login, "ID �Ǵ� PASSWORD�� �ٽ� Ȯ�����ּ��� ");
		}
	}

	public boolean loginAuth(String id,String pw) {
		boolean result=false;
		//map�� ��� Ű ���
		Set<String> set=map.keySet();
		Iterator<String> ita=set.iterator();
		String key="";
		while(ita.hasNext()) { //Ű�� ��� ���� ���
			key=ita.next();
			if(id.equals(key)){ //���̵� ������
				if(pw.equals(map.get(key))) { //�н����尡 ������ 
					result=true; //�Ѵٸ����� true
				}
			}
		}//end while
		return result;
	}//loginAuth
	
}
