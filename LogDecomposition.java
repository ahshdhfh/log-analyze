package project;

import java.util.Collections;

public class LogDecomposition {

	private LogVO lv; // �α�������ü
	
	
	
	public LogDecomposition(LogVO lv) {
		this.lv = lv;
	}
	
	/**
	 * 1�� ���� ���帹�� ���� key ã�Ƴ��� �޼���
	 */
	public void countKey(String token) {
		int values = 0; // Ű�� �ӽ������� ����

		// http://sist.co.kr/find/books?key=mongodb&query=sist �̷��� �߷����� ���µ� �̰� �����ؾ���
		if (token.indexOf("&") != -1) { // &�� 403�ڵ�� 500�ڵ�� Ű�� ���� �׷��� �ִ��� üũ�ؾ���
			token = token.substring(token.indexOf("key=") + 4, token.indexOf("&")); // key= �� & �� ����
		} // end if

		if (!(lv.getKey().containsKey(token))) {// Ű�� ������?
			lv.getKey().put(token, 1);// ���ο� Ű, ���� ����
		} else if (lv.getKey().containsKey(token)) {// Ű�� �����ϸ�?
			values = lv.getKey().get(token);// ���� ����� ���� �ӽ�����
			values += 1;// ���� 1 ī��Ʈ
			lv.getKey().put(token, values);// ī���� �� ���� �ֱ�
		} // end else if
	}// calMostFrequentKey
	
	/**
	 * ���� ���� ȣ��� Ű�� �������ִ� �޼ҵ�
	 */
	public void calMostFrequentKey() {
		int maxValue = Collections.max(lv.getKey().values());
		// key7�� ī��Ʈ�� ������ collections.max�� ���� ���� ���� ī��Ʈ�� Ƚ���� �����Ѵ�.
		for (String r : lv.getKey().keySet()) {// key�� key1�� ���� ���� ��� Ű�� ��´�.
			if (lv.getKey().get(r) == maxValue) {// key�� Ű�� �� ���� ���� Ƚ���� ���� Ű�� ���� ���
				lv.setMostFrequentKey(r + "");// �� "Ű���� �ִٻ�� Ű"�� �����Ѵ�.
				lv.setMostFrequentKeyV(maxValue); // �����ϱ�
				break; // ã������ Ż��
			} // end if
		} // end for
	}// calMostFrequentKey
	
	/**
	 * 2������ �������� ���� Ƚ��, �������ϱ�
	 */
	public void countBrowser(String token) {
		if (token.equals("ie")) { // ��ū�� ie�̸�?
			lv.setIe(lv.getIe() + 1); // 1+�ؼ� ����
		} else if (token.equals("Chrome")) { // ��ū�� Chrome�̸�?
			lv.setChrome(lv.getChrome() + 1); // 1+�ؼ� ����
		} else if (token.equals("firefox")) { // ��ū�� firefox�̸�?
			lv.setFirefox(lv.getFirefox() + 1); // 1+�ؼ� ����
		} else if (token.equals("opera")) { // ��ū�� opera�̸�?
			lv.setOpera(lv.getOpera() + 1); // 1+�ؼ� ����
		} else if (token.equals("Safari")) { // ��ū�� Safari�̸�?
			lv.setSafari(lv.getSafari() + 1); // 1+�ؼ� ����
		} // end else
	}// countBowser

	/**
	 * 3��, 5��, 6������ codeī��Ʈ�ϱ�
	 * 
	 * @param token
	 */
	public void cntCode(String token) {
		switch (Integer.parseInt(token)) { // �Ű������� ���� ��ū�� int�� ���� case������ ������ ����
		case 200:
			lv.setCode200(lv.getCode200() + 1);
			break; // ��ū�� Code200�̸�? 1+�ؼ� ����
		case 403:
			lv.setCode403(lv.getCode403() + 1);
			break; // ��ū�� Code403�̸�? 1+�ؼ� ����
		case 404:
			lv.setCode404(lv.getCode404() + 1);
			break; // ��ū�� Code404�̸�? 1+�ؼ� ����
		case 500:
			lv.setCode500(lv.getCode500() + 1);
			break; // ��ū�� Code500�̸�? 1+�ؼ� ����
		}// end switch
	}// cntCode
	
	/**
	 * 4������ ���帹�� ������ �ð� ã�� �޼���
	 */
	public void calTime() {
		for (int h = 1; h < lv.getHour().length; h++) { // 0~23�ð� �迭�� �ٵ�����
			if (lv.getHour()[h] > lv.getHour()[h - 1]) { // ī��Ʈ�Ȱ� �� ���� �ð�ã��
				lv.setMaxHourValue(h); // ����
			} // end if
		} // end for
	} // calTIme

	/**
	 * 4������ ȣ��� �ð��� ī��Ʈ�ϴ� �޼ҵ�
	 * 
	 * @param token
	 */
	public void calMostFrequentHour(String token) {

		token = token.substring(11, 13); // ��ū�� 2023-01-16 09:35:16 �̷��� �Ѿ���µ� 11��° 13��°�� �߶����
		int num = Integer.parseInt(token); // int ������ �ٲٱ�
		lv.getHour()[num]++; // ����

	} // calMostFrequentHour
		
	
}//LogDecomposition
