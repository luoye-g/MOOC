package com.feidian.ek.hzaumooc.View.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.feidian.ek.hzaumooc.Activity.MainActivity;
import com.feidian.ek.hzaumooc.Bean.ClassRank;
import com.feidian.ek.hzaumooc.Bean.GoodClass;
import com.feidian.ek.hzaumooc.Bean.MainViewTitle;
import com.feidian.ek.hzaumooc.Bean.YunClass;
/**
 * Created by Administrator on 2016/4/8.
 */
public class ItemOnClickListener implements AdapterView.OnItemClickListener{
    private int type;//type注明是Gird或是List
    private Context activity;
    private int kind;//kind表明具体的类别
    public ItemOnClickListener(int type,Context activity,int kind)//type注明是Gird或是List，kind表明具体的类别
    {
        this.activity=activity;
        this.kind=kind;
        this.type=type;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(type==MainAdapter.GIRD)
        {
            switch(kind)
            {
                case MainViewTitle.RECOMMEND:
                    Toast.makeText(activity,RecommendClass.RecommendClass_CLASSNAME[position],Toast.LENGTH_LONG).show();
                     break;
                case MainViewTitle.GOODCLASS:
                    Toast.makeText(activity,GoodClass.COUNTRYRESOURSE_CLASSNAME[position*5+2],Toast.LENGTH_LONG).show();break;
                case MainViewTitle.YUNCLASS:
                    Toast.makeText(activity, YunClass.name[position], Toast.LENGTH_LONG).show();break;
                default:break;
            }
        }
        else if(type == MainAdapter.LIST)
        {
            switch(kind)
            {
                case MainViewTitle.RANK:
                    Toast.makeText(activity, ClassRank.ClassRank_CLASSNAME[position], Toast.LENGTH_LONG).show();break;
                case MainViewTitle.GOODCLASS_1:
                    Toast.makeText(activity, GoodClass.COUNTRYVIDEO_CLASSNAME[position], Toast.LENGTH_LONG).show();break;
                case MainViewTitle.GOODCLASS_2:
                    Toast.makeText(activity, GoodClass.COUNTRYRESOURSE_CLASSNAME[position], Toast.LENGTH_LONG).show();break;
                case MainViewTitle.GOODCLASS_3:
                    Toast.makeText(activity, GoodClass.PROVINCEGOODCLASS_CLASSNAME[position], Toast.LENGTH_LONG).show();break;
                case MainViewTitle.YUNCLASS:
                    Toast.makeText(activity, YunClass.name[position], Toast.LENGTH_LONG).show();break;
                case MainViewTitle.RECOMMEND:
                    Toast.makeText(activity, GoodClass.COUNTRYRESOURSE_CLASSNAME[position], Toast.LENGTH_LONG).show();break;
                default:break;
            }
        }
    }
    public void setPosition(int kind)
    {
        this.kind=kind;
    }
}
