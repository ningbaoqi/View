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

### 基于SurfaceView开发示波器
+ SurfaceView与普通View还有一个重要的区别，View的绘图必须在当前UI线程中进行，但SurfaceView就不会存在这个问题，因此SurfaceView的绘图是由SurfaceHolder来完成的；SurfaceHolder会启动新的线程去更新SurfaceView的绘制，因此不会阻塞主UI线程；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-22.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-23.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-24.jpg)

### 使用SurfaceView实现动画
+ 虽然前面大量的介绍接使用自定义的View来进行绘制，但View的绘图机制存在如下缺陷：

|缺陷|
|------|
|View缺乏双缓冲机制|
|当程序需要更新View上的图片时，程序必须重绘View上显示的整张图片|
|新线程无法直接更新View组件|

+ 由于View存在上述缺陷，所以通过自定义View来实现绘制，尤其在游戏中的绘图时性能并不好，Android提供了一个SurfaceView来代替View，在实现游戏绘图方面，SurfaceView比View更加出色，因此一般推荐使用SurfaceView；
