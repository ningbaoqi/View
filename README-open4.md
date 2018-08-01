### 应用纹理贴图
+ 为了在OpenGL ES中启用纹理贴图功能，可以在Renderer实现类的onSurfaceCreated(GL10 gl , EGLConfig config)方法中启用纹理贴图：

```
//启动2D纹理贴图
gl.glEnable(GL10.GL_TEXTURE_2D);
```

+ 然后需要准备一张图片来作为纹理贴图了，建议该图片的长、宽是2的N次方，比如长、宽为256、512等，把这张准备贴图的位图放在Android项目的res/drawable目录下，以便应用程序加载该图片资源；接下来程序开始加载该图片并生成对应的纹理贴图，如；

```
//加载位图
bitmap = BitmapFactory.decodeResource(context.getResources() , R.drawable.sand);
int[] textures = new int[1];
//指定生成n个纹理 第一个参数指定生成一个纹理，textures数组将负责存储所有纹理的代号
gl.glGenTextures(1 , texture , 0);
//获取textures纹理数组中的第一个纹理
texture = textures[0];
//通知OpenGL将texture纹理帮顶到GL10.GL_TEXTURE_2D目标中
gl.glBindTexture(GL10.GL_TEXTURE_2D , texture);
//设置纹理被缩小 (距离视点很远时)的过滤方式
gl.glTextParameterf(GL10.GL_TEXTURE_2D , GL10.GL_TEXTURE_MIN_FILTER , GL10.GL_NEARSET);
//设置纹理被放大 (距离视点很近时)的过滤方式
gl.glTextParameterf(GL10.GL_TEXTURE_2D , GL10.GL_TEXTURE_MAG_FILTER , GL10.GL_LINEAR);
//设置横向、纵向上都是平铺纹理
gl.glTextParameterf(GL10.GL_TEXTURE_2D , GL10.GL_TEXTURE_WRAP_S , GL10.GL_REPEAT);
gl.glTextParameterf(GL10.GL_TEXTURE_2D , GL10.GL_TEXTURE_WRAP_T , GL10.GL_REPEAT);
//加载位图生成纹理
GLUtils.texImage2D(GL10.GL_TEXTURE_2D , 0 , bitmap , 0);
```
+ 上面的程序中用到了GL10的如下方法：

|方法|说明|
|------|------|
|glGenTextures(int n , int[] textures , int offset)|该方法指定一次性生成n个纹理，该方法所生成的纹理代号放入其中的textures数组中，offset指定从第几个数组元素开始存放纹理代号|
|glBindTexture(int target , int texture)|该方法用于将texture纹理绑定到target目标上|
|getTexParameterf(int target , int pname  , float param)|该方法用于为target纹理目标设置属性，其中第二个参数是属性名，第三个参数就是属性值|

+ 程序设置了当纹理被方法时使用GL10.GL_LINEAR滤波方式，当纹理被缩小时使用GL10.GL_NEAREST滤波方式，一般来说，使用GL10.GL_LINEAR滤波方式有较好的效果，但系统开销略微大了一些，具体采用哪种滤波方式则取决于目标机器自身的性能；在3D绘图中进行纹理贴图也很简单，与设置顶点颜色的步骤相似，如：

|步骤|
|------|
|设置启用贴图坐标数组|
|设置贴图坐标的数组信息|
|调用GL10的glBindTexture(int target , int texture)方法执行贴图|

