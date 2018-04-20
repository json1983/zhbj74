package com.itheima.zhbj74.fragment;

import java.util.ArrayList;

import com.itheima.zhbj74.R;
import com.itheima.zhbj74.view.NoScrollViewPager;

import android.view.View;
import android.widget.RadioGroup;

public class ContentFragment extends BaseFragment {

	private NoScrollViewPager mViewPager;
	private RadioGroup rgGroup;

	private ArrayList<BasePager> mPagers;// 五个标签页的集合

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
		rgGroup = (RadioGroup) view.findViewById(R.id.rg_group);
		return view;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
