package com.epaybank.navigator.utils;

/**
 * ��ȡ���е�url��ַ
 * @author liangdong
 *
 */
public class UrlFactory {
	private static final String action_login="user/login.json";
	
	
	/**
	 * ��¼��URL
	 */
	public static String Login(String username,String password){
		return AppParams.getBaseUrl()+"?userName="+username+"&password="+password;
	}
	
}