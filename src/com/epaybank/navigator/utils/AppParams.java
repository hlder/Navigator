package com.epaybank.navigator.utils;

public class AppParams {
	private static String baseUrl="https://app.lhyone.com/";
	
	
	public static String getBaseUrl(){
		return baseUrl;
	}
	
	/**
	 * event消息 登录的action
	 */
	public static final String EVENTBUS_ACTION_LOGIN="EVENTBUS_ACTION_LOGIN";
	
	
	
	
	
	
	
	
	
	public static final int PRESENTER_TAG_LOGIN=10101;//登录
	public static final int PRESENTER_TAG_GAIN_STATE_INFO=10102;//获取用户state详情
	public static final int PRESENTER_TAG_GAIN_MY_INFO=10103;//获取用户state详情
	
}