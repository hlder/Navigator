package com.epaybank.navigator.view.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;

public class TabThreeFragment extends AppFragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_tab_three, null);
		return view;
	}
}
