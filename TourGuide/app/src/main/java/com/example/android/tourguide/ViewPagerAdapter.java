package com.example.android.tourguide;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public ViewPagerAdapter(@NonNull FragmentManager fm, Context c) {
        super(fm);
        context = c;
    }

    @Override
    public Fragment getItem(int position) {
        fragment currentFragment = new fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(context.getString(R.string.tabNum), position);
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
        if (position == 0) tabName = context.getString(R.string.tab0);
        else if (position == 1) tabName = context.getString(R.string.tab1);
        else if (position == 2) tabName = context.getString(R.string.tab2);
        else if(position == 3) tabName = context.getString(R.string.tab3);
        return tabName;
    }
}
