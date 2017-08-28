package com.project.cl.component;

import android.content.Context;

import com.project.cl.api.JiJuApi;
import com.project.cl.module.ApiModule;
import com.project.cl.module.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class,ApiModule.class})
public interface AppComponent {

    Context getContext();

    JiJuApi getReaderApi();

}