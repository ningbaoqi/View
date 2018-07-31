package com.example.ningbaoqi.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DemoAdapter adapter;
    private int[] colors = {android.R.color.holo_blue_bright, android.R.color.holo_red_dark, android.R.color.holo_green_dark};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {//获取横跨的宽度
                int type = recyclerView.getAdapter().getItemViewType(position);
                if (type == DataModel.TYPE_THREE) {
                    return gridLayoutManager.getSpanCount();//2
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new DemoAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {//将每个Item间隔开来
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams pa = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = pa.getSpanSize();
                int spanIndex = pa.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });
        initData();
    }

    private void initData() {
        List<DataModelOne> list1 = new ArrayList<>();//第一种数据类型
        for (int i = 0; i < 10; i++) {
            DataModelOne dataModel = new DataModelOne();
            dataModel.avaterColor = colors[0];
            dataModel.name = "name" + i;
            list1.add(dataModel);
        }
        List<DataModelTwo> list2 = new ArrayList<>();//第二种数据类型
        for (int i = 0; i < 10; i++) {
            DataModelTwo dataModel = new DataModelTwo();
            dataModel.avaterColor = colors[1];
            dataModel.name = "name" + i;
            dataModel.content = "contant" + i;
            list2.add(dataModel);
        }
        List<DataModelThree> list3 = new ArrayList<>();//第三种数据类型
        for (int i = 0; i < 10; i++) {
            DataModelThree dataModel = new DataModelThree();
            dataModel.avaterColor = colors[2];
            dataModel.name = "name" + i;
            dataModel.content = "contant" + i;
            dataModel.contentColor = colors[2];
            list3.add(dataModel);
        }
        adapter.addList(list1, list2, list3);
        adapter.notifyDataSetChanged();
    }
}
