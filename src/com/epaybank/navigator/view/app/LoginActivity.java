package com.epaybank.navigator.view.app;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.epaybank.navigator.R;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.presenter.LoginPresenter;
import com.epaybank.navigator.utils.AppParams;
import com.epaybank.navigator.view.AppActivity;
import com.hld.library.frame.EventBus;
import com.org.finalmvp.ViewData;
/**
 * 登录界面
 * @author liangdong
 */
public class LoginActivity extends AppActivity implements OnClickListener{
	@ViewData
	public UserInfo userInfo;
	
	private LoginPresenter login;
	
	private EditText edtUsername,edtPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setTitleBackgroundColor(Color.WHITE);
		prepare();
	}
	
	private void prepare() {
		login=new LoginPresenter(this);
		
		edtUsername=(EditText) findViewById(R.id.edtUsername);
		edtPassword=(EditText) findViewById(R.id.edtPassword);
		findViewById(R.id.btnLogin).setOnClickListener(this);
		findViewById(R.id.btnForgotPsd).setOnClickListener(this);
		findViewById(R.id.btnRegister).setOnClickListener(this);
		findViewById(R.id.btnQQLogin).setOnClickListener(this);
		findViewById(R.id.btnWxLogin).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin://登录
			doLogin();
			break;
		case R.id.btnForgotPsd://忘记密码
			
			break;
		case R.id.btnRegister://注册
			
			break;
		case R.id.btnQQLogin://qq登录按钮
			
			break;
		case R.id.btnWxLogin://微信登录
			
			break;
		}
	}
	
	
	/**
	 * 当数据改变时
	 */
	@Override
	public void onDataChanage() {
		super.onDataChanage();
		if(userInfo!=null){//登录成功
//			Log.d("dddd", "userifo:"+userInfo.getCreateDate());
			EventBus.post(AppParams.EVENTBUS_ACTION_LOGIN, null);
			this.finish();
		}
	}
	
	@Override
	public void onChanageUi(int tag, Object msg) {
		super.onChanageUi(tag, msg);
		Log.d("dddd", "出错修改ui:"+msg.toString());
		
	}
	
	
	
	
	private void doLogin() {
		String username=edtUsername.getText().toString();
		String password=edtPassword.getText().toString();
        if(username==null||username.equals("")){//用户名不能为空
        	showToast(this.getResources().getString(R.string.username_null));
        }else if(password==null||password.equals("")){//密码不能为空
        	showToast(this.getResources().getString(R.string.password_null));
        }else if(username.length()<6){//用户名不小于6
        	showToast(this.getResources().getString(R.string.username_length_short));
        }else if(password.length()<6){//密码不小于6
        	showToast(this.getResources().getString(R.string.password_length_short));
        }else{//执行登录
        	login.doLogin(username, password);
        }
	}
	
	
	
	public void showToast(String msg) {
		try{
			Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}