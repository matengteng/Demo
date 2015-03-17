package com.example.fragment;

import java.util.List;

import com.alipay.sdk.pay.demo.PayDemoActivity;
import com.example.app.FruitdayApplition;
import com.example.bean.Commodity;
import com.example.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FragmentFour extends FragmentBase {

	private Activity activity;
	private ListView listview;
	private List<Commodity> listComm;
	private TextView total;
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(com.example.demo.R.layout.fragment_4,
				container, false);
	}

	RelativeLayout cart_empty;
	RelativeLayout cart_list;

	private void Visibility() {
		cart_list = (RelativeLayout) activity
				.findViewById(R.id.llshop_cart_list);
		cart_list.setVisibility(View.GONE);
		cart_empty = (RelativeLayout) activity
				.findViewById(R.id.llshop_cart_empty);
		cart_empty.setVisibility(View.VISIBLE);

		if (listComm.size() != 0) {
			cart_list.setVisibility(View.VISIBLE);
			cart_empty.setVisibility(View.GONE);
		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		activity = getActivity();
		listview = (ListView) activity.findViewById(R.id.shop_cart_list);
		listComm = ((FruitdayApplition) activity.getApplication()).listFruit;
		tv = (TextView) activity.findViewById(R.id.count);
		total = (TextView) activity.findViewById(R.id.total);
		if (listview.getAdapter() == null)
			listview.setAdapter(adapter);
		Visibility();
		toHomeListener();
		int count = 0;
		for (Commodity comm : ((FruitdayApplition) activity.getApplication()).listFruit) {
			count += comm.getCount();
		}
		total.setText(count * 99 + "");
	}

	private void toHomeListener() {
		activity.findViewById(R.id.to_home).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.setAction("BROADCAST_TO_HOME");
						activity.sendBroadcast(intent);
					}
				});
		activity.findViewById(R.id.to_home_two).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.setAction("BROADCAST_TO_HOME");
						activity.sendBroadcast(intent);
					}
				});
		activity.findViewById(R.id.jiesuan).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(activity,PayDemoActivity.class);
						startActivity(intent);
					}
				});
	}

	BaseAdapter adapter = new BaseAdapter() {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		int count = 0;
		TextView tv_num;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LinearLayout layout1 = (LinearLayout) convertView.inflate(
					getActivity(), R.layout.shoping_cart_list_item, null);
			tv_num = (TextView) layout1.findViewById(R.id.tv_num);
			count = 0;
			for (Commodity comm : ((FruitdayApplition) activity
					.getApplication()).listFruit) {
				count += comm.getCount();
			}
			tv_num.setText(count + "");
			ImageView add = (ImageView) layout1.findViewById(R.id.iv_jia);
			ImageView less = (ImageView) layout1.findViewById(R.id.iv_jian);
			add.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					count += 1;
					total.setText(count * 99 + "");
					tv_num.setText(count + "");
					tv.setText(count + "");
				}
			});
			less.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (count > 1) {
						count -= 1;
						total.setText(count * 99 + "");
						tv_num.setText(count + "");
						tv.setText(count + "");
					} else if (count == 1) {
						new AlertDialog.Builder(getActivity())
								.setTitle("提示信息")
								.setMessage("确定要删除此商品？")
								.setPositiveButton("确定",
										new DialogInterface.OnClickListener() {
											@Override
											public void onClick(
													DialogInterface arg0,
													int arg1) {
												// TODO Auto-generated method
												// stub
												cart_list = (RelativeLayout) activity
														.findViewById(R.id.llshop_cart_list);
												cart_list
														.setVisibility(View.GONE);
												cart_empty = (RelativeLayout) activity
														.findViewById(R.id.llshop_cart_empty);
												cart_empty
														.setVisibility(View.VISIBLE);
												((FruitdayApplition) activity
														.getApplication()).listFruit
														.clear();
												total.setText("0");
												tv.setVisibility(View.GONE);
											}
										})
								.setNegativeButton("取消",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												// TODO Auto-generated method
												// stub
												dialog.dismiss();
											}
										}).show();
					}
				}
			});
			return layout1;
		}

	};
}
