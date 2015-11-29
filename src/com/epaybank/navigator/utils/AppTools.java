package com.epaybank.navigator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epaybank.navigator.R;
import com.hld.library.frame.ImageManager;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

public class AppTools {
	/**
	 * 手机号验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) { 
		Pattern p = null;
		Matcher m = null;
		boolean b = false; 
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches(); 
		return b;
	}
	
	/**
	 * 设置船长或者领航员
	 */
	public static void setUserType(TextView textView,String type){
		Context ctx=textView.getContext();
		textView.setTextColor(Color.WHITE);
		if("2".equals(type)){//表示是领航员
			textView.setText(ctx.getString(R.string.text_user_type_pilot));
			textView.setBackgroundResource(R.drawable.bg_point_green);
		}else{//表示是船长
			textView.setText(ctx.getString(R.string.text_user_type_captain));
			textView.setBackgroundResource(R.drawable.bg_point_origin);
		}
	}
	/**
	 * 判断是否是领航员
	 */
	public static boolean isTheLeader(String type){
		if("2".equals(type)){
			return true;
		}
		return false;
	}
	
	/**
	 * 加载图片
	 * @param context
	 * @param iv
	 * @param url
	 */
	public static void displayImg(Context context,ImageView iv,String url){
		ImageManager.getInstance(context).display(iv, url);
	}
	
}