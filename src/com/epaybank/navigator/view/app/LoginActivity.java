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
 * ��¼����
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
		case R.id.btnLogin://��¼
			doLogin();
			break;
		case R.id.btnForgotPsd://��������
			
			break;
		case R.id.btnRegister://ע��
			
			break;
		case R.id.btnQQLogin://qq��¼��ť
			
			break;
		case R.id.btnWxLogin://΢�ŵ�¼
			
			break;
		}
	}
	
	
	/**
	 * �����ݸı�ʱ
	 */
	@Override
	public void onDataChanage() {
		super.onDataChanage();
		if(userInfo!=null){//��¼�ɹ�
//			Log.d("dddd", "userifo:"+userInfo.getCreateDate());
			EventBus.post(AppParams.EVENTBUS_ACTION_LOGIN, null);
			this.finish();
		}
	}
	
	@Override
	public void onChanageUi(int tag, Object msg) {
		super.onChanageUi(tag, msg);
		Log.d("dddd", "�����޸�ui:"+msg.toString());
		
	}
	
	
	
	
	private void doLogin() {
		String username=edtUsername.getText().toString();
		String password=edtPassword.getText().toString();
        if(username==null||username.equals("")){//�û�������Ϊ��
        	showToast(this.getResources().getString(R.string.username_null));
        }else if(password==null||password.equals("")){//���벻��Ϊ��
        	showToast(this.getResources().getString(R.string.password_null));
        }else if(username.length()<6){//�û�����С��6
        	showToast(this.getResources().getString(R.string.username_length_short));
        }else if(password.length()<6){//���벻С��6
        	showToast(this.getResources().getString(R.string.password_length_short));
        }else{//ִ�е�¼
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