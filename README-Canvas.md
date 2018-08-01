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
