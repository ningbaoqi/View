### RecyclerView简介
+ `RecyclerView架构，提供了一种插拔式的体验，高度的解耦，异常的灵活，通过设置它提供的不同LayoutManager，ItemDecoration , ItemAnimator实现令人瞠目的效果`;`不关心item是否显示在正确的位置，如何显示`,`不关心item间如何分隔`,`不关心item增加与删除的动画效果`,`仅仅关注如何回收与复用View`；`RecycleView的好处：根据不同类型进行不同的缓存，根据类型不同由多个缓存池，这样一个List中由多个布局方式的话，会根据不同的缓存池得到布局，布局管理器更加灵活`;

|功能|方法|
|------|------|
|`LayoutManager`|`控制其显示的方式`|
|`ItemDecoration`|`控制Item间的间隔（可绘制）`|
|`ItemAnimator`|`控制Item增删的动画`|
|`请自己写`|`控制点击、长按事件`|
