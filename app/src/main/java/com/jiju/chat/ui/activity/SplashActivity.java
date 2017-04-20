package com.jiju.chat.ui.activity;

import android.widget.ImageView;

import com.jiju.chat.R;
import com.jiju.chat.base.BaseActivity;
import com.jiju.chat.component.AppComponent;
import com.jiju.chat.component.DaggerSplashComponent;
import com.jiju.chat.module.SplashModule;
import com.jiju.chat.ui.presenter.presenterImpl.SplashPresenterIml;

import javax.inject.Inject;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {


    @Inject
    SplashPresenterIml splashPresenterIml;

    @BindView(R.id.backGround)
    ImageView imageView;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initData() {
        splashPresenterIml.showSplash("");
    }

    @Override
    public void configViews() {

    }
}
