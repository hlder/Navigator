package com.epaybank.navigator.view;

import java.util.List;

import org.apache.http.cookie.Cookie;

import android.app.Application;

public class NaApplication extends Application{
	/**
	 * ±£´æcookie
	 */
	private static List<Cookie> cookies;
	public static void saveCookie(List<Cookie> cookies){
		NaApplication.cookies=cookies;
	}
	public static List<Cookie> getCookie(){
		return cookies;
	}
	
	
}
