### 屏幕适配基础
#### 屏幕尺寸
+ `屏幕尺寸指屏幕的对角线的长度`单位`英寸`；`1英寸=2.54厘米`；
#### 屏幕分辨率
+ `屏幕分辨率是指在横纵向上的像素点数`单位`px`;`1px=1个像素点`；
#### 像素密度dpi
+ `屏幕像素密度是指每英寸上的像素点数`单位为`dpi`；屏幕像素密度与屏幕尺寸和屏幕分辨率有关；
#### 像素px
+ `进行UI设计和Android API调用的时候，返回的数据都是以px为单位的`；
#### 密度无关像素dp、dip
+ 密度无关像素，以`160dpi`为基准，`1dip=1px`;`240dpi  中  1dp = 1.5px`;
#### 文字大小单位sp
+ `sp使用偶数不要使用奇数`；
#### 不同像素密度区分
+ `像素密度可以修饰图片和values`；`values-1280x720`；

|像素密度|说明|
|-------|-------|
|mdpi|120dpi~160dpi|
|hdpi|160dpi~240dpi|
|xhdpi|240dpi~320dpi|
|xxhdpi|320dpi~480dpi|
|xxxhdpi|480dpi~640dpi|

### 屏幕适配
#### 注意weight的计算方法
#### 使用限定符
##### 布局限定
+ `res/layout/main.xml`；`res/layout-large/main.xml`；在Android3.2之前起作用；在3.2之后不用；`res/layout-sw600dp/main.xml(最小宽度边为600dp以上使用的布局)`；
```
//使用布局别名
res/layout/main.xml 单面板
res/layout/main_twopanes.xml双面板

//默认布局
res/values/layout.xml
<resources>
    <item name="mian" type="layout">@layout/main</item>
</resources>

//Android3.2之前的平板电脑
res/values-large/layout.xml
<resources>
    <item name="mian" type="layout">@layout/main_twopanes</item>
</resources>

//Android3.2之后的平板布局
res/values-sw600dp/layout.xml
<resources>
    <item name="mian" type="layout">@layout/main_twopanes</item>
</resources>

//使用布局
setContentView(R.layout.main)
```
```
//使用屏幕方向限定符
res/values-sw600dp-land/layouts.xml
res/values-sw600dp-port/layouts.xml
```
