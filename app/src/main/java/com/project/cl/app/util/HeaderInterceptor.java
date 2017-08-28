package com.project.cl.app.util;


import android.os.Build;

import com.blankj.utilcode.utils.DeviceUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PC on 2017/6/2.
 */

public final class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        String url = original.url().toString();
//        if (url.contains("book/") ||
//                url.contains("book-list/") ||
//                url.contains("toc/") ||
//                url.contains("post/") ||
//                url.contains("user/")) {
        Request request = original.newBuilder()
                .addHeader("userAgent", Build.DEVICE) // 不能转UTF-8
                .addHeader("userOs", "Android " + Build.MANUFACTURER)
                .addHeader("oSVersion", DeviceUtils.getAndroidID())
                .addHeader("appVersion",  Build.VERSION.RELEASE)//系统版本号
                .addHeader("agentModel",  "Android " + Build.MODEL)
                .addHeader("agentNum", "W/\"2a04-4nguJ+XAaA1yAeFHyxVImg\"")
                .build();
        return chain.proceed(request);
//    }
//        return chain.proceed(original);
    }
}
