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
	 * 保存cookie
	 */
	private  List<Cookie> cookies;
	/**
	 * 登录人的个人信息,登录成功后会记录在这里
	 */
	private  UserAccountInfo userAccountInfo;
	/**
	 * 我的state消息
	 */
	private UserState userSate;
	/**
	 * 我的详细信息
	 */
	private UserInfo myInfo;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * 初始化图片加载器
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
	 * 获取cookie
	 * @return
	 */
	public  List<Cookie> getCookie(){
		return cookies;
	}
	/**
	 * 清除cookie
	 */
	public  void clearCookie(){
		if(cookies==null){
			return;
		}
		cookies.clear();
		cookies=null;
	}
	
	
	
	
}