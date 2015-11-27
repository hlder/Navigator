package com.epaybank.navigator.view.app;

import android.os.Bundle;

import com.epaybank.navigator.view.AppActivity;
import com.hld.library.frame.FragmentTabHost;

/**
 * Ö÷½çÃæ 
 * @author liangdong
 */
public class MainActivity extends AppActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentTabHost tabhost=new FragmentTabHost(this);
		setContentView(tabhost);
		
		tabhost.addTab(tabhost.newTabSpec().setIndicator("aa1"), new TabFristFragment());
		
		tabhost.addTab(tabhost.newTabSpec().setIndicator("aa2"), new TabTwoFragment());
		
		tabhost.addTab(tabhost.newTabSpec().setIndicator("aa3"), new TabThreeFragment());
		
	}
}