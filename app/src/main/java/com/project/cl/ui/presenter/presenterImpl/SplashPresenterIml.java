package com.project.cl.ui.presenter.presenterImpl;

import com.project.cl.api.JiJuApi;
import com.project.cl.base.RxPresenter;
import com.project.cl.ui.contract.SplashContract;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by PC on 2017/4/20.
 */

public class SplashPresenterIml extends RxPresenter<SplashContract.View> implements SplashContract.Presenter<SplashContract.View> {

    private JiJuApi jiJuApi;

    @Inject
    public SplashPresenterIml(JiJuApi jiJuApi) {
        this.jiJuApi = jiJuApi;
    }


    @Override
    public void jumpMain(boolean flag) {
        if (flag) {
            Observable.timer(3, TimeUnit.SECONDS)
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull Long aLong) {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            mView.showMsgText("123");
                        }
                    });

        }else{
            mView.showMsgText("123");
        }
    }

    @Override
    public void showMsg(String flag) {

    }
}
