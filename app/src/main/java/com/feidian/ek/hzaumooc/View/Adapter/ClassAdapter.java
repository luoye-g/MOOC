package com.feidian.ek.hzaumooc.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.feidian.ek.hzaumooc.Bean.GoodClass;
import com.feidian.ek.hzaumooc.R;
import com.feidian.ek.hzaumooc.View.NoScrollGridView;
import com.feidian.ek.hzaumooc.View.NoScrollListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/29.
 */
public class ClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context activity;
    LayoutInflater layoutInflater;

    public ClassAdapter(Context activity) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
    }
    /*public class CardViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.class_gridview_image) ImageView imageView;
        @Bind(R.id.class_gridview_classname) TextView textView;
        @Bind(R.id.class_gridview_teacher)TextView teacher;

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }*/
    class GirdViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_girdview_title) TextView title;
        @Bind(R.id.item_girdview)
        NoScrollGridView gridView;

        public GirdViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new CardViewHolder(layoutInflater.inflate(R.layout.class_activity_gridview_item, parent, false));
        //return new GirdViewHolder(layoutInflater.inflate(R.layout.item_girdview, parent, false));
        return new ListViewHolder(layoutInflater.inflate(R.layout.item_listview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListViewHolder) {
            ((ListViewHolder) holder).title.setText(GoodClass.class_kind[position]);
            ((ListViewHolder) holder).listView.setAdapter(new ListAdapter(activity));
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
