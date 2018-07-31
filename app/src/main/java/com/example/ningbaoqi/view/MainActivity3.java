package com.example.ningbaoqi.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
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
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int type;
            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i < 10 || i > 26) {
                type = 2;
            } else {
                type = 3;
            }
            DataModel dataModel = new DataModel();
            dataModel.avaterColor = colors[type - 1];
            dataModel.type = type;
            dataModel.name = "name" + type;
            dataModel.content = "content" + i;
            dataModel.contentColor = colors[(type + 1) % 3];
            list.add(dataModel);
        }
        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }
}
