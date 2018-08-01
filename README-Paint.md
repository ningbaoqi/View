### Paint

|Paint的常用方法|说明|
|------|------|
|void reset()|重置功能|
|setARGB(int a,int r,int g,int b)|设置Ｐaint对象的颜色|
|setColor(int color)|设置Ｐaint对象的颜色|
|setAntiAlias(boolean aa)|设置是否抗锯齿，需要配合setFlags(Paint.ANTI_ALIAS_FLAG)方法一起使用，来帮助取消锯齿使其边缘更平滑|
|Shader setShader(Shader shader)|设置阴影效果，Shader类是一个矩形对象，如果为null则消除阴影|
|void setStyle(Paint.Style style)|设置样式，一般为Fill填充，或者STROKE凹陷效果|
|void setTextSize(float textSize)|设置字体的大小|
|void setTextAlign(Paint.Align align)|设置文本的对齐方式|
|Typeface setTypeface(Typeface typeface)|设置具体的字体，通过Typeface可以加载Android内部的字体|
|void setUnderlineText(boolean underlineText)|设置是否设置下划线|
