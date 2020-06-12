package com.example.android.musicapp;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
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

        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
