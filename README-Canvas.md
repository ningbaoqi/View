### Canvas

|Canvas的常用方法|说明|
|------|------|
|Canvas()|创建一个空的画布，可以使用setBitmap()方法来设置绘制的具体画布|
|Canvas(Bitmap bitmap)|功能是以bitmap对象创建一个画布，并将内容都绘制到bitmap上，bitmap不能为null|
|Canvas(GL gl)|在绘制3Ｄ效果时使用，与OpenGL有关|
|drawColor|设置画布的背景色|
|setBitmap|设置具体的画布|
|clipRect|设置显示区域，即设置裁剪区|
|isOpaque|检测是否支持透明|
|rotate|旋转画布|
|canvas.drawRect(RectF,Paint)|绘制矩形，其中第一个参数是图形显示区域，第二个参数是画笔|
|canvas.drawRoundRect(RectF,float,float,Paint)|绘制圆角矩形，第一个参数是图形显示区域，第二个参数和第三个参数是水平圆角半径和垂直圆角半径|
|canvas.drawLine(startX,startY,stopX,stopY,paint)|表示从点startＸ，startＹ到点stopＸ，stopＹ画一条直线|
|canvas.drawArc(RectF,float startAngle,float sweepAngle,Ｂoolean useCenter,Ｐaint paint)|第一个参数是圆弧的显示区域；startAngle圆弧起始角度，sweepAngle圆弧度数，3点钟方向为0度，useCenter设置是否显示圆心|
|canvas.drawCircle(float , float , float , Paint)|用于绘制圆，前两个参数表示圆心坐标，第三个参数表示圆的半径|
|save()|锁定需要操作的对象|
|restore()|解除锁定|

+ Canvas提供了一个drawBitmapMesh(Bitmap bitmap , int meshWidth , int meshHeight , float[] verts , int vertOffset , int[] colors , int colorOffset , Paint paint)方法，该方法可以对bitmap进行扭曲，这个方法非常灵活，如果用好这个方法，开发者可以在Android应用上开发出”水波震荡“、”风吹旗帜“等各种扭曲效果；drawBitmapMesh方法的关键参数说明如下：

|参数|说明|
|------|------|
|bitmap|指定需要扭曲的源位图|
|meshWidth|该参数控制在横向上把该源位图划分成多少格|
|meshHeight|该参数控制在纵向上把该源位图划分成多少格|
|verts|该参数是一个长度为（meshWidth + 1）\*（meshHeight + 1）\*2的数组，它记录了扭曲后的位图各顶点位置，虽然它是一个一维数组，但实际上它记录的数据是形如(x0,y0)、(x1 , y1)....、(xN , yN)格式的数据，这些数组元素控制对bitmap位图的扭曲效果|
|vertOffset|控制verts数组中从第几个数组元素开始对bitmap进行扭曲（忽略vertOffset之前的数据的扭曲效果）|

