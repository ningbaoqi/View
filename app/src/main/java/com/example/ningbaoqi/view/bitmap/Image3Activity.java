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

public class Image3Activity extends AppCompatActivity {

    private Bitmap copyBitmap;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image3);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.awaiyi);
        copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Paint paint = new Paint();
        final Canvas canvas = new Canvas(copyBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        imageView = (ImageView) findViewById(R.id.waiyi);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        for (int i = -15; i < 15; i++) {
                            for (int j = -15; j < 15; j++) {
                                if (Math.sqrt(i * i + j * j) <= 15) {
                                    if (x + i < copyBitmap.getWidth() && y + j < copyBitmap.getHeight() && x + i >= 0 && y + j >= 0) {
                                        /**
                                         * 把指定的像素颜色设置为透明
                                         * */
                                        copyBitmap.setPixel(x + i, y + j, Color.TRANSPARENT);
                                        imageView.setImageBitmap(copyBitmap);
                                    }
                                }
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }
}
