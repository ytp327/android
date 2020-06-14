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
        words.addAll(Arrays.asList(new Word("lutti", "one", R.drawable.number_one),
                new Word("otiiko", "two", R.drawable.number_two),
                new Word("tolookosu", "three", R.drawable.number_three),
                new Word("oyyisa", "four", R.drawable.number_four),
                new Word("massokka", "five", R.drawable.number_five),
                new Word("temmokka", "six", R.drawable.number_six),
                new Word("kenekaku", "seven", R.drawable.number_seven),
                new Word("kawinta", "eight", R.drawable.number_eight),
                new Word("wo’e", "nine", R.drawable.number_nine),
                new Word("na’aacha", "ten", R.drawable.number_ten)));
        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_colors));
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method
    }
}