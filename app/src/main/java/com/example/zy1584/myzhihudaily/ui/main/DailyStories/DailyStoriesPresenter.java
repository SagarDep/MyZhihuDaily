package com.example.zy1584.myzhihudaily.ui.main.dailyStories;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesBean;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class DailyStoriesPresenter extends BasePresenter<DailyStoriesFragment> implements DailyStoriesContract.Presenter {


    @Override
    public void getLatestNews() {
        Subscription subscribe = new DailyStoriesBiz().getLatestNews().compose(new
                CommonTransformer<DailyStoriesBean>()).subscribe(new CommonSubscriber<DailyStoriesBean>() {
            @Override
            public void onNext(DailyStoriesBean bean) {
                getIView().onLoadLatestNewsSuccess(bean);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getIView().onError();
            }
        });
        addSubscription(subscribe);
    }

    @Override
    public void getBeforeNews(String date) {
        Subscription subscribe = new DailyStoriesBiz().getBeforeNews(date).compose(new
                CommonTransformer<DailyStoriesBean>())
                .subscribe(new CommonSubscriber<DailyStoriesBean>() {
            @Override
            public void onNext(DailyStoriesBean newsBeforeBean) {
                getIView().onLoadBeforeNewsSuccess(newsBeforeBean);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getIView().onError();
            }
        });
        addSubscription(subscribe);
    }
}
