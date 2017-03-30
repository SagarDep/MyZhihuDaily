package com.example.zy1584.myzhihudaily.ui.launch;

import com.example.zy1584.myzhihudaily.base.BaseModel;

import rx.Observable;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class SplashBiz extends BaseModel {

    public Observable<LaunchImageBean> getLaunchImage(){
        return httpService.getLaunchImage();
    }
}
