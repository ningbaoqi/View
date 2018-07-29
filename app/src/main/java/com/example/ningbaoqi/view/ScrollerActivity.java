package com.example.ningbaoqi.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Scroller;

/**
 * Scroller来实现有过度效果的滑动，其过程不是瞬间完成的，而是在一定的时间间隔内完成的，它需要和View的computeScroll方法配合使用才能共同完成这个功能
 */
public class ScrollerActivity extends AppCompatActivity {

    private Scroller scroller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scroller = new Scroller(this);

    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        public void computeScroll() {
            if (scroller.computeScrollOffset()) {
                scrollTo(scroller.getCurrX(), scroller.getCurrY());
                postInvalidate();
            }
        }

        /**
         * 缓慢滚动到指定位置
         *
         * @param destX
         * @param destY
         */
        private void soothScrollTo(int destX, int destY) {
            int scrollX = getScrollX();
            int delta = destX - scrollX;
            scroller.startScroll(scrollX, 0, delta, 0, 1000);//1000ms内滑动destX效果为慢慢滑动
            invalidate();
        }
    }
}
