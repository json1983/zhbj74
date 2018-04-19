package com.itheima.zhbj74.fragment;

import java.util.zip.Inflater;

import com.itheima.zhbj74.R;
import com.lidroid.xutils.ViewUtils;

import android.view.View;

public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView() {
		View view=View.inflate(mActivity, R.layout.fragment_left_menu, null);
		// lvList = (ListView) view.findViewById(R.id.lv_list);
		ViewUtils.inject(this, view);// 注入view和事件
		return view;
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
