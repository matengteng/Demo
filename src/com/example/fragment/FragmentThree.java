package com.example.fragment;

import com.example.activity.ChongZhiActivity;
import com.example.activity.CouponActivity;
import com.example.activity.IntegralActivity;
import com.example.activity.LayoutActivity;
import com.example.activity.LoginActivity;
import com.example.activity.MyInfoActivity;
import com.example.activity.PingLunActivity;
import com.example.activity.SetingActivity;
import com.example.app.FruitdayApplition;
import com.example.demo.R;
import com.example.tabdemo.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentThree extends FragmentBase {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(com.example.demo.R.layout.tab_02, container,
				false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		getActivity().findViewById(R.id.my_order).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								MainActivity.class));
					}
				});
		getActivity().findViewById(R.id.my_setting).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								SetingActivity.class));
					}
				});
		getActivity().findViewById(R.id.my_comment).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								PingLunActivity.class));
					}
				});
		getActivity().findViewById(R.id.xiaofei_jilu).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								IntegralActivity.class));
					}
				});
		getActivity().findViewById(R.id.shengyu_jifen).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								ChongZhiActivity.class));
					}
				});
		getActivity().findViewById(R.id.qiandao_jifen).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								CouponActivity.class));
					}
				});
		getActivity().findViewById(R.id.my_favorite).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								LayoutActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("id", R.layout.my_attention + "");
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
		getActivity().findViewById(R.id.my_gift).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								LayoutActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("id", R.layout.my_gift + "");
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
		getActivity().findViewById(R.id.my_privilege).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								LayoutActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("id", R.layout.my_privilege + "");
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
		getActivity().findViewById(R.id.my_trial).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								LayoutActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("id", R.layout.my_shichi + "");
						intent.putExtras(bundle);
						startActivity(intent);
					}
				});
		getActivity().findViewById(R.id.headImageView).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (((FruitdayApplition) getActivity().getApplication()).loginZT) {
							Intent intent = new Intent(getActivity(),
									MyInfoActivity.class);
							startActivity(intent);
						}else{
							Intent intent = new Intent(getActivity(),
									LoginActivity.class);
							startActivity(intent);
						}
					}
				});
		TextView tvName = (TextView)getActivity().findViewById(R.id.nickNameTextView);
		if (((FruitdayApplition) getActivity().getApplication()).loginZT){
			tvName.setText("豆丸子。");
		}else{
			tvName.setText("登录|注册");
		}

	}

}
