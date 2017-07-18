package com.jiju.chat.ui.presenter.presenterImpl;

import android.text.TextUtils;
import android.util.Log;

import com.jiju.chat.api.JiJuApi;
import com.jiju.chat.base.RxPresenter;
import com.jiju.chat.ui.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

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
        mView.onLoginResult(true, 1);
        Observer<Object> testObservable = new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Object integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");

            }
        };
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
//        return email.contains("@") && email.contains(".");
        return true;
    }

}
