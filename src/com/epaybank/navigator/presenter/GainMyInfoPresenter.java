package com.epaybank.navigator.presenter;

import android.content.Context;

import com.epaybank.navigator.R;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.bean.UserState;
import com.epaybank.navigator.model.LoginModel;
import com.epaybank.navigator.utils.AppParams;
import com.epaybank.navigator.utils.HttpTools;
import com.org.finalmvp.model.BaseModel;
import com.org.finalmvp.presenter.BasePresenter;
import com.org.finalmvp.view.BaseView;

/**
 * 登录完成后，通过userid去获取用户详细信息
 * 将获取到的详细信息保存在application中
 * @author liangdong
 */
public class GainMyInfoPresenter extends BasePresenter{
	
	private LoginModel model;
	private Context context;

	public GainMyInfoPresenter(BaseView view) {
		super(view);
		context=(Context) view;
	}

	
	/**
	 * 获取状态信息，
	 */
	public void gainStateInfo(String userId) {
		model.gainStateInfo(AppParams.PRESENTER_TAG_GAIN_STATE_INFO, userId);
	}
	
	/**
	 * 获取用户详细信息
	 */
	public void gainUserInfo(){
		model.gainUserInfo(AppParams.PRESENTER_TAG_GAIN_MY_INFO);
	}
	
	
	@Override
	public BaseModel initModel() {
		model= new LoginModel();
		return model;
	}
	@Override
	public void onModelCallBack(int tag, Object obj) {
		switch (tag) {
		case AppParams.PRESENTER_TAG_GAIN_STATE_INFO://保存用户状态
			HttpTools.saveUserState(context, (UserState) obj);
			gainUserInfo();
			break;
		case AppParams.PRESENTER_TAG_GAIN_MY_INFO://保存用户信息
			HttpTools.saveMyInfo(context, (UserInfo) obj);
			chanageViewUi(tag, true);
			break;
		default:
			break;
		}

	}
	@Override
	public void onModelErrorBack(int tag, String msg) {
		/**
		 * 登录出错
		 */
		chanageViewUi(AppParams.PRESENTER_TAG_LOGIN,""+context.getString(R.string.error_msg_gainfail));
		
	}
}