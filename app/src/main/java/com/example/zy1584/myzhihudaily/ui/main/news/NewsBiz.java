package com.example.zy1584.myzhihudaily.ui.main.news;

import com.example.zy1584.myzhihudaily.base.BaseModel;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsBeforeBean;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsLatestBean;

import rx.Observable;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class NewsBiz extends BaseModel {

    public Observable<NewsLatestBean> getLatestNews(){
        return httpService.getLatestNews();
    }

    public Observable<NewsBeforeBean> getBeforeNews(String date){
        return httpService.getBeforeNews(date);
    }
}
