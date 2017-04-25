package com.jiju.chat.component;

import android.content.Context;

import com.jiju.chat.api.JiJuApi;
import com.jiju.chat.module.ApiModule;
import com.jiju.chat.module.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class,ApiModule.class})
public interface AppComponent {

    Context getContext();

    JiJuApi getReaderApi();

}