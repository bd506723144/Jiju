package com.jiju.chat;

import com.blankj.utilcode.utils.Utils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.FirebaseApp;
import com.jiju.chat.base.BaseApplication;
import com.jiju.chat.component.AppComponent;
import com.jiju.chat.component.DaggerAppComponent;
import com.jiju.chat.module.AppModule;

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
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        FirebaseApp.initializeApp(getApplicationContext());

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
