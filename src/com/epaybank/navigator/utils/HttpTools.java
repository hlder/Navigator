package com.epaybank.navigator.utils;

import java.util.List;

import org.apache.http.cookie.Cookie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epaybank.navigator.view.NaApplication;

public class HttpTools {
	/**
	 * �ж����󷵻ص������Ƿ���ȷ
	 * @param str
	 * @return
	 */
	public static boolean isSuccess(String str){
		if(str==null){
			return false;
		}
		JSONObject jo=JSON.parseObject(str);
		if(jo==null){
			return false;
		}
		int code=jo.getIntValue("code");
		if(code!=200){
			return false;
		}
		return true;
	}
	
	/**
	 * ����cookie
	 * @param cookies
	 */
	public static void saveCookie(List<Cookie> cookies){
		NaApplication.saveCookie(cookies);
	}
	/**
	 * ��ȡcookie
	 * @return
	 */
	public static List<Cookie> getCookie(){
		return NaApplication.getCookie();
	}
}
