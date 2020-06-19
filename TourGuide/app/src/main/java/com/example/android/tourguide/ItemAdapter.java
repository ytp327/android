package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, List<Item> objects) {
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
                    R.layout.item_list, parent, false);
        }
        Item currentItem = getItem(position);
        // set name TextView
        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentItem.getName());
        // set description TextView
        TextView description = listItemView.findViewById(R.id.description);
        description.setText(currentItem.getDescription());
        // set location TextView
        TextView location = listItemView.findViewById(R.id.location);
        location.setText(currentItem.getLocation());
        // set image of the word
        ImageView image = listItemView.findViewById(R.id.image);
        image.setImageResource(currentItem.getImageId());
        return listItemView;
    }
}
