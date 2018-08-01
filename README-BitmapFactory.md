### BitmapFactory

|BitmapFactory中常用的方法|说明|
|------|------|
|static Bitmap decodeByteArray(byte[] data,int offset,int length)|从字节数组中的创建方法|
|static Bitmap decodeByteArray(byte[] data,int offset,int length, BitmapFactory.Options options)|从字节数组中的创建方法|
|static Bitmap decodeFile(String pathName , BitmapFactory.Options opts)|从文件中创建方法，在使用时要写全路径|
|static Bitmap decodeFile(String pathName)|从文件中创建方法，在使用时要写全路径|
|static Bitmap decodeFileDescriptor(FileDescriptor fd , Rect outPadding,BitmapFactory.Options opts)|从输入流句柄中的创建方法|
|static Bitmap decodeFileDescriptor(FileDescroptor fd)|从输入流句柄中的创建方法|
|static Bitmap decodeResource(Resources res , int id)|从Android的APK文件资源中的创建方法|
|static Bitmap decodeResource(Resources res ,int id , BitmapFactory.Options opts)|从Android的APK文件资源中的创建方法|
|static Bitmap decodeResource(Resources res,ＴypedValue value,InputStream is ,Rect pad,BitmapFactory.Options opts)|从Android的APK文件资源中的创建方法|
