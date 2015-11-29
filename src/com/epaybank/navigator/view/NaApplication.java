package com.epaybank.navigator.view;

import java.util.List;

import org.apache.http.cookie.Cookie;

import com.epaybank.navigator.R;
import com.epaybank.navigator.bean.UserAccountInfo;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.bean.UserState;
import com.hld.library.frame.ImageManager;
import com.hld.library.frame.image.ImageUtils;

import android.app.Application;

public class NaApplication extends Application{
	/**
	 * ����cookie
	 */
	private  List<Cookie> cookies;
	/**
	 * ��¼�˵ĸ�����Ϣ,��¼�ɹ�����¼������
	 */
	private  UserAccountInfo userAccountInfo;
	/**
	 * �ҵ�state��Ϣ
	 */
	private UserState userSate;
	/**
	 * �ҵ���ϸ��Ϣ
	 */
	private UserInfo myInfo;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * ��ʼ��ͼƬ������
		 */
		ImageUtils iu = ImageManager.getInstance(this);
		iu.configLoadingImage(R.mipmap.test_photo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UserInfo getMyInfo() {
		return myInfo;
	}

	public void saveMyInfo(UserInfo myInfo) {
		this.myInfo = myInfo;
	}

	public void saveUserState(UserState userSate){
		this.userSate=userSate;
	}
	
	public UserState getUserState(){
		return userSate;
	}
	
	
	public UserAccountInfo getUserAccountInfo() {
		return userAccountInfo;
	}

	public void setUserAccountInfo(UserAccountInfo userAccountInfo) {
		this.userAccountInfo = userAccountInfo;
	}

	public  void saveCookie(List<Cookie> cookies){
		this.cookies=cookies;
	}
	/**
	 * ��ȡcookie
	 * @return
	 */
	public  List<Cookie> getCookie(){
		return cookies;
	}
	/**
	 * ���cookie
	 */
	public  void clearCookie(){
		if(cookies==null){
			return;
		}
		cookies.clear();
		cookies=null;
	}
	
	
	
	
}