package com.jiju.chat.ui.contract;

import com.jiju.chat.base.BaseContract;

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
