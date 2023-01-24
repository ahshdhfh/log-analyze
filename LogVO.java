package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogVO {

	private String mostFrequentHour;// 가장 요청이 많은 시간
	private List<String> mostFrequentKey=new ArrayList<String>();// 가장 요청이 많은 키
	private int mostFrequentKeyV;// 가장 요청이 많은 키의 값
	private int maxHourValue;// 시간
	int[] hour = new int[24]; // 시간호출된 개수새는 변수
	private Map<String, Integer> key = new HashMap<String, Integer>(); // 1번 테스트
	private int ie;// 브라우저 카운트
	private int firefox;// 브라우저 카운트
	private int opera;// 브라우저 카운트

	public LogVO() {

	}// LogVO

	public void resetVariable() {
		code200 = 0;// 코드 200이 나온 횟수
		code404 = 0;// 코드 404이 나온 횟수
		code403 = 0;// 코드 403이 나온 횟수
		code500 = 0;// 코드 403이 나온 횟수

		mostFrequentHour = "";// 가장 요청이 많은 시간
		mostFrequentKeyV = 0;// 가장 요청이 많은 키의 값
		mostFrequentKey.clear();

		ie = 0;// 브라우저 카운트
		firefox = 0;// 브라우저 카운트
		opera = 0;// 브라우저 카운트
		chrome = 0;// 브라우저 카운트
		safari = 0;// 브라우저 카운트

		maxHourValue = 0; // 가장 많이 호출된 시간을 담는 변수
		hour = new int[24]; // 시간호출된 개수새는 변수

		key = new HashMap<String, Integer>(); // 1번문제에 사용하는 변수
	}

	private int chrome;// 브라우저 카운트
	private int safari;// 브라우저 카운트
	private int code200;// 코드 200이 나온 횟수
	private int code404;// 코드 404이 나온 횟수
	private int code403;// 코드 403이 나온 횟수
	private int code500;// 코드 403이 나온 횟수

	public String getMostFrequentHour() {
		return mostFrequentHour;
	}// getMostFrequentHour

	public void setMostFrequentHour(String mostFrequentHour) {
		this.mostFrequentHour = mostFrequentHour;
	}// setMostFrequentHour

	public List<String> getMostFrequentKey() {
		return mostFrequentKey;
	}// getMostFrequentKey

	public void setMostFrequentKey(List<String> mostFrequentKey) {
		this.mostFrequentKey = mostFrequentKey;
	}// setMostFrequentKey

	public int getMostFrequentKeyV() {
		return mostFrequentKeyV;
	}// getMostFrequentKeyV

	public void setMostFrequentKeyV(int mostFrequentKeyV) {
		this.mostFrequentKeyV = mostFrequentKeyV;
	}// setMostFrequentKeyV

	public int getMaxHourValue() {
		return maxHourValue;
	}// getMaxHourValue

	public void setMaxHourValue(int maxHourValue) {
		this.maxHourValue = maxHourValue;
	}// setMaxHourValue

	public int[] getHour() {
		return hour;
	}// getHour

	public void setHour(int[] hour) {
		this.hour = hour;
	}// setHour

	public Map<String, Integer> getKey() {
		return key;
	}// getKey

	public void setKey(Map<String, Integer> key) {
		this.key = key;
	}// setKey

	public int getIe() {
		return ie;
	}// getIe

	public void setIe(int ie) {
		this.ie = ie;
	}// setIe

	public int getFirefox() {
		return firefox;
	}// getFirefox

	public void setFirefox(int firefox) {
		this.firefox = firefox;
	}// setFirefox

	public int getOpera() {
		return opera;
	}// getOpera

	public void setOpera(int opera) {
		this.opera = opera;
	}// setOpera

	public int getChrome() {
		return chrome;
	}// getChrome

	public void setChrome(int chrome) {
		this.chrome = chrome;
	}// setChrome

	public int getSafari() {
		return safari;
	}// getSafari

	public void setSafari(int safari) {
		this.safari = safari;
	}// setSafari

	public int getCode200() {
		return code200;
	}// getCode200

	public void setCode200(int code200) {
		this.code200 = code200;
	}// setCode200

	public int getCode404() {
		return code404;
	}// getCode404

	public void setCode404(int code404) {
		this.code404 = code404;
	}// setCode404

	public int getCode403() {
		return code403;
	}// getCode403

	public void setCode403(int code403) {
		this.code403 = code403;
	}// setCode403

	public int getCode500() {
		return code500;
	}// getCode500

	public void setCode500(int code500) {
		this.code500 = code500;
	}// setCode500

}// LogVO
