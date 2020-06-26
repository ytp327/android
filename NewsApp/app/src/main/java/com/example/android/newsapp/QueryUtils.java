package com.example.android.newsapp;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public final class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    public static List<News> fetchNews(String requestUrl){
        URL url = createUrl(requestUrl);
        String json_response  = null;
        try{
            json_response = makeHttpRequest(url);
            Log.i(LOG_TAG,json_response);
        } catch (IOException e){
            e.printStackTrace();
        }

        List<News> news = extractFromJson(json_response);

        return news;
    }

    private static URL createUrl(String StringUrl){
        URL url = null;
        try{
            url = new URL(StringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException{
        String jsonResponse = "";

        if(url==null){
            return jsonResponse;
        }

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try{
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() == 200){
                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG,"Err Status Code"+httpURLConnection.getResponseCode());
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    private static List<News> extractFromJson(String news_json){
        if(TextUtils.isEmpty(news_json)){
            return null;
        }

        List<News> news = new ArrayList<>();

        try {
            JSONObject baseJson = new JSONObject(news_json);
            JSONArray news_array = baseJson.getJSONObject("response").getJSONArray("results");

            for(int i=0;i<news_array.length();i++){
                JSONObject current_News = news_array.getJSONObject(i);
                String section = current_News.getString("sectionName");
                String title = current_News.getString("webTitle");
                String time = current_News.getString("webPublicationDate");
                String url = current_News.getString("webUrl");
                String author = "";
                if (current_News.has("tags")){
                    // Extract the JSONArray associated with the key called "tags"
                    JSONArray tagsArray = current_News.getJSONArray("tags");
                    if (tagsArray.length() != 0) {
                        // Extract the first JSONObject in the tagsArray
                        JSONObject firstTagsItem = tagsArray.getJSONObject(0);
                        // Extract the value for the key called "webTitle"
                        author = firstTagsItem.getString("webTitle");
                    }
                }

                News newsItem = new News(section, title, time, url, author);

                news.add(newsItem);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return news;
    }

}
