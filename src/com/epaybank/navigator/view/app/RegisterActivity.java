package com.epaybank.navigator.view.app;

import android.os.Bundle;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppActivity;

public class RegisterActivity extends AppActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		setTitleBackgroundColor(getResources().getColor(R.color.theme_color));
		setTitle(""+getString(R.string.btn_doregister));
		showTitleBackButton();
		
	}
}