package com.jiju.chat.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 2017/4/25.
 */

public class JiJuApi {

    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";
    private JiJuApiService service;

    public static JiJuApi instance;

    public JiJuApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();

        service = retrofit.create(JiJuApiService.class);
    }

    public static JiJuApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new JiJuApi(okHttpClient);
        return instance;
    }
}
