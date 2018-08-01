package com.example.ningbaoqi.view.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Image1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image1);
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        /**
         * 这个bitmap是只读的，无法做修改
         * */
        Bitmap bitmapSrc = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        /**
         * 创建图片副本，在内存中创建一个与原图一模一样大小的bitmap对象，这个 bitmap_copy 是可读可写的
         * */
        Bitmap bitmapCopy = Bitmap.createBitmap(bitmapSrc.getWidth(), bitmapSrc.getHeight(), bitmapSrc.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bitmapCopy);
        canvas.drawBitmap(bitmapSrc, new Matrix(), paint);
        canvas.drawLine(20, 20, 80, 80, paint);
        iv_src.setImageBitmap(bitmapSrc);
        iv_copy.setImageBitmap(bitmapCopy);
    }
}
