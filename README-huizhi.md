### View的绘制机制
#### View树的绘制流程
+ 当`Activity接收到用户触摸焦点`的时候，它就会被请求绘制布局；请求是由Android的`Framework`层处理绘制的，它从`根节点`开始对布局进行`测量`和`绘制`；`View树的绘制流程就是一个递归过程`，在`onMeasure()`方法中`View会对它所有的子元素进行测量，测量过程从父ViewGroup传递到它的子View中`，`经过子元素的递归，测量好了所有的子元素，就完成了ViewGroup的测量`，`onLayout()也是一种递归过程`；
#### 一、onMeasure
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-21.jpg)


|重要参数|说明|
|-------|-------|
|`ViewGroup.LayoutParams`|属性值|
|`MeasureSpec`|测量规格，32位的整数值，前两位是测量模式，后30位是测量规格的大小;测量模式：EXACTLY：表示明确的值，如100dp，match_parent，在测量的时候直接使用就可以了；UNSPECIFIED：表示没有限制，表示这个View要多大都可以，该属性主要使用在ScrollView、ListView；AT_MOST：表示至多不能超多某个值，如wrap_content，由该控件的内容决定的大小，并且不能超过父控件|

+ `实现测量逻辑的方法`；
#### 二、onLayout
+ `根据测量得到的尺寸，来摆放View`;
#### 三、onDraw
+ `在经过测量和摆放之后就可以进行绘制`；
##### invalidate()
+ `请求Android系统，如果视图大小没有发生变化，就不会调用onLayout()方法`；
##### requestLayout()
+ `当布局发生变化的时候，如方向发生变化或尺寸发生变化，就要调用requestLayout()方法，重新测量，摆放，但是不会调用onDraw()`；

### Activity和View的问题
+ Activity和View的绘制过程不是同步进行的，所以有可能在Activity的onCreate、onStart、onResume方法中无法获取View的宽高；
#### 解决方法一

```
 /**
  * View已经初始化完毕了，宽/高已经准备好了，获取宽/高没有问题；但是该方法会被调用很多次，当Activity的窗口得到焦点和失去焦点时均会被调用一次，当Activity继续执行和暂停执行时，该方法也会被调用
  *
  * @param hasFocus
  */
  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
      super.onWindowFocusChanged(hasFocus);
      if (hasFocus) {
          int width = recyclerView.getMeasuredWidth();
          int height = recyclerView.getMeasuredHeight();
      }
  }
```
#### 解决方法二

```
 /**
  * 在Looper调用此runnable的时候，View已经初始化好了
  */
  @Override
  protected void onStart() {
      super.onStart();
      recyclerView.post(new Runnable() {
          @Override
          public void run() {
              int width = recyclerView.getMeasuredWidth();
              int height = recyclerView.getMeasuredHeight();
          }
      });
  }
```
#### 解决方法三

```
 /**
  * 当View树的状态发生变化的时候或者View树内部的View的可见性发生改变的时候，onGlobalLayout方法将会被调用，因此这是获取View的宽 高的一个很好的时机，需要注意的是，伴随着View树的状态改变等，onGlobalLayout方法会被调用多次
  */
  @Override
  protected void onStart() {
      super.onStart();
      ViewTreeObserver observer = recyclerView.getViewTreeObserver();
      observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
              recyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
              int width = recyclerView.getMeasuredWidth();
              int height = recyclerView.getMeasuredHeight();
          }
      });
  }
```

#### 解决方式四

```
view.measure(int widthMeasureSpec,int heightMeasureSpec);//通过手动对View进行measure来得到Ｖiew的宽/高；
```
