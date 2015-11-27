package com.epaybank.navigator.utils;

/**
 * 获取所有的url地址
 * @author liangdong
 *
 */
public class UrlFactory {
	private static final String action_login="user/login.json";
	
	
	/**
	 * 登录的URL
	 */
	public static String Login(String username,String password){
		return AppParams.getBaseUrl()+"?userName="+username+"&password="+password;
	}
	
}