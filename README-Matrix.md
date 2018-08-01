### Matrix
+ Matrix是Android提供的一个矩阵工具类，它本身并不能对图形或组件进行变换，但它可以与其他API结合来控制图形、组件的变换；

|使用Matrix控制图形或组件变换的步骤|
|------|
|获取Matrix对象，该Matrix对象即可新创建，也可直接获取其他对象内封装的Matrix（例如Transformation对象内部就封装了Matrix）|
|调用Matrix的方法进行平移、旋转、缩放、倾斜等|
|将程序对Matrix所做的变换应用到指定图形或组件|

|Matrix提供方法|说明|
|------|------|
|void reset()|重置一个matrix对象|
|void set(Matrix src)|复制一个源矩阵|
|void isIdentity()|返回这个矩阵是否定义(已经有意义)|
|setTranslate(float dx , float dy)|控制Matrix进行平移|
|setSkew(float kx , float ky , float px , float py)|控制Matrix以px、py为轴心进行倾斜，kx、ky为X、Y方向上的倾斜距离|
|setSkew(float kx , float ky)|控制Matrix进行倾斜，kx、ky为X、Y方向上的倾斜距离|
|setRotate(float degress)|控制Matrix进行旋转，degress控制旋转的角度，原点为(0,0)|
|setRotate(float degress , float px , float py)|设置以(px、py)为轴心进行旋转，degress控制旋转的角度|
|setScale(float sx , float sy)|设置Matrix进行缩放，sx、sy控制X、Y方向上的缩放比例|
|setScale(float sx , float sy , float px , float py)|设置Matrix以px、py为轴心进行缩放，sx、sy控制X、Y方向上的缩放比例|

+ 一旦对Matrix进行了变换，接下来就可应用该Matrix对图形进行控制了，例如：Canvas就提供了一个drawBitmap(Bitmap bitmap , Matrix matrix , Paint paint)方法，调用该方法就可以在绘制Bitmap时应用Matrix上的变换；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-12.jpg)

+ 借助于Bitmap的createBitmap方法可以挖取源位图的其中一块，这样可以在程序中通过定时器控制不断的挖取源位图不同位置的块，从而给用户看到背景移动的假象；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-13.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-14.jpg)

+ 其中注意跟图片的大小有关，该背景图片的分辨率为626*903；

### 使用矩阵实现简单特效

```
Matrix matrix = new Matrix();
/**
* 使用矩阵添加特效
* */
//matrix.setTranslate(30, 50);平移
//matrix.setScale(0.6f, 0.8f);缩放
//matrix.setRotate(45f);旋转
/**
* 倒影
* */
matrix.setScale(1, -1);
matrix.postTranslate(0, bitmapCopy.getWidth());
canvas.drawBitmap(bitmapSrc, matrix, paint);
```

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-28.jpg)
