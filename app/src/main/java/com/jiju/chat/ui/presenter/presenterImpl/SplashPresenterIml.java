package com.jiju.chat.ui.presenter.presenterImpl;

import com.jiju.chat.api.JiJuApi;
import com.jiju.chat.base.RxPresenter;
import com.jiju.chat.ui.contract.SplashContract;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

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
            Observable.timer(4, TimeUnit.SECONDS)
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onCompleted() {
                            mView.showMsgText("123");
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        public void onNext(Long number) {

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
