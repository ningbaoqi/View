### 绘制平面上的多边形
+ 前面已经说过，计算机里的3D图形其实是由许多个平面组合而成的，所谓绘制3D图形，其实就是通过多个平面图形形成的；下面先从绘制平面图形开始；

|调用GL10图形绘制2D图形的步骤|
|------|
|调用GL10的glEnableClientState(GL10.GL_VERTEX_ARRAY)方法启用顶点坐标数组|
|调用GL10的glEnableClientState(GL10.GK_COLOR_ARRAY)方法启用顶点颜色数组|
|调用GL10的glVertexPointer(int size , int type , int stride , Buffer pointer)方法设置顶点的位置数据，这个方法中pointer参数用于指定顶点坐标值，但这里并未使用三维数组来指定每个顶点X、Y、Z坐标的值，pointer依然是一个一维数组，其格式为（x1, y1 , z1 , x2 , y2 , z2 , x3 ,y3, z3 , .......xN , yN , zN）也就是该数组里将会包含3N个数值，每3个值指定一个顶点的X、Y、Z坐标值，第一个参数size指定多少个元素指定一个顶点位置，该size参数通常从是3；type参数指定顶点坐标值的类型，如果顶点坐标值为float类型，则指定为GL10.GL_FLOAT；如果顶点坐标值为整数，则指定为GL10.GL_FIXED|
|调用GL10的glColorPointer(int size , int type , int stride , Buffer pointer)方法设置顶点的颜色数据，这个方法中pointer参数用于指定顶点的颜色值，pointer依然是一个一维数组，其格式为（r1 , g1 , b1 , a1, r2, g2, b2 , a2, r3 ,g3 ,b3 , a3,......rN , gN , bN , aN）也就是该数组里将会包含4N个数值，每4个值指定一个顶点颜色的红、绿、蓝、透明度的值，第一个参数size指定多少个元素指定一个顶点位置，该size参数通常总是4，type参数指定顶点坐标值的类型，如果顶点坐标值为float类型，则指定为GL10.GL_FLOAT，如果顶点坐标值为整数，则指定为GL10.GL_FIXED|
|调用GL10的glDrawArrays(int mode , int first , int count)方法绘制平面，该方法的第一个参数指定绘制图形类型，第二个参数指定从哪个顶点开始绘制，第三个参数指定总会绘制的顶点数量|
|绘制完成后，调用GL10的glFinish()方法结束绘制，并调用glDisableClientState(int)方法来停用顶点坐标数据、顶点颜色数据|

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-50.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-51.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-52.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-53.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-54.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-55.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-56.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-57.jpg)

+ 当调用glDrawArrays()方法时，如果将mode参数指定为GL10.GL_TRIANGLES，则绘制简单的三角形，如果将mode参数指定为GL10.GL_TRIANGLE_STRIP，那么系统将会沿着给出的顶点数据来绘制三角形；
