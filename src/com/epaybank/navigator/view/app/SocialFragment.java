package com.epaybank.navigator.view.app;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;

/**
 * »¥¶¯£¬¶¯Ì¬
 * @author liangdong
 */
public class SocialFragment extends AppFragment{
	private RecyclerView rcyView;
	@Override
	public View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_social, null);
		rcyView=(RecyclerView) view.findViewById(R.id.rcyView);
		rcyView.setLayoutManager(new LinearLayoutManager(getActivity()));
		return view;
	}
}