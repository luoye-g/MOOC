package com.feidian.ek.hzaumooc.Share;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.feidian.ek.hzaumooc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/9.
 */
public class ShareActivty extends Activity {
    private ListView listView = null;
    private List<ShareM> list = null;
    private ShareAdapter adapter = null;
    private int[] image = {R.mipmap.qq4,R.mipmap.weibo,R.mipmap.weixing,R.mipmap.weibo2,R.mipmap.weibo4};
    private String[] text = {"QQ","微博","微信","短信","E-mail邮箱"};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_share);
        /*listView = (ListView)super.findViewById(R.id.share_list);
        list = new ArrayList<>();
        for(int i = 0;i<image.length;i++){
            ShareM share = new ShareM(image[i],text[i]);
            list.add(share);
        }
        adapter = new ShareAdapter(this,list,R.layout.share_item);
        listView.setAdapter(adapter);*/
    }
}
