package com.example.android.tourguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment extends Fragment {


    public fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment, container, false);
        int tabNum = getArguments().getInt("tabNum");
        ArrayList<Item> items = new ArrayList<>();
        if (tabNum == 0) {
            items.add(new Item(getString(R.string.shamian_name), getString(R.string.shamian_description),
                    getString(R.string.shamian_location),R.drawable.shamian));
            items.add(new Item("2","2","3",R.drawable.donut));
            items.add(new Item("2","2","3",R.drawable.donut));
            items.add(new Item("2","2","3",R.drawable.donut));
        }

        ItemAdapter itemsAdapter = new ItemAdapter(getContext(), items);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter); //must overwrite getView method


        return view;
    }
}