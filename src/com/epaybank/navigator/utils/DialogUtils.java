package com.epaybank.navigator.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtils {
	
	/**
	 * 统一progressDialog样式
	 * @param context
	 * @return
	 */
	public static ProgressDialog getProgressDialog(Context context){
		ProgressDialog dialog=new ProgressDialog(context);
		dialog.setCancelable(false);
		return dialog;
	}
	
	
}