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
