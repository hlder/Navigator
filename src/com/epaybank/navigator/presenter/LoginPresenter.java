package com.epaybank.navigator.presenter;

import android.content.Context;

import com.epaybank.navigator.bean.UserAccountInfo;
import com.epaybank.navigator.model.LoginModel;
import com.epaybank.navigator.utils.AppParams;
import com.epaybank.navigator.utils.HttpTools;
import com.org.finalmvp.model.BaseModel;
import com.org.finalmvp.presenter.BasePresenter;
import com.org.finalmvp.view.BaseView;

/**
 * login����Ĵ���
 * @author liangdong
 */
public class LoginPresenter extends BasePresenter{
	
	private LoginModel model;
	public LoginPresenter(BaseView view) {
		super(view);
	}
	
	
	public void doLogin(String username,String password) {
		model.login(AppParams.PRESENTER_TAG_LOGIN, username, password);
	}
	
	/**
	 * ��ȷ����
	 */
	@Override
	public void onModelCallBack(int tag, Object obj) {
		switch (tag) {
		case AppParams.PRESENTER_TAG_LOGIN://��½�ɹ�,�����û���Ϣ,Cookie
			HttpTools.saveCookie((Context) getBaseView(),model.getCookie());//����cookie
			HttpTools.saveUserAccountInfo((Context) getBaseView(),(UserAccountInfo) obj);//�����û���Ϣ
			
			setDataChanage(obj);
			break;
		}
	}
	/**
	 * ����󷵻�
	 */
	@Override
	public void onModelErrorBack(int tag, String msg) {
		chanageViewUi(tag,msg);
	}
	
	@Override
	public BaseModel initModel() {
		model=new LoginModel();
		return model;
	}
}