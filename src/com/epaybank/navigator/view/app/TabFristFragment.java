package com.epaybank.navigator.view.app;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;
import com.hld.library.frame.ViewPagerFragmentTabHost;

@SuppressLint("InflateParams")
public class TabFristFragment extends AppFragment{
	
	
	private View initViewPage() {
		ViewPagerFragmentTabHost tabhost=new ViewPagerFragmentTabHost(getActivity());
		tabhost.setTabSelectBg(R.drawable.bg_tb_top);
		tabhost.setTabItemBg(R.drawable.color_white);
		tabhost.setTabBgColor(Color.WHITE);
		tabhost.setTabTextColor(getResources().getColor(R.color.gray_text));
		tabhost.setTabTextSelectColor(getResources().getColor(R.color.tab_text));
		tabhost.setTabTextSize(18);
		
		tabhost.addTab(tabhost.newTab().setText(getString(R.string.tab_top_friend)).setFragment(new FriendListFragment()));
		tabhost.addTab(tabhost.newTab().setText(getString(R.string.tab_top_friend)).setFragment(new FriendListFragment()));
		return tabhost.getView();
	}

	@Override
	public View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_tab_frist, null);
		FrameLayout layout=(FrameLayout) view.findViewById(R.id.friendsLayout);
		layout.addView(initViewPage());
		return view;
	}
}