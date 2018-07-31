package com.example.ningbaoqi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
    private LayoutInflater inflator;
    public DemoAdapter(Context context) {
        inflator = LayoutInflater.from(context);
    }
    private List<Integer> types = new ArrayList<>();
    private Map<Integer, Integer> mPositions = new HashMap<>();
    private List<DataModelOne> list1;
    private List<DataModelTwo> list2;
    private List<DataModelThree> list3;
    public void addList(List<DataModelOne> list1, List<DataModelTwo> list2, List<DataModelThree> list3) {
        addListByType(TYPE_ONE, list1);
        addListByType(TYPE_TWO, list2);
        addListByType(TYPE_THREE, list3);
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }
    private void addListByType(int type, List list) {
        mPositions.put(type, types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//创建ViewHolder时候调用
        Log.d("nbq", "onCreateViewHolder");
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new Type1Holder(inflator.inflate(R.layout.layout1, parent, false));
            case DataModel.TYPE_TWO:
                return new Type2Holder(inflator.inflate(R.layout.layout2, parent, false));
            case DataModel.TYPE_THREE:
                return new Type3Holder(inflator.inflate(R.layout.layout3, parent, false));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {//都创建完成后，滑动的时候只调用了该方法
        int viewType = getItemViewType(position);
        int realPosition = position - mPositions.get(viewType);
        switch (viewType) {
            case TYPE_ONE:
                ((Type1Holder) holder).bindHolder(list1.get(realPosition));
                break;
            case TYPE_TWO:
                ((Type2Holder) holder).bindHolder(list2.get(realPosition));
                break;
            case TYPE_THREE:
                ((Type3Holder) holder).bindHolder(list3.get(realPosition));
                break;
        }
    }
    @Override
    public int getItemCount() {
        return types.size();
    }
    @Override
    public int getItemViewType(int position) {//获取数据类型
        return types.get(position);
    }
}
