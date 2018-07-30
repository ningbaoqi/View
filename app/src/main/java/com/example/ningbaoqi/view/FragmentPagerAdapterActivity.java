package com.example.ningbaoqi.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapterActivity extends FragmentActivity {
    private List<Fragment> lists = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        lists.add(new Fragment1());
        lists.add(new Fragment2());
        lists.add(new Fragment3());
        lists.add(new Fragment4());
        titles.add("first");
        titles.add("second");
        titles.add("third");
        titles.add("fourth");
        ViewPager viewPager = findViewById(R.id.viewPager);
        PagerTabStrip title = findViewById(R.id.tab);
        title.setDrawFullUnderline(false);
        title.setBackgroundColor(Color.YELLOW);
        title.setTextColor(Color.GREEN);
        title.setTabIndicatorColor(Color.BLACK);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), lists, titles);
        viewPager.setAdapter(adapter);
    }
}