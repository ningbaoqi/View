### 事件传递机制
#### 为什么会有事件分发机制
+ `Android上的View是以树形结构存在的，所以View控件有可能重叠在一起`；`当我们点击的地方有多个View都可以响应的时候，这个点击事件应该给谁呢？为了解决这个问题，就有了事件分发机制`；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic-10.jpg)
