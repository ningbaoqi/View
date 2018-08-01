### SurfaceView
+ SurfaceView一般会与SurfaceHolder结合使用，SurfaceHolder用于向与之关联的SurfaceView上绘图，调用SurfaceView的getHolder()方法即可获取SurfaceView关联的SurfaceHolder；SurfaceHolder提供了如下方法来获取Canvas对象：

|方法|说明|
|------|------|
|Canvas lockCanvas()|锁定整个SurfaceView对象，获取该SurfaceView上的Canvas|
|Canvas lockCanvas(Rect dirty)|锁定SurfaceView上Rect划分的区域，获取该SurfaceView上的Canvas|

+ 当对同一个SurfaceView调用上面两种方法时，两种方法返回的是同一个Canvas对象，但当程序调用第二个方法获取指定区域的Canvas时，SurfaceView将只对Rect所圈起来的区域进行更新，通过这种方式可以提高画面的更新速度；当通过lockCanvas()获取指定的SurfaceView上的Canvas之后，接下来程序就可以调用Canvas进行绘图了，Canvas绘图完成后通过如下方法释放绘图，提交所绘制的图形：

|方法|说明|
|------|------|
|unlockCanvasAndPost(canvas)|当调用该方法之后，该方法之前所绘制的图形还处于缓冲区中，下一次lockCanvas()方法锁定的区域可能会遮挡它|

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-20.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-21.jpg)
