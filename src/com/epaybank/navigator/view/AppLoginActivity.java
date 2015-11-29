package com.epaybank.navigator.view;

import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.view.app.LoginActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * ��activity���ж��Ƿ��Ѿ���¼�����û�н��е�¼�����ȵ�¼����¼�ɹ�����м���
 * ����Ѿ���¼��ֱ�Ӽ���
 * @author liangdong
 */
public abstract class AppLoginActivity extends AppActivity{
	private static final int LOGIN_REQUEST_CODE=1001;
	public static final int LOGIN_RESULT_CODE_SUCCESS=1002;//��¼�ɹ�
	public static final int LOGIN_RESULT_CODE_FAILURE=1003;//��¼ʧ��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(HttpTools.isLogin(this)){//����Ѿ���¼��ֱ�Ӽ���
			init(savedInstanceState);
		}else{//û�е�¼�������¼ҳ��
			Intent intent=new Intent(this,LoginActivity.class);
			startActivityForResult(intent, LOGIN_REQUEST_CODE);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==LOGIN_REQUEST_CODE){//��¼����
			if(resultCode==LOGIN_RESULT_CODE_SUCCESS){//��¼�ɹ�
				init(null);
				return;
			}
			//δ��¼ �����޸�
			notLogin();
		}
	}
	
	public abstract void notLogin();
	public abstract void init(Bundle savedInstanceState);
}