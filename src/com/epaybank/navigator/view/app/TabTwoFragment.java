package com.epaybank.navigator.view.app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;
import com.hld.library.frame.ViewPagerFragmentTabHost;

public class TabTwoFragment extends AppFragment{

	@Override
	public View createView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initViewPage();
	}
	
	
	
	private View initViewPage() {
		ViewPagerFragmentTabHost tabhost=new ViewPagerFragmentTabHost(getActivity());
		tabhost.setTabSelectBg(R.drawable.bg_tb_top);
		tabhost.setTabItemBg(R.drawable.color_white);
		tabhost.setTabBgColor(Color.WHITE);
		tabhost.setTabTextColor(getResources().getColor(R.color.gray_text));
		tabhost.setTabTextSelectColor(getResources().getColor(R.color.tab_text));
		tabhost.setTabTextSize(18);
		
		tabhost.addTab(tabhost.newTab().setText(getString(R.string.tab_top_friend)).setFragment(new SocialFragment()));
		tabhost.addTab(tabhost.newTab().setText(getString(R.string.tab_top_friend)).setFragment(new ChatRoomFragment()));
		return tabhost.getView();
	}
}
