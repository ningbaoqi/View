package com.example.ningbaoqi.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MarqueeText extends TextView {
    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MarqueeText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
