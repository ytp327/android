package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;


public class NewsLoader extends AsyncTaskLoader<List<News>>{
    private String url;

    public NewsLoader(Context context,String u){
        super(context);
        url = u;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if(url==null){
            return null;
        }

        List<News> news = QueryUtils.fetchNews(url);
        return news;
    }
}
