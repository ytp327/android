package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<MusicItem>{
    public MusicAdapter(Activity context, ArrayList<MusicItem> MusicItems) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, MusicItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }
        // Get the MusicItem object located at this position in the list
        MusicItem currentMusic = getItem(position);

        //set music icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.music_icon);
        iconView.setImageResource(currentMusic.getImageResourceId());

        //set music name
        TextView MusicNameView = (TextView) listItemView.findViewById(R.id.music_name);
        MusicNameView.setText(currentMusic.getMusicName());
        //set music name
        TextView ArtistNameView = (TextView) listItemView.findViewById(R.id.artist_name);
        ArtistNameView.setText(currentMusic.getArtistName());
        //set music name
        TextView AlbumNameView = (TextView) listItemView.findViewById(R.id.album_name);
        AlbumNameView.setText(currentMusic.getAlbumName());

        //set play button
        Button playButton = listItemView.findViewById(R.id.play_button);
        final View finalListItemView = listItemView;
        final View finalListItemView1 = listItemView;
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Player.class);
                TextView musicName = (TextView) finalListItemView.findViewById(R.id.music_name);
                intent.putExtra( "musicName",  musicName.getText().toString());
                TextView artistName = (TextView) finalListItemView1.findViewById(R.id.artist_name);
                intent.putExtra( "artistName",  artistName.getText().toString());
                TextView albumName = (TextView) finalListItemView.findViewById(R.id.album_name);
                intent.putExtra( "albumName",  albumName.getText().toString());
                v.getContext().startActivity(intent);
            }
        });

        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
