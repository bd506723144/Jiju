package com.jiju.chat.api;

import com.jiju.chat.been.Test;
import com.jiju.chat.been.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by PC on 2017/4/25.
 */

public interface JiJuApiService {

    @GET("/v2/book/1220562")
    Observable<Test> getUserInfo();
}
