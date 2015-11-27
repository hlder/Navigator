package com.epaybank.navigator.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epaybank.navigator.bean.UserInfo;
import com.epaybank.navigator.utils.HttpProxy;
import com.epaybank.navigator.utils.UrlFactory;
import com.epaybank.navigator.utils.HttpProxy.OnHttpBackListener;
import com.org.finalmvp.model.BaseModel;

public class LoginModel extends BaseModel{
	private HttpProxy http;
	public LoginModel() {
		http=new HttpProxy();
		http.setOnHttpBackListener(onHttpBackListener);
	}
	@Override
	public void loadData(int tag, Object msg) {
		
	}
	
	/**
	 * µÇÂ¼
	 * @param tag
	 * @param username
	 * @param password
	 */
	public void login(int tag,String username,String password){
		http.doPost(tag, UrlFactory.Login(username, password));
	}
	
	
	
	private OnHttpBackListener onHttpBackListener=new OnHttpBackListener() {
		@Override
		public void onSuccess(int id, String r) {
			JSONObject jo = JSON.parseObject(r);
			int code=jo.getIntValue("code");
			String msg=jo.getString("msg");
			
			UserInfo info=JSON.toJavaObject(jo.getJSONObject("data"), UserInfo.class);
			
			
			chanageData(id, info);
		}
		@Override
		public void onError(String msg) {
			
		}
	};
}