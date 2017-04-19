package com.jiju.chat.module;

import com.jiju.chat.ui.activity.LoginActivity;
import com.jiju.chat.ui.contract.LoginContract;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by PC on 2017/4/19.
 */


@Module
public class LoginModule {
    private  final  LoginActivity mView;

    public LoginModule(LoginActivity view) {
        mView = view;
    }

    @Provides
    LoginActivity provideMainView() {
        return mView;
    }
}
