package com.epaybank.navigator.view;

import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.view.app.LoginActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * 此activity会判断是否已经登录，如果没有进行登录，会先登录，登录成功后进行加载
 * 如果已经登录边直接加载
 * @author liangdong
 */
public abstract class AppLoginActivity extends AppActivity{
	private static final int LOGIN_REQUEST_CODE=1001;
	public static final int LOGIN_RESULT_CODE_SUCCESS=1002;//登录成功
	public static final int LOGIN_RESULT_CODE_FAILURE=1003;//登录失败
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(HttpTools.isLogin(this)){//如果已经登录，直接加载
			init(savedInstanceState);
		}else{//没有登录，进入登录页面
			Intent intent=new Intent(this,LoginActivity.class);
			startActivityForResult(intent, LOGIN_REQUEST_CODE);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==LOGIN_REQUEST_CODE){//登录返回
			if(resultCode==LOGIN_RESULT_CODE_SUCCESS){//登录成功
				init(null);
				return;
			}
			//未登录 不做修改
			notLogin();
		}
	}
	
	public abstract void notLogin();
	public abstract void init(Bundle savedInstanceState);
}