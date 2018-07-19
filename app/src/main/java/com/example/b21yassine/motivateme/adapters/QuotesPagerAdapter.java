package com.example.b21yassine.motivateme.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class QuotesPagerAdapter extends FragmentPagerAdapter {

    public List<Fragment> fragments_list;

    public QuotesPagerAdapter(FragmentManager fm, List<Fragment> fragments_list) {
        super(fm);
        this.fragments_list = fragments_list;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments_list.get(i);
    }

    @Override
    public int getCount() {
        return fragments_list.size();
    }


}
