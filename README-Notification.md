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
