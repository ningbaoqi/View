package com.example.ningbaoqi.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/**
 * 内部拦截法  指在父容器不拦截任何事件，所有的事件都传递给子元素，如果子元素需要此时间就直接消耗掉，否则就交给父容器进行处理，需要配合requestDisallowInterceptTouchEvent方法才能正常工作，需要重写子元素的dispatchTouchEvent方法
 */
public class NeiBuLanJieFaView extends View {
    public NeiBuLanJieFaView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);//请求不要拦截
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (父容器需要此类点击事件) {
                    getParent().requestDisallowInterceptTouchEvent(false);//拦截去吧
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }
}
