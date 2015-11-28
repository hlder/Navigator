package com.epaybank.navigator.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtils {
	
	
	public static void showProgressDialog(Context context){
		ProgressDialog dialog=new ProgressDialog(context);
		dialog.setMessage("loadding");
		dialog.show();
	}
	
	
}