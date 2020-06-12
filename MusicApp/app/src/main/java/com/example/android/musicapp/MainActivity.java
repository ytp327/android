package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MusicItem> MusicItems = new ArrayList<>();
        MusicItems.add(new MusicItem("Donut", "A", "1.6", R.drawable.donut));
        MusicItems.add(new MusicItem("Eclair", "B", "2.0-2.1", R.drawable.eclair));
        MusicItems.add(new MusicItem("Froyo", "A", "2.2-2.2.3", R.drawable.froyo));
        MusicItems.add(new MusicItem("GingerBread", "C", "2.3-2.3.7", R.drawable.gingerbread));
        MusicItems.add(new MusicItem("Honeycomb", "D", "3.0-3.2.6", R.drawable.honeycomb));
        MusicItems.add(new MusicItem("IceCreamSandwich", "A", "4.0-4.0.4", R.drawable.icecreamsandwich));
        MusicItems.add(new MusicItem("JellyBean", "B", "4.1-4.3.1", R.drawable.jellybean));
        MusicItems.add(new MusicItem("KitKat", "B", "4.4-4.4.4", R.drawable.kitkat));
        MusicItems.add(new MusicItem("Lollipop", "S", "5.0-5.1.1", R.drawable.lollipop));
        MusicItems.add(new MusicItem("Marshmallow", "S", "6.0-6.0.1", R.drawable.marshmallow));

        // Create an {@link MusicAdapter}, whose data source is a list of {@link MusicItem}s.
        // The adapter knows how to create list item views for each item in the list.
        MusicAdapter adapter = new MusicAdapter(this, MusicItems);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_music);
        listView.setAdapter(adapter);
    }

}