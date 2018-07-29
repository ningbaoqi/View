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
