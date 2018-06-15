package com.example.ningbaoqi.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class GalleryAndImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{
    private int[] resId = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        Gallery gallery = (Gallery) findViewById(R.id.gullary);
        final ImageSwitcher switcher = (ImageSwitcher) findViewById(R.id.switcher);
        switcher.setFactory(this);
        MyAdapter adapter = new MyAdapter(resId, this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switcher.setBackgroundResource(resId[position % resId.length]);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }
    class MyAdapter extends BaseAdapter {
        private int[] resID;
        private Context context;
        public MyAdapter(int[] resID, Context context) {
            this.resID = resID;
            this.context = context;
        }
        public int getCount() {
            return Integer.MAX_VALUE;
        }
        public Object getItem(int position) {
            return resID[position];
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(resID[position % resID.length]);
            imageView.setLayoutParams(new Gallery.LayoutParams(400, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }
    }
}
