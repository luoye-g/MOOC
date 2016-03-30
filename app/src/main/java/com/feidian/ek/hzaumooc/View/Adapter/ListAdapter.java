package com.feidian.ek.hzaumooc.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.feidian.ek.hzaumooc.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by luoba on 2016/3/30.
 */
public class ListAdapter extends BaseAdapter{

    public static final int LIST_SIZE = 3;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    class ViewHolder {

        @Bind(R.id.lv_cover) ImageView cover;
        @Bind(R.id.lv_class_name) TextView name;
        @Bind(R.id.lv_author) TextView author;

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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText("微生物");
        holder.author.setText("赵兵");
        return convertView;
    }
}
