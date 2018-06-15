package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MultiAutoCompleteTextViewActivity extends AppCompatActivity {
    private String[] res = new String[]{"beijing", "beijing2", "shanghai2", "shanghga1", "dajsl;dad"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi);
        MultiAutoCompleteTextView muti = (MultiAutoCompleteTextView) findViewById(R.id.multi);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, res);
        /**
         * 设置逗号分隔符
         * */
        muti.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        muti.setAdapter(adapter);
    }
}
