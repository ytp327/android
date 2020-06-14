package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter <Word> {

    private int color;
    public WordAdapter( Context context, List<Word> objects, int c) {
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, objects);
        color = c;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null) { //null means no view to reuse
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView miwok = listItemView.findViewById(R.id.miwok_text_view);
        miwok.setText(currentWord.getMiwok());
        TextView defualt = listItemView.findViewById(R.id.defualt_text_view);
        defualt.setText(currentWord.getDefualt());
        ImageView image = listItemView.findViewById(R.id.image_view);
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            image.setImageResource(currentWord.getImage());
            // This line is unnecessary ImageView is visible by default
            // image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);
        }
        parent.setBackgroundColor(color);
        return listItemView;
    }
}
