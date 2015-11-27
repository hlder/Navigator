package com.epaybank.navigator.presenter;

import com.epaybank.navigator.model.LoginModel;
import com.org.finalmvp.model.BaseModel;
import com.org.finalmvp.presenter.BasePresenter;
import com.org.finalmvp.view.BaseView;

public class LoginPresenter extends BasePresenter{
	public static final int TAG_LOGIN=1;
	
	private LoginModel model;
	public LoginPresenter(BaseView view) {
		super(view);
	}
	
	
	public void doLogin(String username,String password) {
		model.login(TAG_LOGIN, username, password);
	}
	
	/**
	 * 正确返回
	 */
	@Override
	public void onModelCallBack(int tag, Object obj) {
		switch (tag) {
		case TAG_LOGIN:
			
			break;
		}
	}
	/**
	 * 出错后返回
	 */
	@Override
	public void onModelErrorBack(int tag, String msg) {
		
	}
	
	@Override
	public BaseModel initModel() {
		model=new LoginModel();
		return model;
	}
}