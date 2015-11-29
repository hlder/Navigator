package com.epaybank.navigator.view.app;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.epaybank.navigator.R;
import com.epaybank.navigator.bean.UserAccountInfo;
import com.epaybank.navigator.presenter.GainMyInfoPresenter;
import com.epaybank.navigator.presenter.LoginPresenter;
import com.epaybank.navigator.utils.AppParams;
import com.epaybank.navigator.utils.DialogUtils;
import com.epaybank.navigator.view.AppActivity;
import com.epaybank.navigator.view.AppLoginActivity;
import com.hld.library.frame.EventBus;
import com.org.finalmvp.ViewData;
/**
 * ��¼����
 * @author liangdong
 */
public class LoginActivity extends AppActivity implements OnClickListener{
	public static final int REQUESTCODE_REGISTER=1;
	
	@ViewData
	public UserAccountInfo userInfo;
	
	private LoginPresenter loginP;
	private GainMyInfoPresenter gainP;
	
	private EditText edtUsername,edtPassword;
	
	/**
	 *  �ȴ���
	 */
	private Dialog proDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setTitleBackgroundColor(Color.WHITE);
		prepare();
	}
	
	private void prepare() {
		proDialog=DialogUtils.getProgressDialog(this);
		
		
		loginP=new LoginPresenter(this);
		gainP=new GainMyInfoPresenter(this);
		
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
			proDialog.show();
			doLogin();
			break;
		case R.id.btnForgotPsd://��������
			
			break;
		case R.id.btnRegister://ע��
			Intent intent = new Intent(this,RegisterActivity.class);
			startActivityForResult(intent, REQUESTCODE_REGISTER);
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
			gainP.gainStateInfo(userInfo.getUserId());
		}
	}
	
	@Override
	public void onChanageUi(int tag, Object msg) {
		super.onChanageUi(tag, msg);
		switch (tag) {
		case AppParams.PRESENTER_TAG_LOGIN://��¼�����
			proDialog.dismiss();
			Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
			break;
		case AppParams.PRESENTER_TAG_GAIN_MY_INFO://��ȡ�û�����ɹ�
			proDialog.dismiss();
			proDialog.cancel();
			EventBus.post(AppParams.EVENTBUS_ACTION_LOGIN, null);
			setResult(AppLoginActivity.LOGIN_RESULT_CODE_SUCCESS, null);
			this.finish();
			break;
		}
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
        	loginP.doLogin(username, password);
        }
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	
	public void showToast(String msg) {
		try{
			Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}