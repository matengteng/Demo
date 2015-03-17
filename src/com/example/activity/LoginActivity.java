package com.example.activity;

import com.example.app.FruitdayApplition;
import com.example.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		findViewById(R.id.my_log).setOnClickListener(
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
		findViewById(R.id.my_regist).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(LoginActivity.this,
								RegisterActivity.class));
						finish();
					}
				});
	}

}
