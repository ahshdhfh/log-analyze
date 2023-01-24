package project;

import java.util.Collections;

public class LogDecomposition {

	private LogVO lv; // 로그정보객체
	
	
	
	public LogDecomposition(LogVO lv) {
		this.lv = lv;
	}
	
	/**
	 * 1번 문제 가장많이 나온 key 찾아내는 메서드
	 */
	public void countKey(String token) {

		// http://sist.co.kr/find/books?key=mongodb&query=sist 이렇게 잘려저서 오는데 이걸 추출해야함
		if (token.indexOf("&") != -1) { // &가 403코드랑 500코드는 키가 없음 그래서 있는지 체크해야함
			int start = token.indexOf("key=") + 4;
			int end =  token.indexOf("&");
			token = token.substring(start, end); // key= (start)랑 &(end) 로 추출 // start <= , end <
		} // end if

		if (!(lv.getKey().containsKey(token))) {// 키가 없으면?
			lv.getKey().put(token, 1);// 새로운 키(key), 값(value)을 설정		
		} else if (lv.getKey().containsKey(token)) {// 키가 존재하면?
			int values = 0; // 키값 임시저장할 변수
			values = lv.getKey().get(token);// 현재 저장된 값을 임시저장
			values += 1;// 값에 1 카운트
			lv.getKey().put(token, values);// 카운팅 된 값을 넣기
		} // end else if
	}// calMostFrequentKey
	
	/**
	 * 가장 많이 호출된 키값 저장해주는 메소드
	 */
	public void calMostFrequentKey() {
		
		int maxValue = Collections.max(lv.getKey().values());
		lv.setMostFrequentKeyV(maxValue);
		// key7에 카운트된 값들중 collections.max을 통해 가장 많이 카운트된 횟수를 도출한다.
		for (String r : lv.getKey().keySet()) {// key에 key1을 통해 얻은 모든 키를 얻는다.
			if (lv.getKey().get(r) == maxValue) {// key의 키값 중 가장 많은 횟수를 얻은 키가 있을 경우
				lv.getMostFrequentKey().add(r);// " List로 변경" , 그 "키값을 최다사용 키"로 지정한다.
				 // 저장하기
    	   //break; // 찾았으면 탈출
			} // end if
		} // end for
	}// calMostFrequentKey
	
	/**
	 * 2번문제 브라우저별 접속 횟수, 비율구하기
	 */
	public void countBrowser(String token) {
		if (token.equals("ie")) { // 토큰이 ie이면?
			lv.setIe(lv.getIe() + 1); // 1+해서 저장
		} else if (token.equals("Chrome")) { // 토큰이 Chrome이면?
			lv.setChrome(lv.getChrome() + 1); // 1+해서 저장
		} else if (token.equals("firefox")) { // 토큰이 firefox이면?
			lv.setFirefox(lv.getFirefox() + 1); // 1+해서 저장
		} else if (token.equals("opera")) { // 토큰이 opera이면?
			lv.setOpera(lv.getOpera() + 1); // 1+해서 저장
		} else if (token.equals("Safari")) { // 토큰이 Safari이면?
			lv.setSafari(lv.getSafari() + 1); // 1+해서 저장
		} // end else
	}// countBowser

	/**
	 * 3번, 5번, 6번문제 code카운트하기
	 * 
	 * @param token
	 */
	public void cntCode(String token) {
		switch (Integer.parseInt(token)) { // 매개변수로 받은 토큰을 int로 저장 case문으로 돌리기 위해
		case 200:
			lv.setCode200(lv.getCode200() + 1);
			break; // 토큰이 Code200이면? 1+해서 저장
		case 403:
			lv.setCode403(lv.getCode403() + 1);
			break; // 토큰이 Code403이면? 1+해서 저장
		case 404:
			lv.setCode404(lv.getCode404() + 1);
			break; // 토큰이 Code404이면? 1+해서 저장
		case 500:
			lv.setCode500(lv.getCode500() + 1);
			break; // 토큰이 Code500이면? 1+해서 저장
		}// end switch
	}// cntCode
	
	/**
	 * 4번문제 가장많이 접속한 시간 찾는 메서드
	 */
	public void calTime() {
		for (int h = 1; h < lv.getHour().length; h++) { // 0~23시간 배열을 다돌리기
			if (lv.getHour()[h] > lv.getHour()[h - 1]) { // 카운트된게 더 많은 시간찾기
				lv.setMaxHourValue(h); // 저장
			} // end if
		} // end for
	} // calTIme

	/**
	 * 4번문제 호출된 시간값 카운트하는 메소드
	 * 
	 * @param token
	 */
	public void calMostFrequentHour(String token) {

		token = token.substring(11, 13); // 토큰이 2023-01-16 09:35:16 이렇게 넘어오는데 11번째 13번째값 잘라오기
		int num = Integer.parseInt(token); // int 형으로 바꾸기
		lv.getHour()[num]++; // 저장

	} // calMostFrequentHour
		
	
}//LogDecomposition
