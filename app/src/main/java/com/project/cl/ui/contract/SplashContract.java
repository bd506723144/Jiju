package com.project.cl.ui.contract;

import com.project.cl.base.BaseContract;

/**
 * Created by PC on 2017/4/12.
 */

public interface SplashContract {
    interface View extends BaseContract.BaseView {
        void showMsgText(String flag);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void jumpMain(boolean flag);
        void showMsg(String flag);
    }

}
