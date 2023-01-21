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

public class LoginEvt extends WindowAdapter implements ActionListener {

	private Login login; // login 객체
	private String pw; // 패스워드 변수
	private Map<String, String> map; // 로그인정보가 일치하는지 확인할 map 객체 생성

	public LoginEvt(Login login) {
		this.login = login; // 로그인 객체담기
		map = new Hashtable<String, String>(); // map 객체 생성
		// 2. 값 할당)
		map.put("admin", "1234"); // 일치하는지 확인하기 위해 값 저장
		map.put("root", "1111"); // 일치하는지 확인하기 위해 값 저장
		map.put("administrator", "12345"); // 일치하는지 확인하기 위해 값 저장
	}// loginEvt

	@Override
	public void windowClosing(WindowEvent we) {
		login.dispose(); // 윈도우종료
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = login.getJtfId().getText(); // 입력한 id값 login클래스에서 받아오기
		pw = login.getJpfPass().getText(); // pw값 login클래스에서 받아오기
		if (loginAuth(id, pw)) { // 검증해서 id,pw값이 맞으면 true 반환하면서 실행
			login.setId(id); // id값은 report누를때 필요하므로 인스턴스 변수에 저장하기
			new SelectMenu(login); // selectmenu창 뜨게하기
		} else {
			JOptionPane.showMessageDialog(login, "ID 또는 PASSWORD를 다시 확인해주세요 "); // 맞지 않으므로 다시 입력해달라고 하기
		} // end else
	}// actionPerformed

	/**
	 * 로그인정보가 맞는지 확인하는 메소드
	 * 
	 * @param id
	 * @param pw
	 * @return
	 */
	public boolean loginAuth(String id, String pw) {
		boolean result = false; // 반환할 result 변수만들고 디폴트 값으로 false
		// map의 모든 키 얻기
		Set<String> set = map.keySet(); // set객체생성 후 map의 키값 넣기
		Iterator<String> ita = set.iterator(); // iterator객체 생성 후 set의 iterator 저장
		String key = ""; // key 변수
		while (ita.hasNext()) { // 키와 모든 값을 출력
			key = ita.next(); // 키값 key변수에저장
			if (id.equals(key)) { // 아이디가 같은지
				if (pw.equals(map.get(key))) { // 패스워드가 같은지
					result = true; // 둘다맞으면 true
				} // end if
			} // end if
		} // end while
		return result; // 로그인이 맞으면 true, 아니면 false를 반환
	}// loginAuth

}// class
