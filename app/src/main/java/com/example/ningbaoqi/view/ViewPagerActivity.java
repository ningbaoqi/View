package com.example.ningbaoqi.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private List<View> lists = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab);
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        pagerTabStrip.setTextColor(Color.RED);
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.BLUE);
        View view1 = View.inflate(this, R.layout.view1, null);
        lists.add(view1);
        View view2 = View.inflate(this, R.layout.view2, null);
        lists.add(view2);
        View view3 = View.inflate(this, R.layout.view3, null);
        lists.add(view3);
        View view4 = View.inflate(this, R.layout.view4, null);
        lists.add(view4);
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
        MyPagerAdapter adapter = new MyPagerAdapter(lists, titleList);
        viewPager.setAdapter(adapter);
    }
}
