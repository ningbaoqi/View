### 构建3D图形

|GL10提供了如下方法|说明|
|------|------|
|glDrawElements(int mode , int count , int type, Buffer indices)|根据indices指定的索引点来绘制三角形，该方法的第一个参数指定绘制的图形类型，可设置为GL10.GL_TRIANGLES或GL10.GL_TRIANGLE_STRIP；第二个参数指定一共包含多少个顶点，indices参数最重要，它包装了一个长度为3N的数组，比如让该参数包装{0 , 1, 2, 3, 4, 5,}数组，这意味着告诉OpenGL ES要绘制两个三角形，第一个三角形的三个顶点为0、1、2顶点，第二个三角形的三个顶点为3、4、5顶点|

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-70.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-71.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-72.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-73.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-74.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-75.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-76.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-77.jpg)

+ 但如果遇到复杂的3D物体，就必须借助于三维建模软件了；
