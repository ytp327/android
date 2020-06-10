package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter <Word> {

    public WordAdapter( Context context, List<Word> objects) {
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, objects);
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
        return listItemView;
    }
}
