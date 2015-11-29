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
 * tab页的我
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
		case R.id.btn_edit://编辑按钮
			
			break;
		case R.id.photo://点击头像
			
			break;
		case R.id.btn_login://用户登录
			skipActivity(LoginActivity.class);
			break;
		case R.id.btn_register://用户注册
			skipActivity(RegisterActivity.class);
			break;
		case R.id.set_item_1://一键开户
			
			break;
		case R.id.set_item_2://已关联券商
			skipActivity(WebViewActivity.class, UrlFactory.associatedBrokers());
			break;
		case R.id.set_item_3://我的钱包
			skipActivity(WebViewActivity.class, UrlFactory.myWallet());
			break;
		case R.id.set_item_4://好友管理
			skipActivity(WebViewActivity.class, UrlFactory.friendsMgr());
			break;
		case R.id.set_item_5://邀请有礼
			skipActivity(WebViewActivity.class, UrlFactory.inviteGift());
			break;
		case R.id.set_item_6://系统信息
			skipActivity(WebViewActivity.class, UrlFactory.systemNotice());
			break;
		case R.id.set_item_7://意见反馈
			
			break;
		case R.id.set_item_8://系统设置
			
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
	 * 加载我的个人信息
	 */
	private void initPersionInfo() {
		UserInfo userInfo = HttpTools.getMyInfo(getActivity());
		if(userInfo!=null){
			ImageView imgPhoto = (ImageView) persionInfoLayout.findViewById(R.id.photo);//头像
			TextView username=(TextView) persionInfoLayout.findViewById(R.id.user_name);//名字
			TextView userRole=(TextView) persionInfoLayout.findViewById(R.id.user_role);//角色(船长或领航员)
			TextView people_signature=(TextView) persionInfoLayout.findViewById(R.id.people_signature);//个性签名
			TextView textState=(TextView) persionInfoLayout.findViewById(R.id.text_state);//动态的数字
			TextView textFcous=(TextView) persionInfoLayout.findViewById(R.id.text_fcous);//关注的数字
			TextView textFriend=(TextView) persionInfoLayout.findViewById(R.id.text_friend);//好友数
			TextView textFllows=(TextView) persionInfoLayout.findViewById(R.id.text_fllows);//跟买者 数量
			TextView textFllowLable=(TextView) persionInfoLayout.findViewById(R.id.text_fllow_lable);//跟买者的标签
			
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
				
				if(AppTools.isTheLeader(userInfo.getType())){//是领航员
					textFllows.setText(us.getFollowBuyNum());
				}else{//是船长
					textFllows.setText(us.getGroupNum());
				}
			}
			
			
			
		}
		
		
		
	}
	
	
	

	@Override
	public void onEvent(String action, Object obj) {
		if(action.equals(AppParams.EVENTBUS_ACTION_LOGIN)){//登录成功，请求更新
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
