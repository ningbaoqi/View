package com.example.ningbaoqi.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class NeiBuLanJieFaViewGroup extends ViewGroup {

    public NeiBuLanJieFaViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            return false;
        } else {
            return true;
        }
    }
}
