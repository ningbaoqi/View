### Notification使用简介
```
public class NotificationActivity extends AppCompatActivity {
     private NotificationManager manager;
     private static final int NOTIFICATION_ID = 2;
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.notification);
         manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
         findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 sendNotification();
            }
         });
         findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cancelNotification();
             }
        });
     }
     private void cancelNotification() {
         manager.cancel(NOTIFICATION_ID);
     }
     private void sendNotification() {
         Notification.Builder builder = new Notification.Builder(this);
         builder.setSmallIcon(R.mipmap.ic_launcher);
         builder.setTicker("hello");
         builder.setContentTitle("内容标题");
         builder.setContentText("我是一个帅哥");
         Intent intent = new Intent(this, DialogActvity.class);
         PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
         builder.setContentIntent(pIntent);
         builder.setDefaults(Notification.DEFAULT_VIBRATE);
         builder.setDefaults(Notification.DEFAULT_SOUND);
         builder.setDefaults(Notification.DEFAULT_LIGHTS);
         builder.setWhen(System.currentTimeMillis());
         Notification notification = builder.build();
         manager.notify(NOTIFICATION_ID, notification);
     }
}
```
### Android8.0发送普通通知
```
public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNormalNotification();
            }
        });
    }
    private NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        return manager;
    }
    private void sendNormalNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);//创建通知渠道
            channel.canBypassDnd();//可否绕过请勿打扰模式
            channel.enableLights(true);//闪光
            channel.setLockscreenVisibility(VISIBILITY_SECRET);//锁屏显示通知
            channel.setLightColor(Color.argb(100, 100, 100, 100));//指定闪光时的灯光颜色
            channel.canShowBadge();//桌面launcher消息角标
            channel.enableVibration(true);//是否可以震动
            channel.getAudioAttributes();//获取系统通知响铃声音的配置
            channel.getGroup();//获取通知渠道组
            channel.setBypassDnd(true);//设置可以绕过，请勿打扰模式
            channel.setVibrationPattern(new long[]{100, 100, 200});//震动的模式
            channel.shouldShowLights();//是否会显示闪光
            getManager().createNotificationChannel(channel);//让通知服务知道有这么个渠道
        }
        Notification notification = new Notification.Builder(this).setAutoCancel(true).setChannelId("channel_id").setContentTitle("新消息来了").setContentText("明天是周六不上班好开心").setSmallIcon(R.mipmap.ic_launcher).build();
        getManager().notify(1, notification);
    }
}
```
### Android8.0发送带进度条的通知
```
/**
  * 设置带进度条的通知
  */
 private void sendProgressNotification() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel("channel_id", "channel_name", NotificationManager.IMPORTANCE_DEFAULT);//创建通知渠道
        channel.canBypassDnd();//可否绕过请勿打扰模式
        channel.enableLights(true);//闪光
        channel.setLockscreenVisibility(VISIBILITY_SECRET);//锁屏显示通知
        channel.setLightColor(Color.argb(100, 100, 100, 100));//指定闪光时的灯光颜色
        channel.canShowBadge();//桌面launcher消息角标
        channel.enableVibration(true);//是否可以震动
        channel.getAudioAttributes();//获取系统通知响铃声音的配置
        channel.getGroup();//获取通知渠道组
        channel.setBypassDnd(true);//设置可以绕过，请勿打扰模式
        channel.setVibrationPattern(new long[]{100, 100, 200});//震动的模式
        channel.shouldShowLights();//是否会显示闪光
        getManager().createNotificationChannel(channel);//让通知服务知道有这么个渠道
    }
    final Notification.Builder builder = new Notification.Builder(this).setAutoCancel(true).setChannelId("channel_id").setContentTitle("新消息来了").setContentText("明天是周六不上班好开心").setSmallIcon(R.mipmap.ic_launcher).setDefaults(Notification.FLAG_ONLY_ALERT_ONCE);
    getManager().notify(2, builder.build());
    new Thread(new Runnable() {
         @Override
         public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                     Thread.sleep(1000);
                     builder.setDefaults(Notification.FLAG_ONLY_ALERT_ONCE);
                     builder.setProgress(100, i, false);
                     getManager().notify(2, builder.build());
                } catch (InterruptedException e) {
                     e.printStackTrace();
                }
             }
         }
    }).start();
}
```
### 折叠式Notification
```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Notification.Builder builder = new Notification.Builder(this);
    Intent intent = new Intent(this , MainActivity.class);
    PendingIntent intent1 = PendingIntent.getActivity(this, 0, intent, 0);
    builder.setContentIntent(intent1);
    builder.setSmallIcon(R.mipmap.ic_launcher_round);
    builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round));
    builder.setAutoCancel(true);
    builder.setContentTitle("折叠式同志");
    //用remoteviews来创建自定义的Norification
    RemoteViews remoteViews1 = new RemoteViews(getPackageName() , R.layout.view_fold);
    Notification notification = builder.build();
    //使用展开时的试图
    notification.bigContentView =  remoteViews1;
    ((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify(1 , notification);
}
```
+ 未实现;

### 悬挂式Notification
```
@Override
protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     Notification.Builder builder = new Notification.Builder(this);
     Intent intent = new Intent(this, MainActivity.class);
     PendingIntent intent1 = PendingIntent.getActivity(this, 0, intent, 0);
     builder.setContentIntent(intent1);
     builder.setSmallIcon(R.mipmap.ic_launcher_round);
     builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round));
     builder.setAutoCancel(true);
     builder.setContentTitle("悬挂式同志");
     //设置点击跳转
     Intent handIntent = new Intent();
     handIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     handIntent.setClass(this, MainActivity.class);
     PendingIntent intent2 = PendingIntent.getActivity(this, 0, handIntent, PendingIntent.FLAG_CANCEL_CURRENT);
     builder.setFullScreenIntent(intent2, true);
     builder.setVisibility(Notification.VISIBILITY_PRIVATE);//之后在没有锁屏时才会显示通知
     ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).notify(1, builder.build());
}
```
+ 未实现;
### Android8.0删除通知
```
findViewById(R.id.delete_notification).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getManager().cancel(3);
    }
});
```
### PendingIntent
[PendingIntent](https://github.com/ningbaoqi/View/blob/master/README-PendingIntent.md)
