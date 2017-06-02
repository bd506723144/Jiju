package com.jiju.chat.base;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;
    protected CompositeDisposable mCompositeSubscription;
    public final static String TAG = "jiju";


    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.dispose();
        }
    }

    protected void addSubscrebe(Disposable subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }
        mCompositeSubscription.add(subscription);

    }



    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
