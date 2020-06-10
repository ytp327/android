package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("lutti", "one"), new Word("otiiko", "two"),
                new Word("tolookosu", "three"), new Word("oyyisa", "four"),
                new Word("massokka", "five"), new Word("temmokka", "six"),
                new Word("kenekaku", "seven"), new Word("kawinta", "eight"),
                new Word("wo’e", "nine"), new Word("na’aacha", "ten")));
        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method
    }
}