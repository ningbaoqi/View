package com.example.ningbaoqi.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class GestureDetectorActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.);
        gestureDetector = new GestureDetector(this);
        gestureDetector.setIsLongpressEnabled(false);//解决长按屏幕后无法拖动的现象
    }

    /**
     * 手指轻轻的触摸屏幕一瞬间，由一个ACTION_DOWN触发
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 手指轻轻触摸屏幕，尚未松开或拖动，由一个action_down触发，它强调的是没有松开或者拖动的状态
     *
     * @param motionEvent
     */
    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    /**
     * 手指松开，伴随一个action_up触发，这是单击行为
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 手指按下屏幕并拖动，由一个action_down和多个action_move触发，这是拖动行为
     *
     * @param motionEvent
     * @param motionEvent1
     * @param v
     * @param v1
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    /**
     * 用户长时间地按着屏幕不放
     *
     * @param motionEvent
     */
    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    /**
     * 用户按下触摸屏、快速滑动松开，由一个action_down多个action_move和一个action_up触发，快速滑动行为
     *
     * @param motionEvent
     * @param motionEvent1
     * @param v
     * @param v1
     * @return
     */
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    /**
     * 如果触发onSingleTapConfirmed那么后面不可能再紧跟着另一个单击行为，即这只可能是单击，而不可能是双击中的一次单击
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 双击，由两次连续的单击形成，它不可能和onSingleTapConfirmed共存
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    /**
     * 发送了双击事件，再双击期间，action_down、action_move、action_up都会触发此回调
     *
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            boolean consume = gestureDetector.onTouchEvent(event);//将事件传递到GestureDetector处理
            return consume;
        }
    }
}
