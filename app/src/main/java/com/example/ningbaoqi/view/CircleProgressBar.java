package com.example.ningbaoqi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CircleProgressBar extends ProgressBar {

    private int reachHeight;
    private int reachColor;
    private int unReachHeight;
    private int unReachColor;
    private int textSize;
    private int textColor;
    private int radiu;
    private Paint mPaint;

    public CircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        obtainStyle(context, attrs);
    }

    private void obtainStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundProgressBar);
        reachHeight = (int) typedArray.getDimension(R.styleable.RoundProgressBar_progress_reach_height, reachHeight);
        reachColor = typedArray.getColor(R.styleable.RoundProgressBar_progress_reach_color, reachColor);
        unReachHeight = (int) typedArray.getDimension(R.styleable.RoundProgressBar_progress_unreach_height, unReachHeight);
        unReachColor = typedArray.getColor(R.styleable.RoundProgressBar_progress_unreach_color, unReachColor);
        textSize = (int) typedArray.getDimension(R.styleable.RoundProgressBar_progress_text_size, textSize);
        textColor = typedArray.getColor(R.styleable.RoundProgressBar_progress_text_color, textColor);
        radiu = (int) typedArray.getDimension(R.styleable.RoundProgressBar_progress_radio, radiu);
        typedArray.recycle();
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mMaxPaintWidth = Math.max(reachHeight, unReachHeight);
        int expect = radiu * 2 + mMaxPaintWidth + getPaddingRight() + getPaddingLeft();
        int width = resolveSize(expect, widthMeasureSpec);
        int height = resolveSize(expect, heightMeasureSpec);
        int real = Math.min(width, height);
        setMeasuredDimension(real, real);
        radiu = (real - getPaddingLeft() - getPaddingRight() - mMaxPaintWidth) / 2;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        int offset = Math.max(unReachHeight, reachHeight);
        canvas.translate(offset / 2 + getPaddingLeft(), offset / 2 + getPaddingTop());
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(unReachHeight);
        mPaint.setColor(unReachColor);
        canvas.drawCircle(radiu, radiu, radiu, mPaint);
        mPaint.setColor(reachColor);
        mPaint.setStrokeWidth(reachHeight);
        float angle = getProgress() * 1.0f / getMax() * 360;
        canvas.drawArc(new RectF(0, 0, radiu * 2, radiu * 2), 0, angle, false, mPaint);
        mPaint.setColor(textColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(textSize);
        String text = getProgress() + "%";
        int textsize = (int) mPaint.measureText(text);
        canvas.drawText(text, radiu - textsize / 2, radiu - (mPaint.descent() + mPaint.ascent()) / 2, mPaint);
        canvas.restore();
    }
}
