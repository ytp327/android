package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words = new ArrayList<>();
        words.addAll(Arrays.asList(new Word("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going),
                new Word("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name),
                new Word("oyaaset...", "My name is...", R.raw.phrase_my_name_is),
                new Word("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling),
                new Word("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good),
                new Word("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming),
                new Word("hәә’ әәnәm", "Yes, I’m coming.", R.raw.phrase_yes_im_coming),
                new Word("әәnәm", "I’m coming.", R.raw.phrase_im_coming),
                new Word("yoowutis", "Let’s go.", R.raw.phrase_lets_go),
                new Word("әnni'nem", "Come here.", R.raw.phrase_come_here)));

        WordAdapter itemsAdapter = new WordAdapter(this, words, getResources().getColor(R.color.category_phrases));
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