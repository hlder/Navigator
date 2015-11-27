package com.epaybank.navigator.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hld.library.frame.Fragment;

public abstract class AppFragment extends Fragment{
	private View fragmentView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		if(fragmentView==null){
			fragmentView=createView(inflater, container, savedInstanceState);
		}else{
			if(fragmentView.getParent()!=null&&fragmentView.getParent() instanceof ViewGroup){
				ViewGroup vg=(ViewGroup) fragmentView.getParent();
				vg.removeView(fragmentView);
			}
		}
		return fragmentView;
	}
	
	public abstract View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) ;
	
	
}