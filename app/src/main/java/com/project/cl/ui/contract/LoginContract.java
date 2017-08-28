package com.project.cl.ui.contract;

import com.project.cl.base.BaseContract;

/**
 * Created by PC on 2017/4/12.
 */

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void onClearText();

        void onLoginResult(Boolean result, int code);

        void showDia(boolean flag);

        void serErrorForEmail(boolean flag);

        void serErrorForPass(boolean flag);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login(String name, String passWord);

        void clearStr();

        void showDia(boolean flag);
    }

}
