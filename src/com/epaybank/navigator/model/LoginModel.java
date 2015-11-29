package com.epaybank.navigator.model;

import java.util.List;

import org.apache.http.cookie.Cookie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epaybank.navigator.bean.UserAccountInfo;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.bean.UserState;
import com.epaybank.navigator.utils.HttpProxy;
import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.utils.UrlFactory;
import com.epaybank.navigator.utils.HttpProxy.OnHttpBackListener;
import com.org.finalmvp.model.BaseModel;
/**
 * ��¼���
 * @author liangdong
 */
public class LoginModel extends BaseModel{
	private HttpProxy http;
	public LoginModel() {
		http=HttpProxy.getInstance();
	}
	@Override
	public void loadData(int tag, Object msg) {
	}
	
	
	/**
	 * ��½���ȡ�ҵ���ϸ��Ϣ
	 */
	public void gainStateInfo(final int tag,String userId){
		http.doPost(UrlFactory.gainUserStates(userId), new OnHttpBackListener() {
			@Override
			public void onSuccess(String r) {
				if(HttpTools.isSuccess(r)){//��ȷ���󷵻�����
					UserState us=JSON.toJavaObject(JSON.parseObject(r).getJSONObject("data"), UserState.class);
					chanageData(tag, us);
				}else{
					error(tag, null);
				}
			}
			@Override
			public void onError(String msg) {
				error(tag, msg);
			}
		});
	}
	
	/**
	 * ��ȡ�û���ϸ��Ϣ
	 */
	public void gainUserInfo(final int tag){
		http.doPost(UrlFactory.gainMyInfo(), new OnHttpBackListener() {
			@Override
			public void onSuccess(String r) {
				if(HttpTools.isSuccess(r)){//��ȷ���󷵻�����
					UserInfo us=JSON.toJavaObject(JSON.parseObject(r).getJSONObject("data"), UserInfo.class);
					chanageData(tag, us);
				}else{
					if(r!=null){
						JSONObject jo=JSON.parseObject(r);
						if(jo!=null){
							error(tag, jo.getString("msg"));
							return;
						}
					}
					error(tag, null);
				}
			}
			@Override
			public void onError(String msg) {
				error(tag, msg);
			}
		});
	}
	
	
	
	/**
	 * ��ȡcookie
	 * @return
	 */
	public List<Cookie> getCookie() {
		return http.getCookie();
	}
	
	/**
	 * ��¼
	 * @param tag
	 * @param username
	 * @param password
	 */
	public void login(final int tag,String username,String password){
		http.doPost(UrlFactory.Login(username, password),new OnHttpBackListener() {
			@Override
			public void onSuccess(String r) {
				if(r==null){
					error(tag, null);
				}
				JSONObject jo = JSON.parseObject(r);
				if(jo==null) {
					error(tag, null);
				}
				if(HttpTools.isSuccess(r)){//��ȷ���󷵻�����
					UserAccountInfo info=JSON.toJavaObject(jo.getJSONObject("data"), UserAccountInfo.class);
					chanageData(tag,info);
				}else{//�������������ش�����Ϣ
					error(tag, jo.getString("msg"));
				}
			}
			@Override
			public void onError(String msg) {
				error(tag, msg);
			}
		});
	}
	
	
	
}