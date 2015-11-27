package com.epaybank.navigator.view.app.adapter;

import com.epaybank.navigator.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("InflateParams")
public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.MyViewHolder>{
	private LayoutInflater inflater;
	public FriendListAdapter(Activity ctx) {
		inflater=ctx.getLayoutInflater();
	}
	
	
	@Override
	public int getItemCount() {
		return 10;
	}

	@Override
	public void onBindViewHolder(MyViewHolder arg0, int arg1) {
		
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup vg, int arg1) {
		View view=inflater.inflate(R.layout.view_friend, null);
		MyViewHolder vh=new MyViewHolder(view);
		return vh;
	}
	
	class MyViewHolder extends ViewHolder{
		public MyViewHolder(View arg0) {
			super(arg0);
		}
	}
}