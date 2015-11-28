package com.epaybank.navigator.view;

import com.hld.library.frame.FragmentActivity;
import com.org.finalmvp.view.BaseView;

public class AppActivity extends FragmentActivity implements BaseView{

	
	/**
	 * 依赖注入后，当数据发生改变时
	 */
	@Override
	public void onDataChanage() {
		
	}
	/**
	 * presenter需要修改ui的时候进行调用
	 */
	@Override
	public void onChanageUi(int tag, Object msg) {
		
	}
}
