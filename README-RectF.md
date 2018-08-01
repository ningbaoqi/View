### 矩形区域RectF
+ 矩形RectF和Rect的区别是精度不同：Rect使用int类型作为数值，RectF是使用float类型作为数值；

|RectF常用的方法|说明|
|------|------|
|RectF()|构造一个无参的矩形|
|RectF(float left , float top,float right ,float bottom)|构造一个指定了4个参数的矩形|
|RectF(RectF r)|根据指定的RectF对象来构造一个RectF对象|
|RectF(Rect r)|根据给定的Rect对象来构造一个RectF对象|
|boolean contain(RectF f)|判断一个矩形是否在此矩形内，如果在这个矩形内或者和这个矩形等价则返回true|
|void union(float x , float y)|更新这个矩形，使它包含矩形自己和（x,y）这个点|
