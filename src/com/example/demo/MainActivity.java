package com.example.demo;

import com.example.app.FruitdayApplition;
import com.example.bean.Commodity;
import com.example.fragment.FragmentBase;
import com.example.fragment.FragmentFour;
import com.example.fragment.FragmentFrist;
import com.example.fragment.FragmentThree;
import com.example.fragment.FragmentTwo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
public class MainActivity extends FragmentActivity implements OnClickListener {

	LinearLayout img1, img2, img3, img4, img5;
	ImageView iv1, iv2, iv3, iv4, iv5;
	TextView tv1, tv2, tv3, tv4, tv5;
	FrameLayout fragment;
	FragmentManager manager;
	FragmentTransaction transaction;
	FragmentBase fragment1, fragment2, fragment3, fragment4, fragment5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		initLayout();
		initFragment();
		manager = getSupportFragmentManager();
		transaction = manager.beginTransaction();
		transaction.replace(R.id.fragment, fragment1);
		transaction.commit();

		IntentFilter filter = new IntentFilter();
		filter.addAction("BROADCAST_TO_HOME");
		registerReceiver(MyReceiver, filter);

	}

	private void initFragment() {
		// TODO Auto-generated method stub
		fragment1 = new FragmentFrist();
		fragment2 = new FragmentTwo();
		fragment3 = new FragmentThree();
		fragment4 = new FragmentFour();
		fragment5 = new FragmentFrist();
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		updateColorById(view);
		switch (view.getId()) {
		case R.id.fragment1:
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment1);
			transaction.commit();
			break;
		case R.id.fragment2:
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment2);
			transaction.commit();
			break;
		case R.id.fragment3:
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment3);
			transaction.commit();
			break;
		case R.id.fragment4:
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment4);
			transaction.commit();
			break;
		case R.id.fragment5:
//			transaction = manager.beginTransaction();
//			transaction.replace(R.id.fragment, fragment5);
//			transaction.commit();
			Toast.makeText(this, "此功能暂时未开放", 2000).show();
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initLayout() {
		fragment = (FrameLayout) findViewById(R.id.fragment);
		img1 = (LinearLayout) findViewById(R.id.fragment1);
		img2 = (LinearLayout) findViewById(R.id.fragment2);
		img3 = (LinearLayout) findViewById(R.id.fragment3);
		img4 = (LinearLayout) findViewById(R.id.fragment4);
		img5 = (LinearLayout) findViewById(R.id.fragment5);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
		img5.setOnClickListener(this);
		iv1 = (ImageView) findViewById(R.id.iv1);
		iv2 = (ImageView) findViewById(R.id.iv2);
		iv3 = (ImageView) findViewById(R.id.iv3);
		iv4 = (ImageView) findViewById(R.id.iv4);
		iv5 = (ImageView) findViewById(R.id.iv5);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
	}

	private void updateColorById(View view) {
		switch (view.getId()) {
		case R.id.fragment1:
			iv1.setBackgroundResource(R.drawable.home_active);
			tv1.setTextColor(getResources().getColor(R.color.green));
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_deactive);
			tv4.setTextColor(R.color.write);
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
			break;

		case R.id.fragment2:
			iv1.setBackgroundResource(R.drawable.home_deactive);
			tv1.setTextColor(R.color.write);
			iv2.setBackgroundResource(R.drawable.category_active);
			tv2.setTextColor(getResources().getColor(R.color.green));
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_deactive);
			tv4.setTextColor(R.color.write);
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
			break;
		case R.id.fragment3:
			iv1.setBackgroundResource(R.drawable.home_deactive);
			tv1.setTextColor(R.color.green);
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_active);
			tv3.setTextColor(getResources().getColor(R.color.green));
			iv4.setBackgroundResource(R.drawable.cart_deactive);
			tv4.setTextColor(R.color.write);
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
			break;
		case R.id.fragment4:
			iv1.setBackgroundResource(R.drawable.home_deactive);
			tv1.setTextColor(R.color.write);
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_active);
			tv4.setTextColor(getResources().getColor(R.color.green));
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
			break;
		case R.id.fragment5:
			iv1.setBackgroundResource(R.drawable.home_deactive);
			tv1.setTextColor(R.color.write);
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_deactive);
			tv4.setTextColor(R.color.write);
			iv5.setBackgroundResource(R.drawable.guoshi_active);
			tv5.setTextColor(getResources().getColor(R.color.green));
			break;
		default:
			break;
		}
	}

	BroadcastReceiver MyReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment1);
			transaction.commit();
			iv1.setBackgroundResource(R.drawable.home_active);
			tv1.setTextColor(getResources().getColor(R.color.green));
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_deactive);
			tv4.setTextColor(R.color.write);
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
		}
	};

	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		if (arg1 == 1001) {
			transaction = manager.beginTransaction();
			transaction.replace(R.id.fragment, fragment4);
			transaction.commitAllowingStateLoss();
			iv1.setBackgroundResource(R.drawable.home_deactive);
			tv1.setTextColor(R.color.write);
			iv2.setBackgroundResource(R.drawable.category_deactive);
			tv2.setTextColor(R.color.write);
			iv3.setBackgroundResource(R.drawable.smile_deactive);
			tv3.setTextColor(R.color.write);
			iv4.setBackgroundResource(R.drawable.cart_active);
			tv4.setTextColor(getResources().getColor(R.color.green));
			iv5.setBackgroundResource(R.drawable.guoshi_deactive);
			tv5.setTextColor(R.color.write);
		}
		TextView tvCount = (TextView) findViewById(R.id.count);
		int count = 0;
		FruitdayApplition app = (FruitdayApplition) getApplication();
		for (Commodity comm : app.listFruit) {
			count += comm.getCount();
		}
		if (count != 0)
			tvCount.setVisibility(View.VISIBLE);
		tvCount.setText(count + "");
	};
}
