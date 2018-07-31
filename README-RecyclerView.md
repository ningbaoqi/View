### RecyclerView简介
+ `RecyclerView架构，提供了一种插拔式的体验，高度的解耦，异常的灵活，通过设置它提供的不同LayoutManager，ItemDecoration , ItemAnimator实现令人瞠目的效果`;`不关心item是否显示在正确的位置，如何显示`,`不关心item间如何分隔`,`不关心item增加与删除的动画效果`,`仅仅关注如何回收与复用View`；`RecycleView的好处：根据不同类型进行不同的缓存，根据类型不同由多个缓存池，这样一个List中由多个布局方式的话，会根据不同的缓存池得到布局，布局管理器更加灵活`;

|功能|方法|
|------|------|
|`LayoutManager`|`控制其显示的方式`|
|`ItemDecoration`|`控制Item间的间隔（可绘制）`|
|`ItemAnimator`|`控制Item增删的动画`|
|`请自己写`|`控制点击、长按事件`|

```
mRecyclerView = findView(R.id.id_recyclerview); 
//设置布局管理器
mRecyclerView.setLayoutManager(layout); 
//设置adapter
mRecyclerView.setAdapter(adapter) 
//设置Item增加、移除动画
mRecyclerView.setItemAnimator(new DefaultItemAnimator()); 
//添加分割线
mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
```
+ `RecyclerView代表的意义是，我只管Recycler View，也就是说RecyclerView只管回收与复用View，其他的你可以自己去设置。可以看出其高度的解耦，给予你充分的定制自由`;
#### LayoutManager

|RecyclerView.LayoutManager实现类|说明|
|------|------|
|`LinearLayoutManager`|现行管理器，支持横向、纵向|
|`GridLayoutManager`|网格布局管理器|
|`StaggeredGridLayoutManager`|瀑布就式布局管理器|

#### ItemAnimator设置选项动画
```
// 设置item动画 
mRecyclerView.setItemAnimator(new DefaultItemAnimator());
```
#### 更新数据集
```
public void addData(int position) {
     mDatas.add(position, "Insert One");
     notifyItemInserted(position); 
} 
public void removeData(int position) {
     mDatas.remove(position);
     notifyItemRemoved(position); 
}
```
#### Click and LongClick
```
class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        //...
        public interface OnItemClickLitener {
            void onItemClick(View view, int position);

            void onItemLongClick(View view, int position);
        }

        private OnItemClickLitener mOnItemClickLitener;

        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.tv.setText(mDatas.get(position));

            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    }
                });

                holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }
        }
    }


mAdapter.setOnItemClickLitener(new OnItemClickLitener(){            
    @Override
    public void onItemClick(View view, int position){
          Toast.makeText(HomeActivity.this, position + " click",Toast.LENGTH_SHORT).show();
    }            
    @Override
    public void onItemLongClick(View view, int position){
          Toast.makeText(HomeActivity.this, position + " long click",Toast.LENGTH_SHORT).show();
          mAdapter.removeData(position);
    }
});

```
### [RecyclerView实现复杂布局原理](https://github.com/ningbaoqi/View/blob/master/README-rec1.md)
### [RecyclerView处理不同类型的数据](https://github.com/ningbaoqi/View/commit/70d7c19ec10df883de84d78e18f4e7c6863ec0f8)
+ 在实际开发中因为从服务器上传递过来的数据的类型是不同的，所以会解析成多个JavaBean；现模拟三个数据类型；
### [RecyclerView实现ListView](https://github.com/ningbaoqi/View/commit/31daf9fd463d8bfefc8f835b409f575967b442b1)
### [RecyclerView实现GridView](https://github.com/ningbaoqi/View/commit/5e6b2b2743b78d23e9f384fdc851d66f144d94a1)
### [RecyclerView实现多个样式的列表](https://github.com/ningbaoqi/View/commit/12f0cbc2700d18114edecc7b5b31ff902cfe79ef)
### [RecyclerView实现网格布局ListView混排](https://github.com/ningbaoqi/View/commit/2183e2458751e615bd7a4bfe65b83efbaf76bf02)
### [RecyclerView实现瀑布流](https://github.com/ningbaoqi/View/commit/7ecccf9440323c74c35dab21549a44aa764d2a31)

