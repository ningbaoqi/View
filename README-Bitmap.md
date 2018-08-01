### Bitmap

|Bitmap常用的方法|说明|
|------|------|
|boolean compress(Bitmap.CompressFormat format , int quality,OutputStream stream)|压缩一个Bitmap对象，并根据相关的编码和画质保存到一个OutputStream中，目前的压缩格式有JPG,PNG|
|void copyPixelsFromBuffer(Buffer src)|从一个buffer缓冲区复制位图像素|
|void copyPixelsToBuffer(Buffer dst)|将当前位图像素内容复制到一个Buffer缓冲区|
|final int getHeight()|获取对象的高度|
|final int getWidth()|获取对象的宽度|
|final boolean hasAlpha()|设置是否有透明通道|
|void setPixel(int x , int y ,int color)|设置某像素的颜色|
|int getPixel(int x, int y)|获取某像素的颜色|

#### 一、recycle方法
+ `Bitmap是存储在native内存和Java内存当中的，所以对象回收的时候需要回收java内存中的内存和native内存中的内存；在Android3.0以前，BItmap像素的数据和Bitmap对象是一起存在在堆内存当中的，所以这时只要回收堆内存中的内存就可以了；而Android3.0以后，BItmap直接放在内存当中的，而回收Bitmap的时候是不稳定的，官方建议调用Bitmap的recycle()方法对Bitmap对象的回收，释放内存的时候也会释放native层中与该对象相关的内存`；`确保Bitmap对象不用了再调用recycle方法`；`官网上不建议主动调用`；
#### 二、LRU
+ `LRU算法主要在存储Bitmap三级缓存来使用`；`最近最少使用的对象，从队列中清除出去`；内部由`LinkedHashMap`实现的，提供了`get和put方法`，当缓存满了的时候`LRU算法提供的trimToSize方法把较早的缓存对象移除，添加新的缓存对象`；
#### 三、计算isSampleSize缩放比例

### [创建图片副本并添加简单特效](https://github.com/ningbaoqi/View/commit/ddc80446f38e874ce7f700af22268fa88e00eb44)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-29.jpg)
### [画画板](https://github.com/ningbaoqi/View/commit/4c140b1409c6b1b2e2bfb2ecff882ae60d39b1b1)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-30.jpg)
