package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewBaseAdapterActivity extends AppCompatActivity {
    private ListView listView;
    String[] texts = new String[]{"手机防盗", "通讯卫士", "软件管理", "进程管理", "流量控制", "手机杀毒", "缓存清理", "高级工具", "手机防盗", "通讯卫士", "软件管理", "进程管理", "流量控制", "手机杀毒", "缓存清理", "高级工具"};
    int[] images = new int[]{R.mipmap.home_apps, R.mipmap.home_callmsgsafe, R.mipmap.home_netmanager, R.mipmap.home_settings, R.mipmap.home_sysoptimize, R.mipmap.home_taskmanager, R.mipmap.home_tools, R.mipmap.home_apps, R.mipmap.home_callmsgsafe, R.mipmap.home_netmanager, R.mipmap.home_safe, R.mipmap.home_safe, R.mipmap.home_settings, R.mipmap.home_sysoptimize, R.mipmap.home_taskmanager, R.mipmap.home_tools};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(ListViewBaseAdapterActivity.this, R.layout.listview_item, null);
                //                LayoutInflater layoutInflater = LayoutInflater.from(ListViewBaseAdapterActivity.this);
                //                View view = layoutInflater.inflate(R.layout.listview_item, null);
                //                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //                View view = layoutInflater.inflate(R.layout.listview_item, null);
                viewHolder.imageView = convertView.findViewById(R.id.image);//findViewById耗时也很严重
                viewHolder.textView = convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.imageView.setImageResource(images[position]);
            viewHolder.textView.setText(texts[position]);
            return convertView;
        }
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}