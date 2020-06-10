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
        words.addAll(Arrays.asList(new Word("weṭeṭṭi","red"), new Word("chokokki", "green"),
                new Word("ṭakaakki", "brown"), new Word("ṭopoppi", "gray"),
                new Word("kululli", "black"), new Word("kelelli", "white"),
                new Word("ṭopiisә", "dusty yellow"), new Word("chiwiiṭә", "mustard yellow")));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method
    }
}