package com.example.activity;

import com.example.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class PingLunActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pinglun);
		findViewById(R.id.back_floation).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	
}
