package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("weṭeṭṭi","red", R.drawable.color_red, R.raw.color_red),
                new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green),
                new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown),
                new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray),
                new Word("kululli", "black", R.drawable.color_black, R.raw.color_black),
                new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white),
                new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
                new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow)));

        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_colors));
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method

        // add onItemClick listener. When the item clicked, play the audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mp = MediaPlayer.create(getApplicationContext(), words.get(position).getAudioId());
                mp.start();
                mp.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
        }
    }

    @Override
    protected void onStop() {
        // Must inherit the super method onStop
        super.onStop();

        // release the MediaPlayer to avoid audio when we change the app
        releaseMediaPlayer();
    }
}