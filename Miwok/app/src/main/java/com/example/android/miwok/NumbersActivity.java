package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one),
                new Word("otiiko", "two", R.drawable.number_two, R.raw.number_two),
                new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three),
                new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four),
                new Word("massokka", "five", R.drawable.number_five, R.raw.number_five),
                new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six),
                new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven),
                new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight),
                new Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine),
                new Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten)));

        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_numbers));
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method

        // add onItemClick listener. When the item clicked, play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), words.get(position).getAudioId());
                mp.start();
            }
        });
    }

}