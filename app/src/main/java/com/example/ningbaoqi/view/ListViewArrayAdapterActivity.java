package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewArrayAdapterActivity extends AppCompatActivity {
    private ListView listView;
    String[] texts = new String[]{"手机防盗", "通讯卫士", "软件管理", "进程管理", "流量控制", "手机杀毒", "缓存清理", "高级工具"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(texts);
        adapter.addAll(texts);
        listView.setAdapter(adapter);
    }
}