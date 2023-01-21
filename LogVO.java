package project;

import java.util.HashMap;
import java.util.Map;

public class LogVO {	
	
	private String mostFrequentHour;//가장 요청이 많은 시간
	private String mostFrequentKey;//가장 요청이 많은 키
	private int mostFrequentKeyV;//가장 요청이 많은 키의 값
	private int maxHourValue;//시간
	int[] hour= new int[24];	
	private Map<String, Integer>key=new HashMap<String, Integer>(); //1번 테스트	
	private int ie;//브라우저 카운트
	private int firefox;//브라우저 카운트
	private int opera;//브라우저 카운트
	
	public LogVO() {
		
	}//LogVO
	
	public void resetVariable() {
		code200=0;//코드 200이 나온 횟수
		code404=0;//코드 404이 나온 횟수
		code403=0;//코드 403이 나온 횟수
		code500=0;//코드 403이 나온 횟수
		
		mostFrequentHour="";//가장 요청이 많은 시간
		mostFrequentKey="";//가장 요청이 많은 키
		mostFrequentKeyV=0;//가장 요청이 많은 키의 값
		
		ie=0;//브라우저 카운트
		firefox=0;//브라우저 카운트
		opera=0;//브라우저 카운트
		chrome=0;//브라우저 카운트
		safari=0;//브라우저 카운트
		
		maxHourValue=0;
		hour= new int[24];
		
		key=new HashMap<String, Integer>();
	}
		
	
	
	private int chrome;//브라우저 카운트
	private int safari;//브라우저 카운트
	private int code200;//코드 200이 나온 횟수
	private int code404;//코드 404이 나온 횟수
	private int code403;//코드 403이 나온 횟수
	private int code500;//코드 403이 나온 횟수
	
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
