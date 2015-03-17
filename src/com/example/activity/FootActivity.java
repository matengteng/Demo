package com.example.activity;

import com.example.demo.R;
import com.example.fragment.FragmentTwo;
import com.example.tabfoot.FirstActivity;
import com.example.tabfoot.SecondActivity;
import com.example.tabfoot.ThirdActivity;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class FootActivity extends TabActivity {
	TabHost tabHost;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foot_list);// 这里使用了上面创建的xml文件（Tab页面的布局）
		Resources res = getResources(); // Resource object to get Drawables
		tabHost = getTabHost(); // The activity TabHost
		TabSpec spec;
		Intent intent; // Reusable Intent for each tab
		// 第一个Tab
		intent = new Intent(this, FirstActivity.class);// 新建一个Intent用作Tab1显示的内容
		spec = tabHost.newTabSpec("tab1")// 新建一个 Tab
				.setIndicator("新品")// 设置名称以及图标
				.setContent(intent);// 设置显示的intent，这里的参数也可以是R.id.xxx
		tabHost.addTab(spec);// 添加进tabHost

		// 第二个Tab
		intent = new Intent(this, SecondActivity.class);// 第二个Intent用作Tab1显示的内容
		spec = tabHost.newTabSpec("tab2")// 新建一个 Tab
				.setIndicator("热卖")// 设置名称以及图标
				.setContent(intent);// 设置显示的intent，这里的参数也可以是R.id.xxx
		tabHost.addTab(spec);// 添加进tabHost

		// 第三个Tab
		intent = new Intent(this, ThirdActivity.class);// 第二个Intent用作Tab1显示的内容
		spec = tabHost.newTabSpec("tab3")// 新建一个 Tab
				.setIndicator("价格")// 设置名称以及图标
				.setContent(intent);// 设置显示的intent，这里的参数也可以是R.id.xxx
		tabHost.addTab(spec);// 添加进tabHost
		tabHost.setCurrentTab(0);// 设置当前的选项卡,这里为Tab1
		tabHost.setOnTabChangedListener(new OnTabChangedListener()); // 选择监听器
		updateTab(tabHost);
		findViewById(R.id.back_floation).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}

	/**
	 * 更新Tab标签的颜色，和字体的颜色
	 * 
	 * @param tabHost
	 */
	private void updateTab(final TabHost tabHost) {
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			View view = tabHost.getTabWidget().getChildAt(i);
			TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i)
					.findViewById(android.R.id.title);
			tv.setTextSize(16);
			tv.setTextColor(getResources().getColor(R.color.green));
			// tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格
			if (tabHost.getCurrentTab() == i) {// 选中
				view.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.tab_back));// 选中后的背景
			} else {// 不选中
				view.setBackgroundColor(getResources().getColor(
						R.color.foot_tab));// 非选择的背景
			}
		}
	}

	class OnTabChangedListener implements OnTabChangeListener {

		@Override
		public void onTabChanged(String tabId) {
			tabHost.setCurrentTabByTag(tabId);
			updateTab(tabHost);
		}
	}
}
