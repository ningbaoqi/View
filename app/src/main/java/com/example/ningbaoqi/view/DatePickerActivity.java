package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_picker_layout);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Toast.makeText(this, year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
        setTitle(year + "-" + month + "-" + day);
        DatePicker datePicker = (DatePicker) findViewById(R.id.dataPicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {//需要进行初始化然后设置监听器
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year + "-" + monthOfYear + "-" + dayOfMonth);
            }
        });
    }

}
