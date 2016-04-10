package com.feidian.ek.hzaumooc.download;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.feidian.ek.hzaumooc.R;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {
	private ListView listView;
	private List<String> list;
	private DownloadAdapter adapter;
	private View view = null;
	private ProgressBar progressBar = null;
	private TextView download_text = null;
	private TextView size = null;
	private File sdcard = Environment.getExternalStorageDirectory();
	private String path = sdcard.getPath() + "/课程中心";
	private File path1 = new File(path);
	//private DownloadChangeObserver downloadObserver;
	private DownloadManager downloadManager;
	private long downloadId;
	private RelativeLayout relativeLayout = null;
	private Uri uri;
	private int position = 0;
	private int count = 1;
	private String xurl;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return View.inflate(getActivity(), R.layout.down_load, null);
		/*
		View view = View.inflate(getActivity(), R.layout.down_load, null);
		relativeLayout =  (RelativeLayout)view.findViewById(R.id.relative);
		listView = (ListView) view.findViewById(R.id.download);
		list = new ArrayList<String>();
		list.add(name);
		count++;
		adapter = new DownloadAdapter(list, mHandle, getActivity(), R.layout.list_data);
		listView.setAdapter(adapter);
		isFind();
		downloadObserver = new DownloadChangeObserver();
		if (!path1.exists()) {
			path1.mkdirs();
		}
		isFind();
		view = listView.getChildAt(count-1);
		download(xurl,name);
		return view;
	}
	public void download(String url, String name) {
		if(count!=0) {
			progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
			size = (TextView) view.findViewById(R.id.size);
			progressBar.setMax(100);
			String serviceString = Context.DOWNLOAD_SERVICE;
			downloadManager = (DownloadManager) getActivity().getSystemService(serviceString);
			uri = Uri.parse(url);
			File fileName = new File(path1, name);
			DownloadManager.Request request = new DownloadManager.Request(uri);
			//  request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
			request.setDestinationUri(Uri.fromFile(fileName));
			request.setTitle(name);
			request.setDescription("现在我的文件正在下载.....");
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
			downloadId = downloadManager.enqueue(request);
		}
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			//当收到更新视图消息时，计算已完成下载百分比，同时更新进度条信息
			progressBar.setProgress(msg.getData().getInt("size"));
			float temp = (float) progressBar.getProgress() / (float) progressBar.getMax();
			int progress = (int) temp * 100;
			if (progress == 100) {
				Toast.makeText(getActivity(), "下载完成！", Toast.LENGTH_SHORT).show();
			} else {
				download_text.setText("当前进度:" + progress + "%");
			}
		}
	};


	class DownloadChangeObserver extends ContentObserver {
		public DownloadChangeObserver() {
			super(handler);
		}

		@Override
		public void onChange(boolean selfChange) {
			updateView();
		}
	}

	public void updateView() {
		int[] bytesAndStatus = getBytesAndStatus(downloadId);
		progressBar.setMax(bytesAndStatus[1]);
		progressBar.setProgress(bytesAndStatus[0]);
		float hasSize = 0, allSize = 0;
		String has, all;
		if (bytesAndStatus[1] / 1024 >= 1) {
			allSize = (float) bytesAndStatus[1] / 1024;
			all = "k";
			if (allSize / 1024 >= 1) {
				allSize = allSize / 1024;
				all = "m";
				if (allSize / 1024 >= 1) {
					allSize = allSize / 1024;
					all = "g";
				}
			}
		} else {
			allSize = bytesAndStatus[1];
			all = "b";
		}
		if (bytesAndStatus[0] / 1024 >= 1) {
			hasSize = (float) bytesAndStatus[0] / 1024;
			has = "k";
			if (hasSize / 1024 >= 1) {
				hasSize = hasSize / 1024;
				has = "m";
				if (hasSize / 1024 >= 1) {
					hasSize = hasSize / 1024;
					has = "g";
				}
			}
		} else {
			hasSize = bytesAndStatus[0];
			has = "b";
		}
		DecimalFormat fnum = new DecimalFormat("##0.0");
		String hasSizea = fnum.format(hasSize);
		String allSizea = fnum.format(allSize);
		size.setText(hasSizea + has + "/" + allSizea + all);
		if (bytesAndStatus[0] == bytesAndStatus[1]) {
			if (count >= 1) {
				list.remove(position);
				count--;
				adapter.notifyDataSetChanged();
				isFind();
				if (count >= 1) {
					view = listView.getChildAt(position);
					TextView textView = (TextView) view.findViewById(R.id.text_name);
					String name = textView.getText().toString();
					download(xurl, name);
				}
			}
		}
		//handler.sendMessage(handler.obtainMessage(0, bytesAndStatus[0], bytesAndStatus[1],
		//      bytesAndStatus[2]));
	}

	@Override
	 public void onResume() {
		super.onResume();
		getActivity().getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, downloadObserver);
	}

	@Override
	public  void onPause() {
		super.onPause();
		getActivity().getContentResolver().unregisterContentObserver(downloadObserver);
	}

	public int[] getBytesAndStatus(long downloadId) {
		int[] bytesAndStatus = new int[]{-1, -1, 0};
		DownloadManager.Query query = new DownloadManager.Query().setFilterById(downloadId);
		Cursor c = null;
		try {
			c = downloadManager.query(query);
			if (c != null && c.moveToFirst()) {
				bytesAndStatus[0] = c.getInt(c.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
				bytesAndStatus[1] = c.getInt(c.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
				bytesAndStatus[2] = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
			}
		} finally {
			if (c != null) {
				c.close();
			}
		}
		return bytesAndStatus;
	}

	private Handler mHandle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case DownloadAdapter.DELETE:
					int posiTion = msg.arg1;
						if(position==posiTion){
							//downloadManager.remove(downloadId);
							list.remove(posiTion);
							adapter.notifyDataSetChanged();
						}else{
							list.remove(posiTion);
							adapter.notifyDataSetChanged();
						}
					isFind();
					count--;
					break;
				default:
					break;
			}
		}
	};
	public void isFind(){
		if(list.size()==0){
			relativeLayout.setVisibility(View.VISIBLE);
		}else{
			relativeLayout.setVisibility(View.INVISIBLE);
		}
	}
	public String getName(String url){
		url = url.substring(url.lastIndexOf("/")+1);
		return url;
	}
	*/
	}
}

