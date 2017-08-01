package com.jiju.chat;

import com.blankj.utilcode.utils.Utils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
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
        initIM();
    }

    private void initIM() {
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        //初始化
        EMClient.getInstance().init(getApplicationContext(), options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

        options.setAcceptInvitationAlways(false);
        EaseUI.getInstance().init(getApplicationContext(), options);



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
