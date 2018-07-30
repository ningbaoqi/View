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
