package com.jiju.chat.ui.presenter;

/**
 * Created by PC on 2017/4/12.
 */

public interface  LoginPresenter {
    void login(String name,String passWord);
    void clearStr();
    void showDia(boolean flag);
}
