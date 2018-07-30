package com.example.ningbaoqi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class HorizontalProgressBar extends ProgressBar {
    private int reachHeight;
    private int reachColor;
    private int unreachHeight;
    private int unreachColor;
    private int textSize;
    private int textColor;
    private int textOffset;
    private Paint mPaint;
    private int drawWidth;

    public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        obtainAttr(context, attrs);
    }

    private void obtainAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HorizontalProgressBar);
        reachHeight = (int) typedArray.getDimension(R.styleable.HorizontalProgressBar_progress_reach_height, reachHeight);
        reachColor = typedArray.getColor(R.styleable.HorizontalProgressBar_progress_reach_color, reachColor);
        unreachHeight = (int) typedArray.getDimension(R.styleable.HorizontalProgressBar_progress_unreach_height, unreachHeight);
        unreachColor = typedArray.getColor(R.styleable.HorizontalProgressBar_progress_unreach_color, unreachColor);
        textSize = (int) typedArray.getDimension(R.styleable.HorizontalProgressBar_progress_text_size, textSize);
        textColor = typedArray.getColor(R.styleable.HorizontalProgressBar_progress_text_color, textColor);
        textOffset = (int) typedArray.getDimension(R.styleable.HorizontalProgressBar_progress_text_offset, textOffset);
        typedArray.recycle();
        mPaint.setTextSize(textSize);
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
        drawWidth = width - getPaddingRight() - getPaddingLeft();
    }

    private int measureHeight(int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            return height;
        } else {
            int textHeight = (int) (mPaint.descent() - mPaint.ascent());
            int mHeight = getPaddingTop() + getPaddingBottom() + Math.max(textHeight, Math.max(reachHeight, unreachHeight));
            if (mode == MeasureSpec.AT_MOST) {
                height = Math.min(mHeight, height);
            }
        }
        return height;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getHeight() / 2);
        boolean shouldDrawUnreach = true;
        float scale = getProgress() * 1.0f / getMax();
        String text = getProgress() + "%";
        int textWidth = (int) mPaint.measureText(text);
        int reachEndX = (int) (scale * drawWidth) - textWidth / 2 - textOffset;
        if (reachEndX + textOffset + textWidth > drawWidth) {
            shouldDrawUnreach = false;
            reachEndX = drawWidth - textWidth - textOffset;
        }
        //画reach
        if (reachEndX > 0) {
            mPaint.setStrokeWidth(reachHeight);
            mPaint.setColor(reachColor);
            canvas.drawLine(0, 0, reachEndX, 0, mPaint);
        }
        //画text
        mPaint.setStrokeWidth(textWidth);
        mPaint.setColor(textColor);
        canvas.drawText(text, reachEndX + textOffset, -(mPaint.descent() + mPaint.ascent()) / 2, mPaint);
        //画unreach
        if (shouldDrawUnreach) {
            mPaint.setStrokeWidth(unreachHeight);
            mPaint.setColor(unreachColor);
            canvas.drawLine(reachEndX + textOffset + textWidth + textOffset, 0, drawWidth, 0, mPaint);
        }
        canvas.restore();
    }
}
