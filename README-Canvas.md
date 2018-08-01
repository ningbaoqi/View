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
