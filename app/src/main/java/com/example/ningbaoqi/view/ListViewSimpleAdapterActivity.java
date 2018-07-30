package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewSimpleAdapterActivity extends AppCompatActivity {
    private ListView listView;
    String[] texts = new String[]{"手机防盗", "通讯卫士", "软件管理", "进程管理", "流量控制", "手机杀毒", "缓存清理", "高级工具"};
    int[] images = new int[]{R.mipmap.home_apps, R.mipmap.home_callmsgsafe, R.mipmap.home_netmanager, R.mipmap.home_safe,
            R.mipmap.home_settings, R.mipmap.home_sysoptimize, R.mipmap.home_taskmanager, R.mipmap.home_tools};
    List<Map<String, Object>> maps = new ArrayList<>();
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        listView = (ListView) findViewById(R.id.listview);
        for (int i = 0; i < 6; i++) {
            initData();
        }
        useSimpleAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewSimpleAdapterActivity.this, texts[position % texts.length], Toast.LENGTH_LONG).show();
            }
        });
    }

    private void useSimpleAdapter() {
        adapter = new SimpleAdapter(this, maps, R.layout.listview_item_layout, new String[]{"image", "text"}, new int[]{R.id.imageview, R.id.text});
    }

    private void initData() {
        for (int i = 0; i < texts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", images[i]);
            map.put("text", texts[i]);
            maps.add(map);
        }
    }
}
