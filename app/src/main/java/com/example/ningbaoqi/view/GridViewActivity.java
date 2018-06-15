package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {
    String[] texts = new String[]{"手机防盗", "通讯卫士", "软件管理", "进程管理", "流量控制", "手机杀毒", "缓存清理", "高级工具"};
    int[] images = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    List<Map<String, Object>> maps = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        for (int i = 0; i < texts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", images[i]);
            map.put("text", texts[i]);
            maps.add(map);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        SimpleAdapter adapter = new SimpleAdapter(this, maps, R.layout.gridview_item_layout, new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, texts[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
