package com.feidian.ek.hzaumooc.download;

/**
 * Created by lenovo on 2016/4/4.
 */
public class FileM {
    private String name;
    private String date;
    private String size;
    private String path;
    public FileM(String name, String date, String size,String path){
        this.name = name;
        this.date = date;
        this.size = size;
        this.path = path;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    public void setSize(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    public String getPath() {return path;}
    public void setPath(String path) {this.path = path;}
}
