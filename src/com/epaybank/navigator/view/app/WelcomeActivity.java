package com.epaybank.navigator.view.app;

import android.content.Intent;
import android.os.Bundle;

import com.epaybank.navigator.view.AppActivity;

public class WelcomeActivity extends AppActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Intent intent=new Intent(this,LoginActivity.class);
//		Intent intent=new Intent(this,RegisterActivity.class);
		Intent intent=new Intent(this,MainActivity.class);
//		Intent intent=new Intent(this,WebViewActivity.class);
//		intent.putExtra(WebViewActivity.EXTRA_URL_KEY, "http://top.chinaz.com/");
		startActivity(intent);
		finish();
	}
}