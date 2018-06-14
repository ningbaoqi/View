package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);


        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        textView = (TextView) findViewById(R.id.text1);
        seekBar.setOnSeekBarChangeListener(this);
    }


    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textView.setText(progress + "");
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(SeekBarActivity.this, "start", Toast.LENGTH_LONG).show();
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(SeekBarActivity.this, "stop", Toast.LENGTH_LONG).show();
    }

}
