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

        Observer<Object > testObservable = new Observer<Object >() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Object  integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
//                mView.onLoginResult(true, 1);
            }
        };
        Observable.zip(Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "emit A");
                emitter.onNext("A");
                Log.d(TAG, "emit B");
                emitter.onNext("B");
                Log.d(TAG, "emit C");
                emitter.onNext("C");
                Log.d(TAG, "emit D");
                emitter.onNext("D");
                Log.d(TAG, "emit complete2");
                emitter.onComplete();
            }
        }), Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
                Log.d(TAG, "emit 2");
                emitter.onNext(2);
                Log.d(TAG, "emit 3");
                emitter.onNext(3);
                Log.d(TAG, "emit complete1");
                emitter.onComplete();
            }
        }), new BiFunction<String, Integer, Object>() {
            @Override
            public Object apply(@NonNull String s, @NonNull Integer integer) throws Exception {

                return integer + s;
            }
        }).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(testObservable);
//        testObservable.subscribe(new Observer<Test>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                LogUtils.e("1233");
//            }
//
//            @Override
//            public void onNext(@NonNull Test testHttpResult) {
//                String string = testHttpResult.toString();
//                String binding = testHttpResult.getBinding();
//                LogUtils.e("1231");
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                LogUtils.e(e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//                LogUtils.e("123");
//            }
//        });
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
        return email.contains("@") && email.contains(".");
    }

}
