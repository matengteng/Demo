package com.example.fragment;

import com.example.activity.FootActivity;
import com.example.demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class FragmentTwo extends FragmentBase {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(com.example.demo.R.layout.fragment_2,
				container, false);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		getActivity().findViewById(R.id.layout1).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout2).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout3).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout4).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout5).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout6).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout7).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout8).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
		getActivity().findViewById(R.id.layout9).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								FootActivity.class));
					}
				});
	}

}
