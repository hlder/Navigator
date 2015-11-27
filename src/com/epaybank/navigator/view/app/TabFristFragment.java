package com.epaybank.navigator.view.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;

@SuppressLint("InflateParams")
public class TabFristFragment extends AppFragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_tab_frist, null);
		return view;
	}
}