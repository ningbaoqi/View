package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {

    Button toast1, toast2, toast3;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast);
        toast1 = (Button) findViewById(R.id.toast1);
        toast2 = (Button) findViewById(R.id.toast2);
        toast3 = (Button) findViewById(R.id.toast3);
        toast1.setOnClickListener(this);
        toast2.setOnClickListener(this);
        toast3.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.toast1:
                Toast toast_1 = Toast.makeText(this, "改变Toast的位置", Toast.LENGTH_LONG);
                toast_1.setGravity(Gravity.CENTER, 100, 100);
                toast_1.show();
                break;
            case R.id.toast2:
                Toast toast_2 = Toast.makeText(this, "显示图片的toast", Toast.LENGTH_LONG);
                LinearLayout linearLayout = (LinearLayout) toast_2.getView();
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                linearLayout.addView(imageView, 0);
                toast_2.show();
                break;
            case R.id.toast3:
                Toast toast_3 = new Toast(this);
                toast_3.setView(View.inflate(this, R.layout.toast_layout, null));
                toast_3.show();
                break;
        }
    }
}
