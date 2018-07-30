package com.example.ningbaoqi.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> lists;
    private List<String> titles;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> lists, List<String> titles) {
        super(fm);
        this.titles = titles;
        this.lists = lists;
    }
    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }
    @Override
    public int getCount() {
        return lists.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}