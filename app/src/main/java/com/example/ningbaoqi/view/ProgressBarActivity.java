package com.example.ningbaoqi.view;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private android.widget.ProgressBar progressBar;
    private Button add;
    private Button reduce;
    private TextView textView;
    private int max;
    private Button dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgress(8888);
        setContentView(R.layout.progress_bar_layout);
        initUI();
    }

    private void initUI() {
        progressBar = (android.widget.ProgressBar) findViewById(R.id.progress1);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.text);
        int first = progressBar.getProgress();
        int second = progressBar.getSecondaryProgress();
        max = progressBar.getMax();
        textView.setText("第一进度条百分比:" + (int) (first / (float) max * 100) + "% 第二进度条百分比:" + (int) (second / (float) max * 100) + "%");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.reduce:
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;
            case R.id.dialog:
                toastDialog();
                return;
        }
        textView.setText("第一进度条百分比:" + (int) (progressBar.getProgress() / (float) max * 100) + "% 第二进度条百分比:" + (int) (progressBar.getSecondaryProgress() / (float) max * 100) + "%");
    }

    private void toastDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("大帅哥");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("欢迎来看大帅哥");
        dialog.setMax(100);
        dialog.incrementProgressBy(50);
        dialog.setIndeterminate(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ProgressBarActivity.this, "傻逼", Toast.LENGTH_LONG).show();
            }
        });
        dialog.setCancelable(true);
        dialog.show();
    }
}

