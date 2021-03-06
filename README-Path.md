### Path类
+ `Android还为路径绘制提供了PathEffect来定义绘制效果`，`PathEffect`包含如下`子类`（每个子类代表一种绘制效果）;`ComposePathEffect`、`CornerPathEffect`、`DashPathEffect`、`DashPathEffect`、`DiscretePathEffect`、`PathDashPathEffect`、`SumPathEffect`;

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = new RelativeLayout(this);
        layout.addView(new MyView(this));
    }

    class MyView extends View {
        Paint paint;
        Path path;
        int[] colors;
        float phase;
        PathEffect[] effects = new PathEffect[7];

        public MyView(Context context) {
            super(context);
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            path = new Path();
            path.moveTo(0, 0);
            for (int i = 0; i < 40; i++) {
                path.lineTo(i * 20, (float) (Math.random() * 60));
            }
            colors = new int[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW}
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            effects[0] = null;
            effects[1] = new CornerPathEffect(10);
            effects[2] = new DiscretePathEffect(3.0f, 5.0f);
            effects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, phase);

            Path p = new Path();
            p.addRect(0, 0, 8, 8, Path.Direction.CCW);
            effects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
            effects[5] = new ComposePathEffect(effects[2], effects[4]);
            effects[6] = new SumPathEffect(effects[4], effects[3]);
            canvas.translate(8, 8);

            for (int i = 0; i < effects.length; i++) {
                paint.setPathEffect(effects[i]);
                paint.setColor(colors[i]);
                canvas.drawPath(path, paint);
                canvas.translate(0, 60);
            }
            phase += 1;
            invalidate();
        }
    }
}
```

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-1.jpg)

+ 当定义`DashPathEffect、PathDashPathEffect时可指定一个phase参数`，`该参数用于指定路径效果的相位`，`当该phase参数发生改变时，绘制效果也略有变化，上面的程序不停的改变phase参数，并不停的重绘该View组件，这将产生动画效果`；除此之外，Android的`Canvas还提供了一个drawTextOnPath(String text , Path path , float hOffset , float vOffset , Paint paint)方法，该方法可以沿着Path绘制文本，其中hOffset参数指定水平偏移，vOffset参数指定垂直偏移`：

![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-2.jpg)
![image](https://github.com/ningbaoqi/View/blob/master/gif/pic1-3.jpg)
