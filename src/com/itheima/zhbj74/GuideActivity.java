package com.itheima.zhbj74;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @新手引导界面
 *
 */
public class GuideActivity extends Activity {
	private Button btnStart;
	private ImageView ivRedPoint;
	private LinearLayout llContainer;
	private ViewPager mViewPager;
	private ArrayList<ImageView> mImageViewList;
	private int[] mImageIds=new int[]{ R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题,
		// 必须在setContentView之前调用
		setContentView(R.layout.activity_guide);
		mViewPager = (ViewPager) findViewById(R.id.vp_guide);
		llContainer = (LinearLayout) findViewById(R.id.ll_container);
		ivRedPoint = (ImageView) findViewById(R.id.iv_red_point);
		btnStart = (Button) findViewById(R.id.btn_start);
		initData();// 先初始化数据
		mViewPager.setAdapter(new GuideAdapter());
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position) {
				// 某个页面被选中
				if (position==mImageViewList.size()-1) {
					btnStart.setVisibility(View.VISIBLE);
				}else {
					btnStart.setVisibility(View.INVISIBLE);
				}
				
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
	}

	private void initData() {
		mImageViewList = new ArrayList<ImageView>();
		for (int i = 0; i < mImageIds.length; i++) {
			ImageView view = new ImageView(this);
			view.setBackgroundResource(mImageIds[i]);// 通过设置背景,可以让宽高填充布局
			mImageViewList.add(view);
			// 初始化小圆点
			ImageView point = new ImageView(this);
			point.setBackgroundResource(R.drawable.shape_point_gray);
			// 初始化布局参数, 宽高包裹内容,父控件是谁,就是谁声明的布局参数
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			if (i>0) {
				params.leftMargin=10;
			}
			point.setLayoutParams(params);
			llContainer.addView(point);// 给容器添加圆点
		}
		
	}
	class GuideAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImageViewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		// 销毁item
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((View) object);
		}
		// 初始化item布局
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			ImageView view = mImageViewList.get(position);
			container.addView(view);
			return view;
		}
	}
}
