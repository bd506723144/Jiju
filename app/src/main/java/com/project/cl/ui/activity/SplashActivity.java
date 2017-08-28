package com.project.cl.ui.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.jiju.chat.R;
import com.project.cl.base.BaseActivity;
import com.project.cl.component.AppComponent;
import com.project.cl.component.DaggerActivityComponent;
import com.project.cl.ui.contract.SplashContract;
import com.project.cl.ui.presenter.presenterImpl.SplashPresenterIml;

import javax.inject.Inject;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements SplashContract.View {


    @Inject
    SplashPresenterIml splashPresenterIml;

    @BindView(R.id.backGround)
    ImageView imageView;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initToolBar() {
        splashPresenterIml.jumpMain(true);

    }

    @Override
    public void initData() {
    }

    @Override
    public void configViews() {
        splashPresenterIml.attachView(this);
    }

    @Override
    public void showMsgText(String flag) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (splashPresenterIml != null) {
            splashPresenterIml.detachView();
        }
    }
}
