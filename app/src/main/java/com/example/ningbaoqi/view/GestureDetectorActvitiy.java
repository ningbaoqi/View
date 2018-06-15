package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 触屏一霎那，触发MotionEvent事件
 * 被OnTouchListener监听，在OnTouch()中将获得MotionEvent对象
 * GestureDetector转发MotionEvent对象至OnGestureListener
 * OnGestureListener获得该对象，根据该对象封装的信息做出合适的反馈
 */

public class GestureDetectorActvitiy extends AppCompatActivity {
    private LinearLayout ll;
    private GestureDetector detector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guesture);
        ll = (LinearLayout) findViewById(R.id.ll);
        detector = new GestureDetector(new MyDetectorListener());
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    class MyDetectorListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() - e1.getX() > 50) {
                Toast.makeText(GestureDetectorActvitiy.this, "向右滑动", Toast.LENGTH_LONG).show();
            } else if (e1.getX() - e2.getX() > 50) {
                Toast.makeText(GestureDetectorActvitiy.this, "向左滑动", Toast.LENGTH_LONG).show();
            }
            return true;
        }
    }

}
