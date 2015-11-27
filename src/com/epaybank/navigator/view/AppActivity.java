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
	 * 依赖注入后，当数据改变时固定修改
	 */
	@Override
	public void onChanageUi(int tag) {
		
	}
}
