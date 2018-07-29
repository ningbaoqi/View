### View的滑动

|View实现滑动的方式|
|------|
|通过View本身提供的scrollTo/scrollBy方法实现滑动|
|通过动画给View施加平移效果来实现滑动|
|通过改变View的LayoutParams使得View重新布局从而实现滑动|

#### scrollTo/scrollBy
[scrollTo/scrollBy](https://github.com/ningbaoqi/View/commit/14e4679e5c2ba0930e1ae69e9dbda528c1b8d48b)

#### 使用动画
+ 通过动画我们能够让一个View进行平移，主要是操作View的translationX和translationY属性；

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:fillAfter="true"
    android:zAdjustment="normal"
    >
    <translate
        android:duration="100"
        android:fromXDelta="0"
        android:fromYDelta="0"
        android:interpolator="@android:anim/linear_interpolator"
        android:toXDelta="100"
        android:toYDelta="100"
        />
</set>
```
```
ObjectAnimator.ofFloat(targetView,"translationX" , 0 , 100).setDuration(200).start();
```

#### 改变布局参数

```
MarginLayoutParams params = mButton.getLayoutParams();
params.width += 100；
params.leftMargin += 100;
mButton.requestLayout();
//或者mButton.setLayoutParams(params);
```
