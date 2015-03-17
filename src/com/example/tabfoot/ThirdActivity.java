package com.example.tabfoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.activity.ShareActivity;
import com.example.demo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	ListView listview;
	List<Map<String, String>> list;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foot_list_item);
		initLayout();
		listview.setAdapter(listAdapter);
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		listview = (ListView) findViewById(R.id.foot_list);
		list = new ArrayList<Map<String,String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("name", "意大利阳光金奇异果");
		map1.put("count", "36个原装");
		map1.put("price", "￥298");
		map1.put("img", R.drawable.listitem2 + "");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("name", "新疆富士苹果");
		map2.put("count", "5斤装");
		map2.put("price", "￥59");
		map2.put("img", R.drawable.listitem1 + "");
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("name", "华盛顿甜脆红地里蛇果");
		map3.put("count", "20个装");
		map3.put("price", "￥118");
		map3.put("img", R.drawable.listitem3 + "");
		for (int i = 0; i < 5; i++) {
			list.add(map1);
			list.add(map2);
			list.add(map3);
		}
	}

	BaseAdapter listAdapter = new BaseAdapter() {

		@Override
		public long getItemId(int id) {
			// TODO Auto-generated method stub
			return id;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LinearLayout layout1 = (LinearLayout) convertView.inflate(
					getApplicationContext(), R.layout.foot_list_item_layout,
					null);
			ImageView iv = (ImageView) layout1.findViewById(R.id.foot_img);
			TextView name = (TextView) layout1.findViewById(R.id.foot_name);
			TextView count = (TextView) layout1.findViewById(R.id.foot_count);
			TextView price = (TextView) layout1.findViewById(R.id.foot_price);
			ImageView addtocart = (ImageView) layout1
					.findViewById(R.id.addtocart);
			Map<String, String> map = list.get(position);
			iv.setImageResource(Integer.parseInt(map.get("img")));
			name.setText(map.get("name"));
			count.setText(map.get("count"));
			price.setText(map.get("price"));
			layout1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getApplication(),ShareActivity.class));
				}
			});
			return layout1;
		}

	};
}
