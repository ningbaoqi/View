package com.example.ningbaoqi.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5;
    private String[] strings;
    private boolean[] isChecked;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        strings = new String[]{"adadsadas", "ahdhaodhasdasodgsio", "hiaoshfoiafoah"};
        isChecked = new boolean[]{false, true, false};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                new AlertDialog.Builder(this).setTitle("显示确认对话框").setIcon(R.mipmap.ic_launcher).setMessage("显示确认对话框内容").
                        setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "确认", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_LONG).show();
                    }
                }).create().show();
                break;
            case R.id.btn2:
                AlertDialog dialog = new AlertDialog.Builder(this).setTitle("显示单选对话框").setIcon(R.mipmap.ic_launcher).setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, strings[which], Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                }).create();
                dialog.show();
                break;
            case R.id.btn3:
                AlertDialog dialog1 = new AlertDialog.Builder(this).setTitle("显示多选对话框").setIcon(R.mipmap.ic_launcher).setMultiChoiceItems(strings, isChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(DialogActivity.this, strings[which], Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
                dialog1.show();
                break;
            case R.id.btn4:
                new AlertDialog.Builder(this).setTitle("显示列表对话框").setIcon(R.mipmap.ic_launcher).setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, strings[which], Toast.LENGTH_LONG).show();
                    }
                }).create().show();
                break;
            case R.id.btn5:
                new AlertDialog.Builder(this).setView(View.inflate(DialogActivity.this, R.layout.activity_main, null)).
                        setTitle("显示自定义对话框").setIcon(R.mipmap.ic_launcher).create().show();
                break;
        }
    }
}

