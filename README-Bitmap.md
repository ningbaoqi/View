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
