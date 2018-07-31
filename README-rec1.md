### RecyclerView实现复杂布局原理
+ `如多种样式的列表`；`宫格和列表同时存在`；`分类列表如通讯录`;
#### RecyclerView重点
+ `复写getItemViewType(int position)方法，根据各个position的位置，返回不同的类别`；`需要处理getItemCount()方法`；`按照类别处理onCreateViewHolder和onBindViewHolder`；
#### 处理数据
+ `把多个数据类型都包装进一个Object中`；或`封装RecyclerView.Adapter，把一些不同的item当作header`；
#### RecyclerView多种布局原理与机制
##### RecyclerView中的关键成员

|RecyclerView中的关键成员|说明|
|------|------|
|`getItemViewType(int position)`|`ItemType保存在Holder中；Holder根据position被缓存到换存池中，当需要复用的时候，系统会在缓存池里面拿到holder，进而实现使用流畅`；`遍历缓存中的Holder，如果Type一致就返回当前的holder`|
|`RecyclerView.Hodler`|`在RecyclerView中保存View的单位`；ListView里面保存的是View，而RecyclerView保存的是Holder，这是他们两个的区别；Holder记录在RecyclerView中的基本信息；Holder中还有是否需要被缓存的Flag标志；`RecyclerView的缓存单位是Holder而不再是View`|
|`RecyclerView.Recycler`|`保存了一些缓存的机制可以类比为convertView`,RecyclerView缓存Holder；Holder保存在map中，map放在Recycler内部类中；多个RecyclerView公用一个缓存池RecycleredPool是一个静态成员变量，`缓存池中的key是一个Type，所以根据Type去找到Holder`；配置缓存size|

#### 多重布局的设计流程
