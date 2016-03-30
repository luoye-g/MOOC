package com.feidian.ek.hzaumooc.View;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.feidian.ek.hzaumooc.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GridAdapter extends BaseAdapter {
    public final int GRID_SIZE = 4;
    private Context context;
    private LayoutInflater layoutInflater;

    public GridAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public class ViewHolder {

        @Bind(R.id.grid_cover)
        ImageView iv;
        @Bind(R.id.grid_title)
        TextView tv;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public int getCount() {
        return GRID_SIZE;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gridview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv.setBackgroundColor(Color.CYAN);
        holder.tv.setText("hello");
        return convertView;
    }
}
