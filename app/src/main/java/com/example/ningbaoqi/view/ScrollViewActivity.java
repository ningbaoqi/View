package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ScrollView scrollView;
    private TextView textView;
    private Button up, down;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);
        textView = (TextView) findViewById(R.id.text);
        textView.setText(getResources().getString(R.string.content));
        scrollView = (ScrollView) findViewById(R.id.scroll);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (scrollView.getScrollY() <= 0) {//getScrollY 获取滚动条滚动的长度 ，getMeasuredHeight 获取滚动条的总长度， getHeight 获取整个屏幕的长度
                            Toast.makeText(ScrollViewActivity.this, "顶部", Toast.LENGTH_LONG).show();
                        }
                        if (scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getHeight() + scrollView.getScrollY()) {
                            Toast.makeText(ScrollViewActivity.this, "底部", Toast.LENGTH_LONG).show();
                            textView.append(getResources().getString(R.string.content));
                        }
                        break;
                }
                return false;
            }
        });
    }

    public void onClick(View v) {//scrollTo 方法以滚动视图起始位置开始计算的，所以连续按不会有效果，只有第一次会有效过。scrollBy 方法相对前一次的位置，所以每次按下的时候都会有效
        switch (v.getId()) {
            case R.id.up:
                scrollView.scrollBy(0, -30);
                break;
            case R.id.down:
                scrollView.scrollBy(0, 30);
                break;
        }
    }
}
