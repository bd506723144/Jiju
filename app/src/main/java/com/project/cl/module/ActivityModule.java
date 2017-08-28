package com.project.cl.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PC on 2017/4/25.
 */

@Module
public class ActivityModule {

    private final Activity mView;

    public ActivityModule(Activity view) {
        mView = view;
    }

    @Provides
    Activity provideActivity() {
        return mView;
    }
}
