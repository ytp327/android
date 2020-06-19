package com.example.android.tourguide;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        fragment currentFragment = new fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tabNum", position);
        currentFragment.setArguments(bundle);
        return currentFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String tabName="";
        if (position == 0) tabName = "Daytime Attractions";
        else if (position == 1) tabName = "Night Sights";
        else if (position == 2) tabName = "Foods";
        else if(position == 3) tabName = "Souvenirs";
        return tabName;
    }
}
