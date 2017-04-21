package com.jiju.chat.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by PC on 2017/4/12.
 */

@Module
public class ApiModule {


    @Singleton
    @Provides
     OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true); // 失败重发
//                .addInterceptor(new HeaderInterceptor())
//                .addInterceptor(logging);
        return builder.build();
    }

}
