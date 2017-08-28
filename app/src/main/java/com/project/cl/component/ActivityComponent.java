package com.project.cl.component;


import com.project.cl.ui.activity.LoginActivity;
import com.project.cl.ui.activity.MainActivity;
import com.project.cl.ui.activity.SplashActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    LoginActivity inject(LoginActivity activity);

    SplashActivity inject(SplashActivity activity);
    MainActivity inject(MainActivity activity);
}
