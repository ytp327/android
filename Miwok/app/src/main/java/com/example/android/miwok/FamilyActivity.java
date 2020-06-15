package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father),
                new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother),
                new Word("angsi", "son", R.drawable.family_son, R.raw.family_son),
                new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter),
                new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother),
                new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother),
                new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister),
                new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister),
                new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother),
                new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather)));

        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_family));
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
}