package com.example.ningbaoqi.view.a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ningbaoqi.view.R;

import java.util.ArrayList;
import java.util.List;

public class StaggerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private StaggerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();
        adapter = new StaggerAdapter(this, mDatas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));//设置布局管理器
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画
        adapter.setOnItemClickListener(new StaggerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }

            @Override
            public void onLongClickListener(View view, int position) {
                adapter.deleteData(position);
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycle);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                adapter.addData(1);
                break;
            case R.id.add:
                adapter.deleteData(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}