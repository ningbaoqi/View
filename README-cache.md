### 三级缓存原理

|缓存|说明|
|------|------|
|`内存缓存`|优先加载，速度最快|
|`本地缓存`|次优先加载，速度快|
|`网络缓存`|不优先加载，速度慢，浪费流量|

+ 如果`在内存中有直接返回`，如果`在内存中没有，将本地缓存中的数据加载到内存`，如果`内存和本地都没有，使用网络缓存，从网络上下载到本地，然后加载到内存`；
