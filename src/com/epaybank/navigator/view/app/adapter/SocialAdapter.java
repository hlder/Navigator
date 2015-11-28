package com.epaybank.navigator.view.app.adapter;

import com.epaybank.navigator.R;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.MyViewHolder>{
	private LayoutInflater inflater;
	public SocialAdapter(Activity ctx) {
		inflater=ctx.getLayoutInflater();
	}
	@Override
	public int getItemCount() {
		return 10;
	}
	@Override
	public void onBindViewHolder(MyViewHolder vh, int p) {
	}
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=inflater.inflate(R.layout.view_social_state, arg0);
		MyViewHolder vh=new MyViewHolder(view);
		return vh;
	}
	class MyViewHolder extends ViewHolder{
		public MyViewHolder(View view) {
			super(view);
		}
	}
}
