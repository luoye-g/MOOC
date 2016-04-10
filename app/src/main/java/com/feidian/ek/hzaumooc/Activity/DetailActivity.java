package com.feidian.ek.hzaumooc.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.feidian.ek.hzaumooc.R;
import com.feidian.ek.hzaumooc.View.Fragment.VideoListFragment;
import com.ogaclejapan.smarttablayout.SmartTabIndicationInterpolator;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.detail_tab) SmartTabLayout smartTabLayout;
    @Bind(R.id.detail_viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        toolbar.setTitle("魅力汉语");
        setSupportActionBar(toolbar);
        
        initSmartTabLayout();
        
    }

    private void initSmartTabLayout() {
        String Test = "test";
        Bundle bundle = new Bundle();
        bundle.putString("test",Test);
        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        creator.add("教学视频", VideoListFragment.class, bundle).add("教学文件", VideoListFragment.class, bundle);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), creator.create());
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}
