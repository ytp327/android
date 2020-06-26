package com.example.android.newsapp;

public class News {
    private String section,title,time,author,url;

    public News(String s,String tt,String tm,String u, String a){
        section = s; title = tt;
        time = tm; url = u;
        author = a;
    }

    public String getSection(){
        return section;
    }

    public String getTitle(){ return title; }

    public String getTime(){
        return time;
    }

    public String getAuthor() {return author;}

    public String getUrl(){
        return url;
    }
}
