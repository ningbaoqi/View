### 旋转
+ GL10提供了一个glRotatef(float angle , float x , float y , float z)方法，用于控制旋转，该方法中angle控制旋转角度，而x , y , z  ,参数则共同决定了旋转轴的方向；本质上，glRotatef()方法的作用与glTranslatef(float x,  float y , float z)方法相似，只是glTranslate(float x, float y , float z)方法控制图形中心移动，而glRotatef()方法控制图形沿着指定旋转轴转动指定角度；因此，只要在调用glTranslatef方法控制图形移动之后，再调用glRotate()控制图形旋转即可，如果希望看到指定图形不断旋转，则只要在onDrawFrame()方法中不断增加旋转角度即可；

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-60.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-61.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-62.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-63.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-64.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-65.jpg)

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-66.jpg)
