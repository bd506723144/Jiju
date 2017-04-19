package com.jiju.chat.component;

import com.jiju.chat.module.LoginModule;
import com.jiju.chat.ui.activity.LoginActivity;
import com.jiju.chat.ui.contract.LoginContract;

import dagger.Component;

/**
 * Created by PC on 2017/4/19.
 */


@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
