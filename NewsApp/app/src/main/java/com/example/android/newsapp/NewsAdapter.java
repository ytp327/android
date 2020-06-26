package com.example.android.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News>{
    public NewsAdapter(Activity context,List<News> News){
        super(context,0,News);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View newsView = convertView;

        if(newsView == null){
            newsView = LayoutInflater.from(getContext()).inflate(R.layout.news_list,parent,false);
        }

        News current_news = getItem(position);

        //set Title
        TextView title = (TextView) newsView.findViewById(R.id.title);
        title.setText(current_news.getTitle());

        //set time
        TextView pub_date = (TextView) newsView.findViewById(R.id.time);
        pub_date.setText(current_news.getTime());

        //set section
        TextView section_name = (TextView) newsView.findViewById(R.id.section);
        section_name.setText(current_news.getSection());

        return newsView;
    }
}
