package com.example.zy1584.myzhihudaily.base;


import com.example.zy1584.myzhihudaily.http.exception.ApiException;

import rx.Subscriber;


/**
 * Created by tzqiang on 2017/3/29.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        ApiException apiException = (ApiException) e;
        onError(apiException);
    }


    /**
     * @param e 错误的一个回调
     */
    protected abstract void onError(ApiException e);

}
