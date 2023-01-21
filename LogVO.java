package project;

import java.util.HashMap;
import java.util.Map;

public class LogVO {	
	
	private String mostFrequentHour;//���� ��û�� ���� �ð�
	private String mostFrequentKey;//���� ��û�� ���� Ű
	private int mostFrequentKeyV;//���� ��û�� ���� Ű�� ��
	private int maxHourValue;//�ð�
	int[] hour= new int[24];	
	private Map<String, Integer>key=new HashMap<String, Integer>(); //1�� �׽�Ʈ	
	private int ie;//������ ī��Ʈ
	private int firefox;//������ ī��Ʈ
	private int opera;//������ ī��Ʈ
	
	public LogVO() {
		
	}//LogVO
	
	public void resetVariable() {
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
		
		maxHourValue=0;
		hour= new int[24];
		
		key=new HashMap<String, Integer>();
	}
		
	
	
	private int chrome;//������ ī��Ʈ
	private int safari;//������ ī��Ʈ
	private int code200;//�ڵ� 200�� ���� Ƚ��
	private int code404;//�ڵ� 404�� ���� Ƚ��
	private int code403;//�ڵ� 403�� ���� Ƚ��
	private int code500;//�ڵ� 403�� ���� Ƚ��
	
	public String getMostFrequentHour() {
		return mostFrequentHour;
	}
	public void setMostFrequentHour(String mostFrequentHour) {
		this.mostFrequentHour = mostFrequentHour;
	}
	public String getMostFrequentKey() {
		return mostFrequentKey;
	}
	public void setMostFrequentKey(String mostFrequentKey) {
		this.mostFrequentKey = mostFrequentKey;
	}
	public int getMostFrequentKeyV() {
		return mostFrequentKeyV;
	}
	public void setMostFrequentKeyV(int mostFrequentKeyV) {
		this.mostFrequentKeyV = mostFrequentKeyV;
	}
	public int getMaxHourValue() {
		return maxHourValue;
	}
	public void setMaxHourValue(int maxHourValue) {
		this.maxHourValue = maxHourValue;
	}
	public int[] getHour() {
		return hour;
	}
	public void setHour(int[] hour) {
		this.hour = hour;
	}
	public Map<String, Integer> getKey() {
		return key;
	}
	public void setKey(Map<String, Integer> key) {
		this.key = key;
	}
	public int getIe() {
		return ie;
	}
	public void setIe(int ie) {
		this.ie = ie;
	}
	public int getFirefox() {
		return firefox;
	}
	public void setFirefox(int firefox) {
		this.firefox = firefox;
	}
	public int getOpera() {
		return opera;
	}
	public void setOpera(int opera) {
		this.opera = opera;
	}
	public int getChrome() {
		return chrome;
	}
	public void setChrome(int chrome) {
		this.chrome = chrome;
	}
	public int getSafari() {
		return safari;
	}
	public void setSafari(int safari) {
		this.safari = safari;
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

	
	
	
	
	
	
	
	
	
	
}//LogVO
