package com.epaybank.navigator.view.app;

import java.lang.ref.WeakReference;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epaybank.navigator.R;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.bean.UserState;
import com.epaybank.navigator.utils.AppParams;
import com.epaybank.navigator.utils.AppTools;
import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.utils.UrlFactory;
import com.epaybank.navigator.view.AppFragment;
import com.hld.library.frame.EventBus;
import com.hld.library.frame.eventbus.EventBusListener;

/**
 * tabҳ����
 * @author liangdong
 */
@SuppressLint("InflateParams")
public class TabFourFragment extends AppFragment implements OnClickListener,EventBusListener{
	private View unLoginLayout,persionInfoLayout;
	private MyHandler handler;
	@Override
	public View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		handler=new MyHandler(this);
		registerEvents();
		View view=inflater.inflate(R.layout.fragment_tab_four, null);
		initClick(view);
		init();
		return view;
	}
	
	
	private void registerEvents() {
		EventBus.register(this, AppParams.EVENTBUS_ACTION_LOGIN);
	}
	
	private void initClick(View view) {
		unLoginLayout=view.findViewById(R.id.unLoginLayout);
		persionInfoLayout=view.findViewById(R.id.persionInfoLayout);
		
		persionInfoLayout.findViewById(R.id.photo).setOnClickListener(this);
		view.findViewById(R.id.btn_edit).setOnClickListener(this);
		view.findViewById(R.id.set_item_1).setOnClickListener(this);
		view.findViewById(R.id.set_item_2).setOnClickListener(this);
		view.findViewById(R.id.set_item_3).setOnClickListener(this);
		view.findViewById(R.id.set_item_4).setOnClickListener(this);
		view.findViewById(R.id.set_item_5).setOnClickListener(this);
		view.findViewById(R.id.set_item_6).setOnClickListener(this);
		view.findViewById(R.id.set_item_7).setOnClickListener(this);
		view.findViewById(R.id.set_item_8).setOnClickListener(this);
		
		view.findViewById(R.id.btn_login).setOnClickListener(this);
		view.findViewById(R.id.btn_register).setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_edit://�༭��ť
			
			break;
		case R.id.photo://���ͷ��
			
			break;
		case R.id.btn_login://�û���¼
			skipActivity(LoginActivity.class);
			break;
		case R.id.btn_register://�û�ע��
			skipActivity(RegisterActivity.class);
			break;
		case R.id.set_item_1://һ������
			
			break;
		case R.id.set_item_2://�ѹ���ȯ��
			skipActivity(WebViewActivity.class, UrlFactory.associatedBrokers());
			break;
		case R.id.set_item_3://�ҵ�Ǯ��
			skipActivity(WebViewActivity.class, UrlFactory.myWallet());
			break;
		case R.id.set_item_4://���ѹ���
			skipActivity(WebViewActivity.class, UrlFactory.friendsMgr());
			break;
		case R.id.set_item_5://��������
			skipActivity(WebViewActivity.class, UrlFactory.inviteGift());
			break;
		case R.id.set_item_6://ϵͳ��Ϣ
			skipActivity(WebViewActivity.class, UrlFactory.systemNotice());
			break;
		case R.id.set_item_7://�������
			
			break;
		case R.id.set_item_8://ϵͳ����
			
			break;
		}
	}
	
	private void init() {
		showPersonOrLogin(HttpTools.isLogin(getActivity()));
	}
	
	private void showPersonOrLogin(boolean flag) {
		if(flag){
			persionInfoLayout.setVisibility(View.VISIBLE);
			unLoginLayout.setVisibility(View.GONE);
		}else{
			persionInfoLayout.setVisibility(View.GONE);
			unLoginLayout.setVisibility(View.VISIBLE);
		}
	}
	
	/**
	 * �����ҵĸ�����Ϣ
	 */
	private void initPersionInfo() {
		UserInfo userInfo = HttpTools.getMyInfo(getActivity());
		if(userInfo!=null){
			ImageView imgPhoto = (ImageView) persionInfoLayout.findViewById(R.id.photo);//ͷ��
			TextView username=(TextView) persionInfoLayout.findViewById(R.id.user_name);//����
			TextView userRole=(TextView) persionInfoLayout.findViewById(R.id.user_role);//��ɫ(�������캽Ա)
			TextView people_signature=(TextView) persionInfoLayout.findViewById(R.id.people_signature);//����ǩ��
			TextView textState=(TextView) persionInfoLayout.findViewById(R.id.text_state);//��̬������
			TextView textFcous=(TextView) persionInfoLayout.findViewById(R.id.text_fcous);//��ע������
			TextView textFriend=(TextView) persionInfoLayout.findViewById(R.id.text_friend);//������
			TextView textFllows=(TextView) persionInfoLayout.findViewById(R.id.text_fllows);//������ ����
			TextView textFllowLable=(TextView) persionInfoLayout.findViewById(R.id.text_fllow_lable);//�����ߵı�ǩ
			
			username.setText(userInfo.getNickName());
			if(userInfo.getSignature()!=null){
				people_signature.setText(userInfo.getSignature());
			}
			AppTools.setUserType(userRole, userInfo.getType());
			
//			AppTools.displayImg(getActivity(), imgPhoto, userInfo.)
			
			UserState us=HttpTools.getUserState(getActivity());
			if(us!=null){
				textState.setText(us.getDynamicNum());
				textFcous.setText(us.getAttentionNum());
				textFriend.setText(us.getFriendsNum());
				
				if(AppTools.isTheLeader(userInfo.getType())){//���캽Ա
					textFllows.setText(us.getFollowBuyNum());
				}else{//�Ǵ���
					textFllows.setText(us.getGroupNum());
				}
			}
			
			
			
		}
		
		
		
	}
	
	
	

	@Override
	public void onEvent(String action, Object obj) {
		if(action.equals(AppParams.EVENTBUS_ACTION_LOGIN)){//��¼�ɹ����������
			handler.sendEmptyMessage(1);
		}
	}
	
	private static class MyHandler extends Handler{
		private  WeakReference<TabFourFragment> fragment;
		public MyHandler(TabFourFragment fragment) {
			MyHandler.this.fragment=new WeakReference<TabFourFragment>(fragment);
		}
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			fragment.get().initPersionInfo();
			fragment.get().unLoginLayout.setVisibility(View.GONE);
			fragment.get().persionInfoLayout.setVisibility(View.VISIBLE);
		}
	}
	
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.remove(this);
	}
	
	
	
	
	private void skipActivity(Class<?> cls) {
		skipActivity(cls, null);
	}
	private void skipActivity(Class<?> cls,String url) {
		Intent intent=new Intent(getActivity(),cls);
		if(url!=null){
			intent.putExtra(WebViewActivity.EXTRA_URL_KEY, url);
		}
		startActivity(intent);
	}
}
