package com.example.ningbaoqi.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * 滑动冲突外部拦截法：点击事件都先经过父容器的拦截处理，如果父容器需要此事件就拦截，如果不需要此事件就不拦截，这样就可以解决滑动冲突的问题；需要重写onInterceptTouchEvent方法
 */
public class HuaDongChongtuWaibuLanjieFaView extends ViewGroup {
    public HuaDongChongtuWaibuLanjieFaView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://必须返回false，即不拦截ACTION_DOWN事件，因为一旦拦截了ACTION_DOWN事件，那么后续的ACTION_MOVE、ACTION_UP事件都会直接交给父容器处理
                intercepted = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (父容器需要当前的点击事件) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        mLastXIntercept = x;
        mLastYIntercept = y;
        return intercepted;
    }
}
