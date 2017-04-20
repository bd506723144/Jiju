package com.jiju.chat.module;

import com.jiju.chat.ui.activity.SplashActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PC on 2017/4/20.
 */

@Module
public class SplashModule {
    private final SplashActivity mView;

    public SplashModule(SplashActivity view) {
        mView = view;
    }

    @Provides
    SplashActivity provideSplashActivity() {
        return mView;
    }
}