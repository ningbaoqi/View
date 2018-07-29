### View的绘制机制
#### View树的绘制流程
+ 当`Activity接收到用户触摸焦点`的时候，它就会被请求绘制布局；请求是由Android的`Framework`层处理绘制的，它从`根节点`开始对布局进行`测量`和`绘制`；`View树的绘制流程就是一个递归过程`，在`onMeasure()`方法中`View会对它所有的子元素进行测量，测量过程从父ViewGroup传递到它的子View中`，`经过子元素的递归，测量好了所有的子元素，就完成了ViewGroup的测量`，`onLayout()也是一种递归过程`；
#### 一、onMeasure
