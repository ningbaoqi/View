### Matrix
+ Matrix是Android提供的一个矩阵工具类，它本身并不能对图形或组件进行变换，但它可以与其他API结合来控制图形、组件的变换；

|使用Matrix控制图形或组件变换的步骤|
|------|
|获取Matrix对象，该Matrix对象即可新创建，也可直接获取其他对象内封装的Matrix（例如Transformation对象内部就封装了Matrix）|
|调用Matrix的方法进行平移、旋转、缩放、倾斜等|
|将程序对Matrix所做的变换应用到指定图形或组件|
