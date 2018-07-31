package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DemoAdapter1 adapter;
    private int[] colors = {android.R.color.holo_blue_bright, android.R.color.holo_red_dark, android.R.color.holo_green_dark};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new DemoAdapter1(this);
        recyclerView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int type = (int) (Math.random() * 3) + 1;
            DataModel dataModel = new DataModel();
            dataModel.avaterColor = colors[type - 1];
            dataModel.type = type;
            dataModel.name = "name" + i;
            dataModel.content = "content" + i;
            dataModel.contentColor = colors[(type + 1) % 3];
            list.add(dataModel);
        }
        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }
}