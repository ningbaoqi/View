### 矩形区域Rect
+ 类Rect除了能够表示一个矩形区域位置描述外，还可以帮助计算图形之间是否碰撞包含关系；
```
boolean contains(int left , int top,int right , int bottom);//left 矩形区域中左边的X坐标；top 矩形区域中顶部的y坐标；right 矩形区域中右边的x坐标，bottom 矩形区域中底部的y坐标
boolean contains(int x , int y);
boolean contains(Rect r);
```
