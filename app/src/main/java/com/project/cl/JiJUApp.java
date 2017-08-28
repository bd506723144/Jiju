package com.project.cl;

import com.blankj.utilcode.utils.Utils;
import com.project.cl.base.BaseApplication;
import com.project.cl.component.AppComponent;
import com.project.cl.component.DaggerAppComponent;
import com.project.cl.module.AppModule;

/**
 * Created by PC on 2017/4/7.
 */

public class JiJUApp extends BaseApplication {

    private AppComponent appComponent;
    private static JiJUApp sInstance;


    @Override
    public void onCreate() {
        initComponent();
        super.onCreate();
        sInstance = this;
        Utils.init(getApplicationContext());
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static JiJUApp getsInstance() {
        return sInstance;
    }
}
