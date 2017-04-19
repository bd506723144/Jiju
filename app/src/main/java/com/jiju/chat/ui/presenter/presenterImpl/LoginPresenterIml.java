package com.jiju.chat.ui.presenter.presenterImpl;

import android.os.Handler;
import android.text.TextUtils;

import com.jiju.chat.ui.activity.LoginActivity;
import com.jiju.chat.ui.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by PC on 2017/4/12.
 */

public class LoginPresenterIml implements LoginContract.Presenter {


    private LoginActivity loginActivity;

    @Inject
    public LoginPresenterIml(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        initUser();
    }

    private void initUser() {

    }


    @Override
    public void login(String email, String password) {
        showDia(true);
        boolean cancel = false;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            cancel = true;
            loginActivity.serErrorForPass(true);
            showDia(false);
        }
        if (TextUtils.isEmpty(email)) {
            cancel = true;
            loginActivity.serErrorForEmail(true);
            showDia(false);
        } else if (!isEmailValid(email)) {
            cancel = true;
            loginActivity.serErrorForEmail(true);
            showDia(false);
        }
        if (cancel) {
            showDia(false);
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginActivity.onLoginResult(false, 1001);
                showDia(false);
            }
        }, 2000);

    }

    @Override
    public void clearStr() {
        loginActivity.onClearText();
    }

    @Override
    public void showDia(boolean flag) {
        loginActivity.showDia(flag);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
