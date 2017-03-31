package com.example.zy1584.myzhihudaily.ui.main.dailyStories;

import com.example.zy1584.myzhihudaily.base.BaseModel;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesBean;

import rx.Observable;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class DailyStoriesBiz extends BaseModel {

    public Observable<DailyStoriesBean> getLatestNews(){
        return httpService.getLatestNews();
    }

    public Observable<DailyStoriesBean> getBeforeNews(String date){
        return httpService.getBeforeNews(date);
    }
}
