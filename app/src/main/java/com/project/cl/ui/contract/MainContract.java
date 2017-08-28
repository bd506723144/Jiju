package com.project.cl.ui.contract;

import com.project.cl.base.BaseContract;

/**
 * Created by PC on 2017/4/28.
 */

public class MainContract {
    interface View extends BaseContract.BaseView {
        void refreshChatList();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void refreshData();
    }
}
