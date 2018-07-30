### PendingIntent

|PendingIntent的FLAG|说明|
|------|------|
|FLAG_ONE_SHOT|当前描述的PendingIntent只能被使用一次，然后它就会被自动cancel，如果后续还有相同的PendingIntent，那么它们的send方法就会调用失败，对于通知栏消息来说，如果采用这个标志，那么同类的通知只能使用一次，后续的通知单击后将无法打开|
|||
|||
|||
