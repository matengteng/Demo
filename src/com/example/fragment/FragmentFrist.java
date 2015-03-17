package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import com.anjoyo.net.AsyncHttpClient;
import com.anjoyo.net.AsyncHttpResponseHandler;
import com.anjoyo.net.RequestParams;
import com.example.activity.BingdingAccount;
import com.example.activity.ChongZhiActivity;
import com.example.activity.HuoZuoActivity;
import com.example.activity.QiangXianActivity;
import com.example.activity.SearchActivity;
import com.example.activity.ShareActivity;
import com.example.activity.ShiChiActivity;
import com.example.activity.TiHuoActivity;
import com.example.activity.YaoYiYaoActivity;
import com.example.demo.R;
import com.example.tabdemo.MainActivity;
import com.google.zxing.ui.CaptureActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class FragmentFrist extends FragmentBase {
	private ViewPager mViewPager;
	private ViewPagerAdapter adapter;
	private ArrayList<ImageView> images;
	private int imageIds[];
	private ScheduledExecutorService scheduledExecutorService;
	private int currentItem;
	private Animation animation1;
	private ListView listview;
	private List<Integer> idList;
	ImageView yaoyiyao, qiangxian, chongzhi, phonezuan, myorder, tihuo,
			bingding, shichi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(com.example.demo.R.layout.fragment_1,
				container, false);
	}

	private void setupAnimation() {
		animation1 = AnimationUtils.loadAnimation(getActivity(),
				R.anim.animation_scale);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		imageIds = new int[] { R.drawable.page1, R.drawable.page2,
				R.drawable.page1, R.drawable.page2, R.drawable.page1 };
		// ��ʾ��ͼƬ
		images = new ArrayList<ImageView>();
		for (int i = 0; i < imageIds.length; i++) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setBackgroundResource(imageIds[i]);
			images.add(imageView);
		}
		setupAnimation();

		listview = (ListView) getActivity().findViewById(R.id.listview);
		initIdList();
		listview.setAdapter(listAdapter);
		//

		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),
				2000, 2, TimeUnit.SECONDS);

		getActivity().findViewById(R.id.address).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								com.tencent.example.location.MainActivity.class);
						startActivity(intent);
					}
				});

		getActivity().findViewById(R.id.more).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// startActivity(new
						// Intent(activity,ListViewActivity.class));
						getPopupWindow();
						// ������λ����ʾ��ʽ,�ڰ�ť�����½�
						popupWindow.showAsDropDown(v, 510, 20);
					}
				});

		getActivity().findViewById(R.id.search).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getActivity(),
								SearchActivity.class));
					}
				});
	}

	private void initIdList() {
		// TODO Auto-generated method stub
		idList = new ArrayList<Integer>();
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
		idList.add(R.drawable.page1);
		idList.add(R.drawable.page2);
	}

	// �л�ͼƬ
	private class ViewPagerTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			currentItem = (currentItem + 1) % imageIds.length;
			// ���½���
			// handler.sendEmptyMessage(0);
			handler.obtainMessage().sendToTarget();
		}

	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			// ���õ�ǰҳ��
			mViewPager.setCurrentItem(currentItem);
		}
	};

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.size();
		}

		// �Ƿ���ͬһ��ͼƬ
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			// TODO Auto-generated method stub
			view.removeView(images.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			// TODO Auto-generated method stub
			view.addView(images.get(position));
			return images.get(position);
		}
	}

	private PopupWindow popupWindow;
	View popupWindow_view;

	/***
	 * ��ȡPopupWindowʵ��
	 */
	private void getPopupWindow() {

		if (null != popupWindow) {
			popupWindow.dismiss();
			return;
		} else {
			initPopuptWindow();
		}
	}

	/**
	 * ����PopupWindow
	 */
	protected void initPopuptWindow() {
		// TODO Auto-generated method stub

		// ��ȡ�Զ��岼���ļ�pop.xml����ͼ
		popupWindow_view = getActivity().getLayoutInflater().inflate(
				R.layout.popupwindow_menu, null, false);
		// ����PopupWindowʵ��,200,150�ֱ��ǿ�Ⱥ͸߶�
		popupWindow = new PopupWindow(popupWindow_view,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		// ���ö���Ч��
		// popupWindow.setAnimationStyle(R.style.AnimationFade);
		// �������ط���ʧ
		popupWindow_view.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (popupWindow != null && popupWindow.isShowing()) {
					popupWindow.dismiss();
					popupWindow = null;
				}
				return false;
			}
		});
		LinearLayout text1 = (LinearLayout) popupWindow_view
				.findViewById(R.id.textView1);
		text1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), CaptureActivity.class);
				startActivityForResult(intent, 1);
				popupWindow.dismiss();
				popupWindow = null;
			}
		});
		LinearLayout text2 = (LinearLayout) popupWindow_view
				.findViewById(R.id.textView2);
		text2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), HuoZuoActivity.class);
				startActivity(intent);
				popupWindow.dismiss();
				popupWindow = null;
			}
		});
		LinearLayout text3 = (LinearLayout) popupWindow_view
				.findViewById(R.id.textView3);
		text3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_CALL, Uri
						.parse("tel:4007200770"));
				startActivity(intent);
				popupWindow.dismiss();
				popupWindow = null;
			}
		});
		LinearLayout text4 = (LinearLayout) popupWindow_view
				.findViewById(R.id.textView4);
		text4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
				popupWindow = null;
				promptExit();
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case 1:
			if (resultCode == 1) {
				String result = data.getStringExtra("scan_result");
				Toast.makeText(getActivity(), "扫描成功：" + result, 2000).show();
			} else if (resultCode == 2) {
				Toast.makeText(getActivity(), "扫描失败", 2000).show();
			}
			break;
		default:
			break;
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
			return idList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (position == 0) {
				LinearLayout layout = (LinearLayout) convertView.inflate(
						getActivity(), R.layout.listview_top, null);
				mViewPager = (ViewPager) layout.findViewById(R.id.vp);
				yaoyiyao = (ImageView) layout.findViewById(R.id.yaoyiyao);
				qiangxian = (ImageView) layout.findViewById(R.id.qiangxian);
				chongzhi = (ImageView) layout.findViewById(R.id.chongzhi);
				phonezuan = (ImageView) layout.findViewById(R.id.phonezuan);
				myorder = (ImageView) layout.findViewById(R.id.myorder);
				tihuo = (ImageView) layout.findViewById(R.id.tihuo);
				bingding = (ImageView) layout.findViewById(R.id.bingding);
				shichi = (ImageView) layout.findViewById(R.id.shichi);
				adapter = new ViewPagerAdapter();
				mViewPager.setAdapter(adapter);
				initLayoutListener();
				return layout;
			}
			LinearLayout layout1 = (LinearLayout) convertView.inflate(
					getActivity(), R.layout.listview_item, null);
			ImageView iv = (ImageView) layout1.findViewById(R.id.image1);
			iv.setImageResource(idList.get(position));
			iv.setAnimation(animation1);
			animation1.start();
			iv.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getActivity(), ShareActivity.class));
				}
			});
			return layout1;
		}

	};

	private void initLayoutListener() {
		yaoyiyao.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), YaoYiYaoActivity.class));
			}
		});
		qiangxian.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), QiangXianActivity.class));
			}
		});
		chongzhi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), ChongZhiActivity.class));
			}
		});
		phonezuan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivityForResult((new Intent(getActivity(), ShareActivity.class)),1002);
			}
		});
		myorder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), MainActivity.class));
			}
		});
		tihuo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), TiHuoActivity.class));
			}
		});
		bingding.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), BingdingAccount.class));
			}
		});
		shichi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), ShiChiActivity.class));
			}
		});
	}

	// 退出程序
	public void promptExit() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(getActivity()).setTitle("提示")
				.setMessage("确定要退出吗？")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						getActivity().finish();
						System.exit(0);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				}).show();
	}
}
