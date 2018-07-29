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

#### 事件传递机制结论

|事件传递机制结论|
|------|
|同一个事件序列是指从手指解除屏幕的那一刻起，到手指离开屏幕的那一刻结束，在这个过程中所产生的一系列事件，这个事件序列以down事件开始，中间含有数量补丁move事件，最终以up事件结束|
|正常情况下，一个事件序列只能被一个View拦截并消耗，因为一旦一个元素拦截了此事件，那么同一个事件序列内的所有事件都会直接交给它处理，因此同一个事件序列中的事件不能分别由两个View同时处理，但是通过特殊手段可以做到，如：一个View将本该自己处理的事件通过onTouchEvent方法强行传递给其他View处理|
|某个View一旦决定拦截，那么这一个事件序列都只能由它来处理，并且它的onInterceptTouchEvent不会再被调用|
|某个View一旦开始处理事件，如果它不消耗掉action_down事件(onTouchEvent返回false)，那么同一事件序列中的其他事件都不会再交给它处理，并且事件将重新交给它的父元素去处理，即父元素的onTouchEvent会被调用|
|如果View不消耗除了action_down以外的事件，那么这个点击事件会消失，此时父元素的onTouchEvent并不会被调用，并且当前View可以持续收到后续的事件，最终这些小事的事件会传递给activity处理|
|ViewGroup默认不拦截任何事件|
|View没有onInterceptTouchEvent方法，一旦由点击事件传递给它，那么它的onTouchEvent方法就会被调用|
|View的OnTouchEvent方法默认会消耗事件(返回true)，除非它是不可点击的clickable和longClickable同时为false|
|View的enable属性不影响onTouchEvent的默认返回值。哪怕一个View是disable状态的，只要它的clickable或者longClickable有一个为true，那么它的onTouchEvent就返回true|
|onClick会发生再前提是当前View是可点击的，并且它收到了down和up的事件|
|事件传递过程是由外向内的，即事件总是传递给父元素，然后再由父元素分发给子View，通过requestDisallowInterceptTouchEvent分发可以在子View中干预父元素的事件分发q过程。但是action_down事件除外|
