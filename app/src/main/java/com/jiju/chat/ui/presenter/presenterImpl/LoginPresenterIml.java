package com.jiju.chat.ui.presenter.presenterImpl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.utils.LogUtils;
import com.jiju.chat.api.JiJuApi;
import com.jiju.chat.app.util.MyUtil;
import com.jiju.chat.base.RxPresenter;
import com.jiju.chat.been.Test;
import com.jiju.chat.been.User;
import com.jiju.chat.ui.contract.LoginContract;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            cancel = true;
            mView.serErrorForPass(true);
        }
        if (TextUtils.isEmpty(email)) {
            cancel = true;
            mView.serErrorForEmail(true);
        } else if (!isEmailValid(email)) {
            cancel = true;
            mView.serErrorForEmail(true);
        }
        if (cancel) {
            showDia(false);
            return;
        }
        Subscription rxSubscription = jiJuApi.getUserInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Test>() {
                    @Override
                    public void onCompleted() {
                        showDia(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showDia(false);
                        LogUtils.e(""+e.toString());
                    }

                    @Override
                    public void onNext(Test data) {
                        if (data != null && mView != null) {
                            mView.onLoginResult(true,100);
                        }
                    }
                });
        addSubscrebe(rxSubscription);
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
