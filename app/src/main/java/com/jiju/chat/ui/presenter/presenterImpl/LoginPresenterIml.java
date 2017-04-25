package com.jiju.chat.ui.presenter.presenterImpl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.jiju.chat.api.JiJuApi;
import com.jiju.chat.base.RxPresenter;
import com.jiju.chat.ui.activity.LoginActivity;
import com.jiju.chat.ui.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by PC on 2017/4/12.
 */

public class LoginPresenterIml extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {


    private JiJuApi jiJuApi;

    @Inject
    public LoginPresenterIml(JiJuApi jiJuApi) {
        this.jiJuApi = jiJuApi;
        initUser();
    }

    private void initUser() {
    }


    @Override
    public void login(String email, String password) {
        showDia(true);
        boolean cancel = false;
        if(null == jiJuApi){

        }
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            cancel = true;
            mView.serErrorForPass(true);
            showDia(false);
        }
        if (TextUtils.isEmpty(email)) {
            cancel = true;
            mView.serErrorForEmail(true);
            showDia(false);
        } else if (!isEmailValid(email)) {
            cancel = true;
            mView.serErrorForEmail(true);
            showDia(false);
        }
        if (cancel) {
            showDia(false);
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.onLoginResult(false, 1001);
                showDia(false);
            }
        }, 2000);

    }

    @Override
    public void clearStr() {
        mView.onClearText();
    }


    @Override
    public void showDia(boolean flag) {
        mView.showDia(flag);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}
