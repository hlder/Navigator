package com.epaybank.navigator.view.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epaybank.navigator.R;
import com.epaybank.navigator.view.AppFragment;
import com.epaybank.navigator.view.app.adapter.FriendListAdapter;

/**
 * 好友列表页面
 * @author liangdong
 */
@SuppressLint("InflateParams")
public class FriendListFragment extends AppFragment{
	private RecyclerView friendsRcy;
	private FriendListAdapter adapter;
	@Override
	public View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_friend_list, null);
		friendsRcy=(RecyclerView) view.findViewById(R.id.friendsRcy);
		init();
		return view;
	}
	private void init() {
		adapter=new FriendListAdapter(getActivity());
		
		friendsRcy.setLayoutManager(new LinearLayoutManager(getActivity()));
		
		friendsRcy.setAdapter(adapter);
	}
	
	
	
	
	
	
}