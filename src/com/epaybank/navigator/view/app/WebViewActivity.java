package com.epaybank.navigator.view.app;

import java.util.List;

import org.apache.http.cookie.Cookie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.epaybank.navigator.R;
import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.view.AppActivity;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends AppActivity{
	public static final String EXTRA_URL_KEY="EXTRA_URL_KEY";
	private WebView mWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		setNoTitle();
		String url=getIntent().getStringExtra(EXTRA_URL_KEY);
		
		Log.d("dddd", ""+url);
		
		mWebView=(WebView) findViewById(R.id.webView);
		mWebView.setWebViewClient(new WebViewClient());
		mWebView.getSettings().setJavaScriptEnabled(true);//支持javascript
		mWebView.getSettings().setBuiltInZoomControls(true);
//		mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.requestFocus();
		
		List<Cookie> cookies=HttpTools.getCookie();
		if(cookies!=null){
			CookieManager cookieManager = CookieManager.getInstance();
	        //获取登陆时的cookie
			StringBuffer sb=new StringBuffer();
			for (Cookie c:cookies) {
				sb.append(c.getName()+"="+c.getValue()+";");
			}
	        cookieManager.setCookie(url, sb.toString());
	        Log.d("http", "webViewUrl:"+url);
			mWebView.loadUrl(url);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}
}