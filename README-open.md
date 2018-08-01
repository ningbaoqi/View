### 在Android应用中使用OpenGL ES
+ Android为OpenGL ES支持提供了GLSurfaceView组件，这个组件用于显示3D图形，GLSurfaceView本身并不提供绘制3D图形的功能，而是由GLSurfaceView.Renderer来完成SurfaceView中3D图形的绘制；

|在Android中使用OpenGL ES需要三个步骤|
|------|
|创建GLSurfaceView组件，使用Activity显示GLSurfaceView组件|
|为GLSurfaceView组件创建GLSurfaceView.Renderer实例，实现GLSurfaceView.Renderer类时需要实现该接口里的三个方法：abstract void onDrawFrame(GL10 gl)：Renderer对象调用该方法绘制GLSurfaceView的当前帧；abstract void onSurfaceChanged(GL10 gl , int width , int height)当GLSurfaceView的大小改变时回调该方法；abstract void onSurfaceCreated(GL10 gl , EGLConfig config)：当GLSurfaceView被创建时回调该方法|
|调用GLSurfaceView组件的seuRenderer()方法指定Renderer对象，该Renderer对象将会完成GLSurfaceView里3D图形的绘制|

+ 从上面的介绍不难看出，实际上绘制3D图形的难点不是如何使用GLSurface组件，而是如何实现Renderer类，实现Renderer类时需要实现三个方法，这三个方法都有一个GL10形参，它就代表了OpenGL ES的绘制画笔，相当于Android 2D绘图中的Canvas组件，当我们希望Renderer绘制3D图形时，实际上是调用GL10的方法来进行绘制的；当SurfaceView被创建时，系统会回调Renderer对象的onSurfaceChanged方法，该方法可以对OpenGL ES执行一些无须任何变化的初始化代码，如：

```
public void onSurfaceCreate(GL10 gl , EGLConfig config){
       //关闭抗抖动
       gl.glDisable(GL10.GL_DITHER);
       //设置系统对透视进行修正
       gl.getHint(GL10.GL_PRESPRCTIVE_CORRECTION_HINT , GL10.GL_FASTEST);
       gl.glClearColor(0 ,0 ,0 ,0);
       //设置阴影平滑模式
       gl.glShadeModel(GL10.GL_SMOOTH);
       //启动深度测试
       gl.glEnable(GL10.GL_DEPTH_TEST);
       //设置深度测试的类型
       gl.glDepthFunc(GL10.GL_LEQUAL);
}
```

+ GL10就是OpenGL ES的绘图接口，虽然这里看到的是一个GL10，但实际上它也是GLES31的实例，读者可通过gl instanceof GL11判断它是否为GL11接口的实例；

|GL10包含的方法|说明|
|------|------|
|glDisable(int cap)|用于禁用OpenGL ES某个方面的特性，该方法中第一行代码用于关闭抗抖动，这样可以提高性能|
|glHint(int target , int mode)|用于对OpenGL ES某方面进行修正|
|glClearColor(float red , float green , float blue , float alpha)|用于设置OpenGL SE清屏所用的颜色，4个参数分别设置红、绿、蓝、透明度值-----0为最小值，1为最大值，例如设置gl.glClearColor(0 , 0 , 0 ,0 )就是用黑色清屏|
|glShadeModel(int mode)|用于黑色之OpenGL ES的阴影模式，此处设置为阴影平滑模式|
|glEnable(int cap)|该方法与glDisable(int cap)方法相对，用于启动OpenGL ES某方面的特性，此处用于启动OpenGL ES的深度测试，所谓深度测试，就是让OpenGL ES负责跟踪每个物体在Z轴上的深度，这样就可避免后面的物体遮挡前面的物体|

+ 当SurfaceView组件的大小发生变化时，系统会调用Renderer对象的onSurfaceChanged()方法，因此该方法通常用于初始化3D场景：如下面代码：

```
public void onSurfaceChanged(GL10 gl , int width , int height){
       //设置3D视图的大小及位置
       gl.glViewport(0 , 0 , width , height);
       //将当前矩阵模式设置为投影矩阵
       gl.glMatrixMode(GL10.GL_PREJECTION);
       //初始化单元矩阵
       gl.glLoadIdentity();
       //计算透视视图的宽度、高度比
       float ratio = (float) width / height;
       //调用此方法设置透视视窗的空间大小
       gl.glFrustumf(-ratio , ratio , -1 , 1 , 1, 10);
}
```

+ 上面的方法中用到了GL10的一些初始化方法，关于这些方法说明如下：

|方法|说明|
|------|------|
|glViewport(int x, int y , int width ,int height)|用于设置3D视图的位置与大小，其中前两个参数指定该视图的位置，后两个参数指定该视图的宽、高|
|glMatrixMode(int mode)|用于设置视图的矩阵模式，通常可接受GL10.GL_PROJECTION、GL10.GL_MODELVIEW两个常量值；当调用gl.glMatrixMode(GL10.GL_PROJECTION)代码后，指定将屏幕设置为透视图（要想看到逼真的三维物体，这是必要的）这意味着越远的东西看起来越小，当调用glMatrixMode(GL10.GL_MODELVIEW)代码后，即将当前矩阵模式设置为模型视图矩阵，这意味着任何新的变换都会影响到该矩阵中的所有物体
|glLoadIdnetity()|相当于reset()方法，用于初始化单位矩阵|
|glFrustumf(float left , float right , float bottom  , float top , float zNear , float zFar)|用于设置透视图投影的空间大小，前两个参数用于设置X轴上的最小坐标值，最大坐标值；中间两个参数用于设置Y轴上的最小坐标值、最大坐标值；后两个参数用于设置Z轴上所绘制的场景的深度的最小值、最大值如：gl.glFrustumf(-0.8 , 0.8 , -1 , 1 , 1 ,10)这意味着如果有一个二维矩形，它的4个顶点的坐标分别为（-0.8，1）、（0.8，1）、（0.8，-1）、（-0.8，-1）这个矩形将会占满整个视窗|

+ 前面已经指出，三维坐标系统与二维坐标系统并不相同，二维坐标系统上的坐标值通常就直接使用系统的像素数量，但三维坐标系统的坐标值则取决于glFrustumf()方法的设置，当我们调用gl.glFrustumf(-0.8 , 0.8 , -1 , 1 , 1, 10)方法时，意味着该三维坐标系统的X轴最左边的坐标值为-0.8 ， 最右边的坐标值为0.8，Y轴最上面的坐标值为1.0，最下面的坐标值为-1.0；GLSurfaceView上的所有3D图形都是由Renderer的onDrawFrame(GL10 gl)方法绘制出来的，重写该方法时就要把所有3D图形绘制出来，该方法通常以如下形式开始：

```
public void onDrawFrame(GL10 gl){
       //清除屏幕缓存和深度缓存
       gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);=
       .......
}
```
