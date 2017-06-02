package com.jiju.chat.api;

import com.jiju.chat.been.Test;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by PC on 2017/4/25.
 */

public interface JiJuApiService {

    @GET("/v2/book/1220562")
    Observable<Test> getUserInfo();
    @GET("/v2/book/1220562")
    Call<Test> getUserInfos();
}
