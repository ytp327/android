package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("әpә", "father"), new Word("әṭa", "mother"),
                new Word("angsi", "son"), new Word("tune", "daughter"),
                new Word("taachi", "older brother"), new Word("chalitti", "younger brother"),
                new Word("teṭe", "older sister"), new Word("kolliti", "younger sister"),
                new Word("ama", "grandmother"), new Word("paapa", "grandfather")));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method
    }
}