package com.jiju.chat.ui.presenter.presenterImpl;

import com.jiju.chat.ui.activity.SplashActivity;
import com.jiju.chat.ui.presenter.SplashPresenter;

import javax.inject.Inject;

/**
 * Created by PC on 2017/4/20.
 */

public class SplashPresenterIml implements SplashPresenter {

    SplashActivity splashActivity;

    @Inject
    public SplashPresenterIml(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Override
    public void showSplash(String path) {

    }

    @Override
    public void jumpPage(boolean flag) {

    }
}
