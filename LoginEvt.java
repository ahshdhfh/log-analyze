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
	private Map<String, String> map; //아이디패스워드값을 저장할 map객체
	
	public LoginEvt(Login login) {
		this.login=login;
		map=new Hashtable<String, String>();
		//2. 값 할당)
		map.put("admin","1234");
		map.put("root", "1111");
		map.put("administrator","12345");
	}//loginEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		login.dispose(); //윈도우종료
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
			JOptionPane.showMessageDialog(login, "ID 또는 PASSWORD를 다시 확인해주세요 ");
		}
	}

	public boolean loginAuth(String id,String pw) {
		boolean result=false;
		//map의 모든 키 얻기
		Set<String> set=map.keySet();
		Iterator<String> ita=set.iterator();
		String key="";
		while(ita.hasNext()) { //키와 모든 값을 출력
			key=ita.next();
			if(id.equals(key)){ //아이디가 같은지
				if(pw.equals(map.get(key))) { //패스워드가 같은지 
					result=true; //둘다맞으면 true
				}
			}
		}//end while
		return result;
	}//loginAuth
	
}
