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
 * ��¼��ɺ�ͨ��useridȥ��ȡ�û���ϸ��Ϣ
 * ����ȡ������ϸ��Ϣ������application��
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
	 * ��ȡ״̬��Ϣ��
	 */
	public void gainStateInfo(String userId) {
		model.gainStateInfo(AppParams.PRESENTER_TAG_GAIN_STATE_INFO, userId);
	}
	
	/**
	 * ��ȡ�û���ϸ��Ϣ
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
		case AppParams.PRESENTER_TAG_GAIN_STATE_INFO://�����û�״̬
			HttpTools.saveUserState(context, (UserState) obj);
			gainUserInfo();
			break;
		case AppParams.PRESENTER_TAG_GAIN_MY_INFO://�����û���Ϣ
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
		 * ��¼����
		 */
		chanageViewUi(AppParams.PRESENTER_TAG_LOGIN,""+context.getString(R.string.error_msg_gainfail));
		
	}
}