### PendingIntent

|PendingIntent的FLAG|说明|
|------|------|
|FLAG_ONE_SHOT|当前描述的PendingIntent只能被使用一次，然后它就会被自动cancel，如果后续还有相同的PendingIntent，那么它们的send方法就会调用失败，对于通知栏消息来说，如果采用这个标志，那么同类的通知只能使用一次，后续的通知单击后将无法打开|
|FLAG_NO_CREATE|当前描述的PendingIntent不会主动创建，如果当前PendingIntent之前不存在，那么getActivity、getService、getBroadcast方法会直接返回null，即获取PendingIntent失败，不常用|
|FLAG_CANCEL_CURRENT|当前描述的PendingIntent如果已经存在，那么他们都会被cancel，然后系统会创建一个新的PendingIntent，对于通知栏来说，那些被cancel的消息单击后无法打开|
|FLAG_UPDATE_CURRENT|当前描述的PendingIntent如果已经存在，那么他们都会被更新，即他们的Ｉntent中的Ｅxtras会被替换成最新的|
