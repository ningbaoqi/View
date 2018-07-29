package com.example.ningbaoqi.view;


import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);//追踪当前的事件

        velocityTracker.computeCurrentVelocity(1000);// 必须要调用该方法才能计算速度，并且设置时间单位为ms
        int xVelocity = (int) velocityTracker.getXVelocity();//获取X的速度
        int yVelocity = (int) velocityTracker.getYVelocity();//获取Y的速度

        //在不需要使用它的时候，需要调用clear方法来重置并回收内存
        velocityTracker.clear();
        velocityTracker.recycle();
        return super.onTouchEvent(event);
    }
}
