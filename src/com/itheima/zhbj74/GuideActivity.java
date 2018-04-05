package com.itheima.zhbj74;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * @新手引导界面
 *
 */
public class GuideActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
		// 必须在setContentView之前调用
		setContentView(R.layout.activity_guide);
	}
}
