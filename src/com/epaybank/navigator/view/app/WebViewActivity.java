package com.epaybank.navigator.view.app;

import java.util.List;

import org.apache.http.cookie.Cookie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.epaybank.navigator.R;
import com.epaybank.navigator.utils.HttpTools;
import com.epaybank.navigator.view.AppLoginActivity;

/**
 * h5����,ֱ�Ӽ���html
 * @author liangdong
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebViewActivity extends AppLoginActivity{
	public static final String EXTRA_URL_KEY="EXTRA_URL_KEY";
	private WebView mWebView;
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void init(Bundle savedInstanceState) {
		setContentView(R.layout.activity_webview);
		setNoTitle();
		String url=getIntent().getStringExtra(EXTRA_URL_KEY);
		
		mWebView=(WebView) findViewById(R.id.webView);
		mWebView.setWebViewClient(new WebViewClient());
		mWebView.getSettings().setJavaScriptEnabled(true);//֧��javascript
		mWebView.getSettings().setBuiltInZoomControls(true);
//		mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.requestFocus();
		
		List<Cookie> cookies=HttpTools.getCookie(this);
		if(cookies!=null){
			CookieManager cookieManager = CookieManager.getInstance();
	        //��ȡ��½ʱ��cookie
			StringBuffer sb=new StringBuffer();
			for (Cookie c:cookies) {
				sb.append(c.getName()+"="+c.getValue()+";");
			}
	        cookieManager.setCookie(url, sb.toString());
			mWebView.loadUrl(url);
		}
	}

	@Override
	public void notLogin() {
		this.finish();
	}
}