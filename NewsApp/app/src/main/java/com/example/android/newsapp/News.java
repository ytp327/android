package com.example.android.newsapp;

public class News {
    private String section,title,time,url;

    public News(String s,String tt,String tm,String u){
        section = s; title = tt;
        time = tm; url = u;
    }

    public String getSection(){
        return section;
    }

    public String getTitle(){ return title; }

    public String getTime(){
        return time;
    }

    public String getUrl(){
        return url;
    }
}
