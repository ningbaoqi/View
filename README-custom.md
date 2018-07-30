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
||
||
||
||
||
||
||
||
||
