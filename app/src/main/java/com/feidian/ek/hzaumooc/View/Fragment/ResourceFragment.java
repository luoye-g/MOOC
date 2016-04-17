package com.feidian.ek.hzaumooc.View.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.feidian.ek.hzaumooc.R;
import com.feidian.ek.hzaumooc.View.Adapter.ListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResourceFragment extends Fragment{

    @Bind(R.id.video_list) RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_video_layout, container, false);
        ButterKnife.bind(this, root);
        return root;
    }
}
