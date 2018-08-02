### VideoView

|使用VideoView播放视频的步骤|
|------|
|在界面布局文件中定义VideoView组件，或在程序中创建VideoView组件|
|调用VideoView的如下两个方法来加载指定视频：setVideoPath(String path)：加载path文件所代表的视频；setVideoURI(Uri uri)：加载uri所对应的视频|
|调用VideoView的start()、stop()、pause()方法来控制视频播放|

+ 实际上`与VideoView一起结合使用的还有一个MeidaController类`，`它的作用是提供一个友好的图形控制界面，通过该控制界面来控制视频的播放`；界面中的`快进键、暂停键、后退键以及播放进度条就是由MediaController所提供的`；


#### Actiivty

```
public class VideoViewActivity extends AppCompatActivity {
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         getWindow().setFormat(PixelFormat.TRANSLUCENT);
         setContentView(R.layout.videoview);
         VideoView videoView = (VideoView) findViewById(R.id.videoview);
         MediaController controller = new MediaController(this);
         videoView.setVideoURI(Uri.parse("http://192.168.188.41:8080/sb.mp4"));
         videoView.setMediaController(controller);
         controller.setMediaPlayer(videoView);
         videoView.requestFocus();
         videoView.start();
    }
 }
```

#### res/layout/videoview.xml

```
<?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical">
     <VideoView
         android:id="@+id/videoview"
         android:layout_width="match_parent"
         android:layout_height="match_parent" />
 </LinearLayout>
```
