package com.project.cl.HttpException;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by PC on 2017/5/24.
 */

public class ServerResponseFunc<T> implements Function<Throwable, Observable<T>> {


    public ServerResponseFunc() {
    }

    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        return null;
    }
}
