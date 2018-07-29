package com.example.ningbaoqi.view;

import android.content.Context;
import android.view.View;

/**
 * scrollBy实现了基于当前位置的相对移动，而scrollTo则实现了基于所传递参数的绝对滑动；
 * 在滑动过程中mScrollX的值总是等于View左边缘和View内容左边缘在水平方向上的距离，而mScrollY的值总是等于View上边缘和View内容上边缘在竖直方向上的距离，scrollTo和scrollBy只能改变View内容的位置而不能改变View在布局中的位置
 */
public class ScrollToAndByView extends View {

    public ScrollToAndByView(Context context) {
        super(context);
    }

    /**
     * 源码中的scrollTo
     *
     * @param x
     * @param y
     */
    public void scrollTo(int x, int y) {
        if (mScrollX != x || mScrollY != y) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            if (!awakenScrollBars()) {
                postInvalidateOnAnimation();
            }
        }
    }

    /**
     * 源码中的scrollBy
     */
    public void scrollBy(int x, int y) {
        scrollTo(mScrollX + x, mScrollY + y);
    }
}
