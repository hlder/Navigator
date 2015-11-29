package com.epaybank.navigator.utils;

import java.util.List;

import org.apache.http.cookie.Cookie;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epaybank.navigator.bean.UserAccountInfo;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.bean.UserState;
import com.epaybank.navigator.view.NaApplication;

public class HttpTools {
	/**
	 * 判断请求返回的数据是否正确
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
	 * 判断是否已经登录
	 */
	public static boolean isLogin(Context context){
		List<Cookie> cookies=getCookie(context);
		if(cookies!=null&&cookies.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 保存cookie
	 * @param cookies
	 */
	public static void saveCookie(Context context, List<Cookie> cookies){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).saveCookie(cookies);
		}
	}
	/**
	 * 获取cookie
	 * @return
	 */
	public static List<Cookie> getCookie(Context context){
		if(context.getApplicationContext() instanceof NaApplication)
			return ((NaApplication)context.getApplicationContext()).getCookie();
		else
			return null;
	}
	
	
	/**
	 * 保存我登录的个人信息
	 * @param context
	 * @param myinfo
	 */
	public static void saveMyInfo(Context context,UserInfo myInfo){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).saveMyInfo(myInfo);
		}
	}
	public static UserInfo getMyInfo(Context context){
		if(context.getApplicationContext() instanceof NaApplication){
			return ((NaApplication)context.getApplicationContext()).getMyInfo();
		}
		return null;
	}
	
	/**
	 * 保存用户信息
	 */
	public static void saveUserAccountInfo(Context context,UserAccountInfo userInfo){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).setUserAccountInfo(userInfo);
		}
	}
	/**
	 * 获取用户登录信息
	 * @param context
	 * @return
	 */
	public static UserAccountInfo getUserAccountInfo(Context context){
		if(context.getApplicationContext() instanceof NaApplication){
			return ((NaApplication)context.getApplicationContext()).getUserAccountInfo();
		}
		return null;
	}
	
	
	/**
	 * 保存用户的状态，包括动态，关注，好友等
	 * @param context
	 * @param userState
	 */
	public static void saveUserState(Context context,UserState userState){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).saveUserState(userState);
		}
	}
	/**
	 * 获取UserState
	 * @param context
	 * @return
	 */
	public static UserState getUserState(Context context){
		if(context.getApplicationContext() instanceof NaApplication){
			return ((NaApplication)context.getApplicationContext()).getUserState();
		}
		return null;
	}
	
	
	
	/**
	 * 清除cookie
	 * 在注销登录的时候需要执行
	 */
	public static void clearCookie(Context context){
		if(context.getApplicationContext() instanceof NaApplication)
			((NaApplication)context.getApplicationContext()).clearCookie();
	}
}
