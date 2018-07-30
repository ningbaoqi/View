### RemoteViews实现自定义通知
```
private void sendCustomNotification() {
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
     Notification.Builder builder = new Notification.Builder(this).setAutoCancel(true).setChannelId("channel_id").setContentTitle("新消息来了").setContentText("明天是周六不上班好开心").setSmallIcon(R.mipmap.ic_launcher);
     RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);
     remoteViews.setTextViewText(R.id.notification_title, "custom_title");
     remoteViews.setTextViewText(R.id.notification_content, "custom_content");
     PendingIntent openActivity2 = PendingIntent.getActivity(MainActivity.this, 0, new Intent(MainActivity.this, Demo2Activity.class), PendingIntent.FLAG_UPDATE_CURRENT);
     remoteViews.setOnClickPendingIntent(R.id.turn_next, openActivity2);
     builder.setCustomContentView(remoteViews);
     getManager().notify(3, builder.build());
}
```
