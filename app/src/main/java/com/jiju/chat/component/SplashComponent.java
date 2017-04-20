package com.jiju.chat.component;

import com.jiju.chat.module.SplashModule;
import com.jiju.chat.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by PC on 2017/4/20.
 */


@Component(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
