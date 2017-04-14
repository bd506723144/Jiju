package com.jiju.chat.ui.contract;

/**
 * Created by PC on 2017/4/12.
 */

public interface LoginContract {
    interface View {
        void onClearText();

        void onLoginResult(Boolean result, int code);

        void showDia(boolean flag);

        void serErrorForEmail(boolean flag);

        void serErrorForPass(boolean flag);
    }

    interface Presenter {
        void login(String name, String passWord);

        void clearStr();

        void showDia(boolean flag);
    }

}
