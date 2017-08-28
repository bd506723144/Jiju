package com.project.cl.module;

import com.project.cl.api.JiJuApi;
import com.project.cl.app.util.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by PC on 2017/4/12.
 */

@Module
public class ApiModule {

    @Provides
     OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor());
//                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected JiJuApi provideJiJuService(OkHttpClient okHttpClient) {
        return JiJuApi.getInstance(okHttpClient);
    }

}
