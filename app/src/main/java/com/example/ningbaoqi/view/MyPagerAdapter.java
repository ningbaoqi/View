package com.example.ningbaoqi.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View> lists;
    private List<String> titleList;

    public MyPagerAdapter(List<View> lists, List<String> titleList) {
        this.lists = lists;
        this.titleList = titleList;
    }

    @Override
    public int getCount() {//页面的数量
        return lists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//实例化页卡
        container.addView(lists.get(position));
        return lists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//销毁页卡
        container.removeView(lists.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {//获取标题的内容
        return titleList.get(position);
    }
}