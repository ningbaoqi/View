### 自定义View的目的

|自定义View的目的|
|------|
|`为了显示特殊效果`|
|`处理特殊的用户交互`|
|`通过嵌套方式实现的布局，在系统解析测量的效率较低`|

### 自定义View的注意事项

|自定义View的注意事项|
|------|
|让View支持wrap_content:这是因为直接继承View或ViewGroup的控件，如果不在onMeasure中对wrap_content做特殊处理，那么当外界设置了wrap_content时就无法达到预期的效果|
|如果有必要，让View支持padding：这是因为直接继承View的控件，如果不在drwa方法中处理padding，那么padding属性就无法起作用，另外，直接继承ViewGroup的控件需要在OnMeasure和OnLayout中考虑padding和子元素的margin对其造成的影响，不然将导致padding和子元素的margin失效|
|尽量不要在View中使用Handler：因为View内部本身提供了post方法，完全可以替代Handler的作用|
|View中如果有线程或者动画，需要及时停止，参考View-onDetachedFromWindow：当包含此View的Activity退出或当前View被remove时，View的onDetachedFromWindow方法会被调用，和此方法对应的是onAttachedToWindow，当包含此View的Activity启动时，View的onAttachedToWindow方法会被调用，同时，当View变得不可见时我们也需要停止线程和动画，如果不及时处理这种问题，有可能造成内存泄露|
|View带有滑动嵌套情形的，需要处理好滑动冲突|

### 自定义View的步骤
#### 一、自定义属性的声明与获取
##### 在/res/values/attrs.xml声明定义
```
<resources>
    <declare-styleable name="TopBar">
        <attr name="title" format="string"/>
        <attr name="titletextsize" format="dimension"/>
        <attr name="titlecolor" format="color"/>
        <attr name="lefttextcolor" format="color"/>
        <attr name="leftbackground" format="reference|color"/>
        <attr name="lefttext" format="string"/>
        <attr name="righttextcolor" format="color"/>
        <attr name="rightbackground" format="reference|color"/>
        <attr name="righttext" format="string"/>
    </declare-styleable>
</resources>
```
##### 在布局文件中进行使用
```
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:ningbaoqi="http://schemas.android.com/apk/res/ningbaoqi.com.customview"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <ningbaoqi.com.customviewother.HorizontalProgressBarWithProgress
            android:id="@+id/progress"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="30dp"
            android:padding="15dp"
            android:progress="0"
            ningbaoqi:progress_text_color="#44ff0000"
            ningbaoqi:progress_unreach_color="#ff000000"/>

        <ningbaoqi.com.customviewother.RoundProgresBarWithProgress
            android:id="@+id/circlebar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="30dp"
            android:padding="15dp"
            android:progress="30"
            ningbaoqi:progress_text_color="#44ff0000"
            ningbaoqi:progress_unreach_color="#ff000000"
            ningbaoqi:radius="20dp"/>
    </LinearLayout>
</ScrollView>
```
##### 在View的构造方法中进行获取
```
private void obtianStyledAttrs(AttributeSet attrs) {
    TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.HorizontalProgressBarWithProgress);
    mTextSize = (int) typedArray.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_text_size, mTextSize);
    mTextColor = typedArray.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_text_color, mTextColor);
    mTextOffset = (int) typedArray.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_text_offset, mTextOffset);
    mUnReachColor = typedArray.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_unreach_color, mUnReachColor);
    mUnReachHeight = (int) typedArray.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_unreach_height, mUnReachHeight);
    mReachColor = typedArray.getColor(R.styleable.HorizontalProgressBarWithProgress_progress_reach_color, mReachColor);
    mReachHeight = (int) typedArray.getDimension(R.styleable.HorizontalProgressBarWithProgress_progress_reach_height, mReachHeight);
    typedArray.recycle();
}
```
#### 二、测量OnMeasure
+ `测量OnMeasure方法会调用很多次`；

|只要方法|说明|
|------|------|
|`setMeasureDimension()`|`设置该View的宽高`|
|`requestLayout()`|`当执行该方法时，就会重新执行测量，布局，但是不包括绘制，绘制使用invalidate()方法触发`|

#### 三、绘制onDraw
+ `onDraw是绘制内容区域的，背景不考虑`；`canvas.drawXXX方法来绘制想绘制的东西`；`cavans变换的方法translate、rotate、scale、skew`；`canvas的save()、restore()`；如果`属性或某些测量值变化`，要重绘调用`invalidate()、postInvalidate()方法该方法支持在子线程中调用`；
#### 四、与用户交互onTouchEvent
```
@Override
public boolean onTouchEvent(MotionEvent event) {
    initVelocityTrackerIfNotExists();//加速度检测
    mVelocityTracker.addMovement(event);

    final int action = event.getAction();
    switch (action & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            //执行一些初始化，赋值等操作
            break;
        case MotionEvent.ACTION_MOVE:
            break;
        case MotionEvent.ACTION_UP:
            //如果需要进行速度判断
            int initialVelocity = velocityTracker.getYVelocity(mActivePointerId);
            //释放各种资源，重置变量
            break;
        case MotionEvent.ACTION_CANCEL:
            //释放各种资源，重置变量
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            //如果支持多指，在此设置activePointer
            final int index = event.getActionIndex();
            mLastMotionY = event.getY(index);
            mActivePointerId = event.getPointerId(index);
            break;
        case MotionEvent.ACTION_POINTER_UP:
            //如果支持的是多指且抬起的是actionPointer，则重新选择一个手指为活跃手指
            if (pointerId == mActivePointerId) {
                final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                mLastMotionY = event.getY(newPointerIndex);
                mActivePointerId = event.getPointerId(newPointerIndex);
                if (mVelocityTracker != null) {
                    mVelocityTracker.clear();
                }
            }
            break;
    }
    return true;
}
```
```
getParent().requestDisallowInterceptTouchEvent(true)​;;//请求父控件不要拦截事件，整个down到up的事件
```
#### 保存和恢复状态
```
/**
 * 保存进度
 * @return
 */
@Nullable
@Override
protected Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable(INSTALL_STATUS, super.onSaveInstanceState());
    bundle.putFloat(STATUS_ALPH4, mAlpha);
    return bundle;
}

/**
 * 恢复进度
 * @param state
 */
@Override
protected void onRestoreInstanceState(Parcelable state) {
    if (state instanceof Bundle) {
        Bundle bundle = (Bundle) state;
        mAlpha = bundle.getFloat(STATUS_ALPH4);
        super.onRestoreInstanceState(bundle.getParcelable(INSTALL_STATUS));
        return;
    }
    super.onRestoreInstanceState(state);
}
```
