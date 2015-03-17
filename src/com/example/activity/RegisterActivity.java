package com.example.activity;

import com.example.app.FruitdayApplition;
import com.example.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_main);
		findViewById(R.id.my_log_two).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						FruitdayApplition app = (FruitdayApplition) getApplication();
						app.loginZT = true;
						finish();
					}
				});
		findViewById(R.id.back_floating).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}

}
