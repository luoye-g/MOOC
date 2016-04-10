package com.feidian.ek.hzaumooc.share;

/**
 * Created by lenovo on 2016/4/9.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.feidian.ek.hzaumooc.R;

import java.util.List;
public class ShareAdapter extends BaseAdapter {
    private List<ShareM> list;
    private Context context;
    private int layout;
    public ShareAdapter(Context context,List<ShareM> list,int layout){
        this.context = context;
        this.list = list;
        this.layout = layout;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShareM share = (ShareM)list.get(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view = LayoutInflater.from(context).inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)view.findViewById(R.id.text);
            viewHolder.image = (ImageView)view.findViewById(R.id.image);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.image.setImageResource(share.getImage());
        viewHolder.name.setText(share.getName());
        return view;
    }
    class ViewHolder{
        ImageView image;
        TextView name;
    }
}

