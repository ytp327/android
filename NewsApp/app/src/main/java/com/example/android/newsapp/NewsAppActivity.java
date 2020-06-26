package com.example.android.newsapp;
import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewsAppActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener,
        LoaderManager.LoaderCallbacks<List<News>>,
        SharedPreferences.OnSharedPreferenceChangeListener{

    private static final String news_api_url = "https://content.guardianapis.com/search?" +
            "api-key=76476b82-b38c-40c9-99ff-720b6ea2ae73";

    private NewsAdapter newsAdapter;
    private TextView noResult; private String searchQuery;
    private NewsAppActivity curActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_app);
        curActivity = this;

        // When users swipe down, refresh the screen
        final SwipeRefreshLayout swipeRefresh = findViewById(R.id.swiperefresh);
        swipeRefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        LoaderManager loaderManager = getLoaderManager();
                        loaderManager.initLoader(1,null,curActivity);
                        swipeRefresh.setRefreshing(false);
                    }
                }
        );

        // Adapter
        ListView news_list = (ListView) findViewById(R.id.news);
        newsAdapter = new NewsAdapter(this,new ArrayList<News>());
        news_list.setAdapter(newsAdapter);
        news_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News current = newsAdapter.getItem(position);
                Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse(current.getUrl()));
                startActivity(web);
            }
        });


        // Loader
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(1,null,this);

        // check state of network connectivity
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo == null || !networkInfo.isConnected()){
            Toast.makeText(getApplicationContext(),getString(R.string.no_internet),Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);

        // SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings){
            Intent settingIntent = new Intent(this, Settings.class);
            startActivity(settingIntent);
        }
        else{
            finish();
            startActivity(getIntent());
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchQuery = query;
        newsAdapter.clear();
        getLoaderManager().restartLoader(2,null, curActivity);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) { return true; }


    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {

        // get preference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String max_results = sharedPreferences.getString("max_results", "10");

        // createUrl
        Uri.Builder uriBuilder = Uri.parse(news_api_url).buildUpon();
        uriBuilder.appendQueryParameter("page-size", max_results);
        if(searchQuery != null){
            uriBuilder.appendQueryParameter("q", searchQuery);
        }

        return new NewsLoader(this, uriBuilder.toString());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        newsAdapter.clear();
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        newsAdapter.clear();

        if(news != null && !news.isEmpty()){ // results check
            newsAdapter.addAll(news);
        } else {
            noResult = (TextView) findViewById(R.id.no_result);
            noResult.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

        newsAdapter.clear();
    }

}
