package com.jiju.chat.component;


import com.jiju.chat.ui.activity.LoginActivity;
import com.jiju.chat.ui.activity.MainActivity;
import com.jiju.chat.ui.activity.SplashActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    LoginActivity inject(LoginActivity activity);

    SplashActivity inject(SplashActivity activity);
    MainActivity inject(MainActivity activity);
}
