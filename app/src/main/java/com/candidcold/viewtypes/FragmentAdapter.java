package com.candidcold.viewtypes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by davidmorant on 9/11/15.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabNames = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> names) {
        super(fm);
        this.fragments = fragments;
        tabNames = names;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames.get(position);
    }
}
