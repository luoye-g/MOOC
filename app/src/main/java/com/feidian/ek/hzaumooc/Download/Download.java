package com.feidian.ek.hzaumooc.download;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.net.URL;

/**
 * Created by lenovo on 2016/4/10.
 */
public class Download {
    private static final File sdcard = Environment.getExternalStorageDirectory();
    private static final String path = sdcard.getPath() + "/课程中心";
    private long downloadId;
    public void startDownload(Activity activity, String url) {
     String serviceString = Context.DOWNLOAD_SERVICE;
     DownloadManager downloadManager = (DownloadManager) activity.getSystemService(serviceString);
        String name = getName(url);
     Uri uri=Uri.parse(url);
    File fileName = new File(path, name);
    DownloadManager.Request request = new DownloadManager.Request(uri);
    //  request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
    request.setDestinationUri(Uri.fromFile(fileName));
    request.setTitle(name);
    request.setDescription("现在我的文件正在下载.....");
    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
    downloadId=downloadManager.enqueue(request);
 }
    public String getName(String url){
        url = url.substring(url.lastIndexOf("/")+1);
        return url;
    }
}
