package com.example.ningbaoqi.view.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class Image2Activity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private Bitmap bitmapCopy;
    private Paint paint;
    private Canvas canvas;
    private int startX;
    private int startY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image2);
        imageView = (ImageView) findViewById(R.id.paintBoard);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        bitmapCopy = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        paint = new Paint();
        canvas = new Canvas(bitmapCopy);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        imageView.setImageBitmap(bitmapCopy);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        canvas.drawLine(startX, startY, x, y, paint);
                        startY = y;
                        startX = x;
                        imageView.setImageBitmap(bitmapCopy);
                        break;
                }
                return true;
            }
        });
    }

    public void red(View view) {
        paint.setColor(Color.RED);
    }

    public void green(View view) {
        paint.setColor(Color.GREEN);
    }
    public void brush(View view) {
        paint.setStrokeWidth(20f);
    }

    /**
     * 保存图片并压缩
     */
    public void save(View view) {
        File file = new File(getExternalCacheDir() + "dazuo.png");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmapCopy.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
