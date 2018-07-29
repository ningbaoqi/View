### 事件传递机制
#### 为什么会有事件分发机制
+ `Android上的View是以树形结构存在的，所以View控件有可能重叠在一起`；`当我们点击的地方有多个View都可以响应的时候，这个点击事件应该给谁呢？为了解决这个问题，就有了事件分发机制`；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-10.jpg)

#### 三个重要的事件分发的方法

|三个重要的事件分发的方法|说明|
|------|------|
|`dispatchTouchEvent`|会调用onInterceptTouchEvent来判断是否进行拦截事件,一定会被调用|
|`onInterceptTouchEvent`|用来拦截事件，如果子控件需要对事件进行处理，就会拦截该事件，然后在onTouchEvent中进行处理|
|`onTouchEvent`|处理从View传递过来的手势事件，手势事件包括按下屏幕，活动屏幕，抬起屏幕，取消等|

+ `Activity和View是没有第二个拦截事件的`因为`Activity作为事件的原始分发者，如果Activity拦截了这个事件，那么整个屏幕将无法响应该事件`；`View作为事件传递的最末端，要么将事件消费掉，要么就不处理进行回传`;

#### 事件分发流程
+ `Activity->PhoneWindow->DecorView->ViewGroup->....->View`；`如果事件一直没有被处理，将会将该事件反转回传，最终传送到Activity`；`如果最后Activity还是没有处理，这个事件将会被抛弃`；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-11.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-12.jpg)

#### ViewGroup中可能有多个childView，如何判断应该分配给哪一个？
+ `只要把所有的子View全部遍历一下，如果手指触摸的点在你所在的childView区域上，就将事件传递给该childView`‘；
#### 当该点的childView有重叠时应该如何分配？
+ `当childview重叠的时候一般会分配给显示在最上面的childview`；`跟android的渲染机制有关系`；
#### view的事件分发：view为什么会有dispatchTouchEvent方法？
+ `View可以注册很多事件监听器如onClick、onLongClick、onTouch等`；
#### view的事件分发：view的四个相关方法
+ 一、`单击事件onClickListener`：`需要两个事件才能触发：Action down 、Action up`；二、`长按事件onLongClickListener`；三、`触摸事件onTouchListener`；四、`View自身处理onTouchEvent`：`是一种默认的处理方式`；
#### View的事件分发：view的四个相关方法调用顺序
+ `onTouchListener`->`onTouchEvent`->`onLongClickListener`->`onClickListener`;
