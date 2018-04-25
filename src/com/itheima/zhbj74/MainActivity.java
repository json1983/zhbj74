package com.itheima.zhbj74;

import com.itheima.zhbj74.fragment.ContentFragment;
import com.itheima.zhbj74.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends SlidingFragmentActivity {
	private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
	private static final String TAG_CONTENT = "TAG_CONTENT";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.left_menu);
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 全屏触摸
		slidingMenu.setBehindOffset(200);// 屏幕预留200像素宽度
		initFragment();
	}

	/**
	 * 初始化fragment
	 */
	private void initFragment() {
		FragmentManager fm=getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();// 开始事务
		transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),
				TAG_LEFT_MENU);// 用fragment替换帧布局;参1:帧布局容器的id;参2:是要替换的fragment;参3:标记
		transaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
		transaction.commit();// 提交事务
		// Fragment fragment =
		// fm.findFragmentByTag(TAG_LEFT_MENU);//根据标记找到对应的fragment

	}
	// 获取侧边栏fragment对象
		public LeftMenuFragment getLeftMenuFragment() {
			FragmentManager fm = getSupportFragmentManager();
			LeftMenuFragment fragment = (LeftMenuFragment) fm
					.findFragmentByTag(TAG_LEFT_MENU);// 根据标记找到对应的fragment
			return fragment;
		}

		// 获取主页fragment对象
		public ContentFragment getContentFragment() {
			FragmentManager fm = getSupportFragmentManager();
			ContentFragment fragment = (ContentFragment) fm
					.findFragmentByTag(TAG_CONTENT);// 根据标记找到对应的fragment
			return fragment;
		}
}
