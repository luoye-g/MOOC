package com.feidian.ek.hzaumooc.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.feidian.ek.hzaumooc.R;
import com.feidian.ek.hzaumooc.View.TimeLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {

    String [] s={"美丽汉语","精品数学","美丽增老师"};
    String[] data={"2016-01-21","2016-04-08","2016-04-19"};
    @Bind(R.id.timeline_layout)
    TimeLinearLayout timeLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        for (int i=0;i<=10;i++)
        {
            addItem(i%3);
        }
    }
    private void addItem(int position) {
        View v = LayoutInflater.from(this).inflate(R.layout.item_test, timeLinearLayout, false);
        ((TextView) v.findViewById(R.id.tx_action)).setText(s[position]);
        ((TextView) v.findViewById(R.id.tx_action_time)).setText(data[position]);
        //((TextView) v.findViewById(R.id.tx_action_status)).setText("finish");
        timeLinearLayout.addView(v);
    }

    private void subItem() {
        if (timeLinearLayout.getChildCount() > 0) {
            timeLinearLayout.removeViews(timeLinearLayout.getChildCount() - 1, 1);
        }
    }
}
