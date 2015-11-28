package com.epaybank.navigator.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.utils.HttpProxy;
import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.utils.UrlFactory;
import com.epaybank.navigator.utils.HttpProxy.OnHttpBackListener;
import com.org.finalmvp.model.BaseModel;

public class LoginModel extends BaseModel{
	private HttpProxy http;
	public LoginModel() {
		http=HttpProxy.getInstance();
	}
	@Override
	public void loadData(int tag, Object msg) {
		
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
					//��¼�ɹ�����Cookie
					HttpTools.saveCookie(http.getCookie());
					UserInfo info=JSON.toJavaObject(jo.getJSONObject("data"), UserInfo.class);
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