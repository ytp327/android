package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("weṭeṭṭi","red", R.drawable.color_red),
                new Word("chokokki", "green", R.drawable.color_green),
                new Word("ṭakaakki", "brown", R.drawable.color_brown),
                new Word("ṭopoppi", "gray", R.drawable.color_gray),
                new Word("kululli", "black", R.drawable.color_black),
                new Word("kelelli", "white", R.drawable.color_white),
                new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow),
                new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow)));
        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_colors));
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method
    }
}