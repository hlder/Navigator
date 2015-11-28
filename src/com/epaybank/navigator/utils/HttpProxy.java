package com.epaybank.navigator.utils;

import java.util.List;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;

import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.util.Log;

import com.hld.library.frame.http.HttpUtils;

/**
 * http请求执行代理类
 * @author liangdong
 */
public class HttpProxy{
	private static HttpProxy httpProxy;
	
	private HttpUtils http;
	
	private HttpProxy() {
		http=new HttpUtils();
		
	}
	public static synchronized HttpProxy getInstance(){
		if(httpProxy==null){
			httpProxy=new HttpProxy();
		}
		return httpProxy;
	}
	
	public List<Cookie> getCookie() {
		if(http.getHttpClient() instanceof AbstractHttpClient){
			List<Cookie> cookies =((AbstractHttpClient) http.getHttpClient()).getCookieStore().getCookies();
			for(Cookie c:cookies){
				Log.d("dddd", "cookie:"+c);
			}
			return cookies;
		}
		return null;
	}
	
	public void doPost(String url,OnHttpBackListener listener) {
		doPost(url,null, listener);
	}
	
	public void doPost(String url,AjaxParams params,final OnHttpBackListener listener) {
		Log.d("http", url);
		http.post(url, params, new AjaxCallBack<String>() {
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				Log.e("http", ""+strMsg);
				if(t!=null)
					t.printStackTrace();
				if(listener!=null){
					listener.onError(strMsg);
				}
			}
			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				Log.d("http", "返回:"+t);
				if(listener!=null){
					listener.onSuccess(t);
				}
			}
		});
	}
	
	
	public interface OnHttpBackListener{
		void onSuccess(String r);
		void onError(String msg);
	}
	
}