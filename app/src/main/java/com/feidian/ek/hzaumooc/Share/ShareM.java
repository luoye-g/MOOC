package com.feidian.ek.hzaumooc.share;

/**
 * Created by lenovo on 2016/4/9.
 */
public class ShareM {
    private int image;
    private String name;
    public ShareM(int image,String name){
        this.image = image;
        this.name = name;
    }
    public void setImage(int image){
        this.image = image;
    }
    public int getImage(){
        return image;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
