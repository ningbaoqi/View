### View的绘制机制
#### View树的绘制流程
+ 当`Activity接收到用户触摸焦点`的时候，它就会被请求绘制布局；请求是由Android的`Framework`层处理绘制的，它从`根节点`开始对布局进行`测量`和`绘制`；`View树的绘制流程就是一个递归过程`，在`onMeasure()`方法中`View会对它所有的子元素进行测量，测量过程从父ViewGroup传递到它的子View中`，`经过子元素的递归，测量好了所有的子元素，就完成了ViewGroup的测量`，`onLayout()也是一种递归过程`；
#### 一、onMeasure
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-21.jpg)


|重要参数|说明|
|-------|-------|
|`ViewGroup.LayoutParams`|属性值|
|`MeasureSpec`|测量规格，32位的整数值，前两位是测量模式，后30位是测量规格的大小|

+ `实现测量逻辑的方法`；
#### 二、onLayout
+ `根据测量得到的尺寸，来摆放View`;
#### 三、onDraw
+ `在经过测量和摆放之后就可以进行绘制`；
##### invalidate()
+ `请求Android系统，如果视图大小没有发生变化，就不会调用onLayout()方法`；
##### requestLayout()
+ `当布局发生变化的时候，如方向发生变化或尺寸发生变化，就要调用requestLayout()方法，重新测量，摆放，但是不会调用onDraw()方法`；
