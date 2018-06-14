package com.example.ningbaoqi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout username_layout;
    private TextInputLayout password_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textinputlayout);
        username_layout = ((TextInputLayout) findViewById(R.id.tl_username));
        password_layout = ((TextInputLayout) findViewById(R.id.tl_password));
    }

    private boolean validatePassword(String password) {
        return password.length() > 0;
    }

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private boolean validateUsername(String username) {
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    /**
     * setErrorEnabled(true)用于显示和隐藏错误提示 setError设置错误信息
     *
     * @param view
     */
    public void login(View view) {
        String username = username_layout.getEditText().getText().toString();
        String password = password_layout.getEditText().getText().toString();
        if (!validateUsername(username)) {
            username_layout.setErrorEnabled(true);
            username_layout.setError("请输入正确的邮箱地址");
        } else if (!validatePassword(password)) {
            password_layout.setErrorEnabled(true);
            password_layout.setError("密码字数过少");
        } else {
            username_layout.setErrorEnabled(false);
            password_layout.setErrorEnabled(false);
            Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_LONG).show();
        }
    }
}
