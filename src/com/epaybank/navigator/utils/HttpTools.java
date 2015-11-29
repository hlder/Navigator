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
	 * �ж��Ƿ��Ѿ���¼
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
	 * ����cookie
	 * @param cookies
	 */
	public static void saveCookie(Context context, List<Cookie> cookies){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).saveCookie(cookies);
		}
	}
	/**
	 * ��ȡcookie
	 * @return
	 */
	public static List<Cookie> getCookie(Context context){
		if(context.getApplicationContext() instanceof NaApplication)
			return ((NaApplication)context.getApplicationContext()).getCookie();
		else
			return null;
	}
	
	
	/**
	 * �����ҵ�¼�ĸ�����Ϣ
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
	 * �����û���Ϣ
	 */
	public static void saveUserAccountInfo(Context context,UserAccountInfo userInfo){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).setUserAccountInfo(userInfo);
		}
	}
	/**
	 * ��ȡ�û���¼��Ϣ
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
	 * �����û���״̬��������̬����ע�����ѵ�
	 * @param context
	 * @param userState
	 */
	public static void saveUserState(Context context,UserState userState){
		if(context.getApplicationContext() instanceof NaApplication){
			((NaApplication)context.getApplicationContext()).saveUserState(userState);
		}
	}
	/**
	 * ��ȡUserState
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
	 * ���cookie
	 * ��ע����¼��ʱ����Ҫִ��
	 */
	public static void clearCookie(Context context){
		if(context.getApplicationContext() instanceof NaApplication)
			((NaApplication)context.getApplicationContext()).clearCookie();
	}
}
