package com.epaybank.navigator.view.app;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppActivity;
import com.hld.library.frame.FragmentTabHost;
import com.hld.library.frame.fragment.FragmentTabHostFrame.OnItemSelectListener;
import com.hld.library.frame.fragment.FragmentTabHostFrame.TabSpec;

/**
 * 主界面 
 * @author liangdong
 */
@SuppressLint("InflateParams")
public class MainActivity extends AppActivity{
	private List<View> listTabs;
	private int lastSelectId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentTabHost tabhost=new FragmentTabHost(this);
		setContentView(tabhost);
		setTitleBackground(R.drawable.bg_main_title);
		
		
		listTabs=new ArrayList<View>();
		
		tabhost.addTab(tabhost.newTabSpec().setIndicator(initTabView(R.drawable.main_normal_001,R.drawable.main_press_001,getString(R.string.tab_main))), new TabFristFragment());
		tabhost.addTab(tabhost.newTabSpec().setIndicator(initTabView(R.drawable.main_normal_002,R.drawable.main_press_002,getString(R.string.tab_ugc))), new TabTwoFragment());
		tabhost.addTab(tabhost.newTabSpec().setIndicator(initTabView(R.drawable.main_normal_003,R.drawable.main_press_003,getString(R.string.tab_earnings))), new TabThreeFragment());
		tabhost.addTab(tabhost.newTabSpec().setIndicator(initTabView(R.drawable.main_normal_004,R.drawable.main_press_004,getString(R.string.tab_mine))), new TabFourFragment());
		
		lastSelectId=0;
		chanageTab(listTabs.get(0), true);
		/**
		 * 当选择某一项时,切换ui
		 */
		tabhost.setOnItemSelectListener(new OnItemSelectListener() {
			@Override
			public void onItemSelect(int p, TabSpec tab, Fragment fragment) {
				if(lastSelectId==p){
					return;
				}
				chanageTab(listTabs.get(p), true);
				chanageTab(listTabs.get(lastSelectId), false);
				lastSelectId=p;
			}
		});
		
		
		tabhost.setPostion(3);//====================================临时切换===============================
	}
	
	
	
	private void chanageTab(View view,boolean isSelected) {
		if(view.getTag()!=null&&view.getTag() instanceof ViewHolder){
			ViewHolder vh=(ViewHolder) view.getTag();
			if(isSelected){
				vh.imageView.setImageResource(vh.selectedResid);
				vh.textView.setTextColor(vh.selectedTextColor);
			}else{
				vh.imageView.setImageResource(vh.resid);
				vh.textView.setTextColor(vh.textColor);
			}
		}
	}
	private View initTabView(int resid,int selectedResid,String name) {
		View view=getLayoutInflater().inflate(R.layout.view_tab, null);
		ViewHolder vh = new ViewHolder();
		vh.imageView=(ImageView)view.findViewById(R.id.imageView);
		vh.imageView.setImageResource(resid);
		vh.textView=(TextView) view.findViewById(R.id.textView);
		vh.textView.setText(name);
		vh.resid=resid;
		vh.selectedResid=selectedResid;
		vh.textColor=getResources().getColor(R.color.gray_text);
		vh.selectedTextColor=getResources().getColor(R.color.tab_text);
		vh.textView.setTextColor(vh.textColor);
		view.setTag(vh);
		listTabs.add(view);
		return view;
	}
	private class ViewHolder{
		ImageView imageView;
		TextView textView;
		int resid;
		int selectedResid;
		int textColor;
		int selectedTextColor;
	}
	
	
}