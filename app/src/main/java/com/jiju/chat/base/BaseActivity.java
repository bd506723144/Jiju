package com.jiju.chat.base;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiju.chat.JiJUApp;
import com.jiju.chat.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by PC on 2017/4/12.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        ((JiJUApp)getApplication()).getAppComponent().inject(this);
        setupActivityComponent(JiJUApp.getsInstance().getAppComponent());
        initToolBar();
        initData();
        configViews();
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    /**
     * activity布局
     */
    public abstract int getLayoutId();

    /**
     * toolbar
     */
    public abstract void initToolBar();

    /**
     * 初始数据
     */
    public abstract void initData();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();

    /**
     * 隐藏View
     *
     * @param views
     */
    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    /**
     * 显示View
     *
     * @param views
     */
    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    protected boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }


    protected void doError(int code) {
        switch (code) {
            case 1001:

                break;
        }
    }
}
