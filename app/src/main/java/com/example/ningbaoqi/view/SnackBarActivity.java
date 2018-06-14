package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SnackBarActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CALL_PHONE = 1;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar);
        relativeLayout = findViewById(R.id.re);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackBar();
            }
        });
    }

    //    relativeLayout参数表示SnackBar的父控件
    private void showSnackBar() {
        Snackbar.make(relativeLayout, "标题", Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActivity.this, "Toast", Toast.LENGTH_LONG).show();
            }
        }).setDuration(Snackbar.LENGTH_LONG).show();
    }

}
