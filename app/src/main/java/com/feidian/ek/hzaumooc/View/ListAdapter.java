package com.feidian.ek.hzaumooc.View;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import butterknife.ButterKnife;

/**
 * Created by luoba on 2016/3/30.
 */
public class ListAdapter extends BaseAdapter{

    public static final int LIST_SIZE = 5;

    class ViewHolder {
        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public int getCount() {
        return LIST_SIZE;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
