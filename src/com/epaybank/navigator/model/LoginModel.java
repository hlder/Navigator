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
 * 登录相关
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
	 * 登陆后获取我的详细信息
	 */
	public void gainStateInfo(final int tag,String userId){
		http.doPost(UrlFactory.gainUserStates(userId), new OnHttpBackListener() {
			@Override
			public void onSuccess(String r) {
				if(HttpTools.isSuccess(r)){//正确请求返回数据
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
	 * 获取用户详细信息
	 */
	public void gainUserInfo(final int tag){
		http.doPost(UrlFactory.gainMyInfo(), new OnHttpBackListener() {
			@Override
			public void onSuccess(String r) {
				if(HttpTools.isSuccess(r)){//正确请求返回数据
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
	 * 获取cookie
	 * @return
	 */
	public List<Cookie> getCookie() {
		return http.getCookie();
	}
	
	/**
	 * 登录
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
				if(HttpTools.isSuccess(r)){//正确请求返回数据
					UserAccountInfo info=JSON.toJavaObject(jo.getJSONObject("data"), UserAccountInfo.class);
					chanageData(tag,info);
				}else{//服务器报错，返回错误信息
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