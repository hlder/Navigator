package com.epaybank.navigator.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtils {
	
	/**
	 * ͳһprogressDialog��ʽ
	 * @param context
	 * @return
	 */
	public static ProgressDialog getProgressDialog(Context context){
		ProgressDialog dialog=new ProgressDialog(context);
		dialog.setCancelable(false);
		return dialog;
	}
	
	
}