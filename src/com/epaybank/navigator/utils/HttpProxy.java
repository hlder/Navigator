package com.epaybank.navigator.utils;

import net.tsz.afinal.http.AjaxParams;

import android.util.Log;

import com.hld.library.frame.HttpManager;
import com.hld.library.frame.http.HttpListener;

/**
 * http请求执行代理类
 * @author liangdong
 */
public class HttpProxy implements HttpListener<String>{
	private HttpManager http;
	private OnHttpBackListener onHttpBackListener;
	public HttpProxy() {
		http=new HttpManager();
		http.setHttpListener(this);
	}
	
	public void doPost(int id,String url) {
//		http.doPost(id, url);
		doPost(id, null, url);
	}
	
	public void doPost(int id,AjaxParams params,String url) {
		Log.d("http", url);
		http.doPost(id,params,url);
	}
	
//	public void doPost(){
//		http.doPost(id, params, url);
//	}
	
	
	public void setOnHttpBackListener(OnHttpBackListener onHttpBackListener) {
		this.onHttpBackListener=onHttpBackListener;
	}
	
	
	public interface OnHttpBackListener{
		void onSuccess(int id, String r);
		void onError(String msg);
	}
	
	@Override
	public void onLoading(int id, long count, long current) {
		
	}
	@Override
	public void onSuccess(int id, String t) {
		Log.d("http", "返回:"+t);
		if(onHttpBackListener!=null){
			onHttpBackListener.onSuccess(id, t);
		}
	}
	@Override
	public void onStart(int id) {
		
	}
	@Override
	public void onFailure(int id, Throwable t, String strMsg) {
		if(onHttpBackListener!=null){
			onHttpBackListener.onError(strMsg);
		}
	}
}