package com.project.cl.ui.activity;

import android.content.Intent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.blankj.utilcode.utils.ToastUtils;
import com.jiju.chat.R;
import com.project.cl.base.BaseActivity;
import com.project.cl.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by PC on 2017/9/4.
 */

public class LoginActivityTest extends BaseActivity {

    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.email_sign_in_button)
    void onClick() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        if ("".equals(email)) {
            mEmailView.setError("账户错误");
            mEmailView.requestFocus();
            return;
        }
        if ("".equals(password)) {
            mPasswordView.setError("密码错误");
            mPasswordView.requestFocus();
            return;
        }
        if ("111".equals(email) && "222".equals(password)) {
            startActivity(new Intent(LoginActivityTest.this, MainActivity.class));
        } else {
            mPasswordView.setError("密码错误");
            mPasswordView.requestFocus();
        }
    }


    @Override
    public void initToolBar() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {

    }
}
