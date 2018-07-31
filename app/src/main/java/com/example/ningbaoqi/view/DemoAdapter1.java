package com.example.ningbaoqi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DemoAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflator;
    private List<DataModel> list = new ArrayList<>();

    public DemoAdapter1(Context context) {
        inflator = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list) {
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//创建ViewHolder时候调用
        Log.d("nbq", "onCreateViewHolder");
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new Type1Holder1(inflator.inflate(R.layout.layout1, parent, false));
            case DataModel.TYPE_TWO:
                return new Type2Holder2(inflator.inflate(R.layout.layout2, parent, false));
            case DataModel.TYPE_THREE:
                return new Type3Holder3(inflator.inflate(R.layout.layout3, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {//都创建完成后，滑动的时候只调用了该方法
        ((AbstractHolder) holder).bindHolder(list.get(position));
        Log.d("nbq", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {//获取数据类型
        return list.get(position).type;
    }
}