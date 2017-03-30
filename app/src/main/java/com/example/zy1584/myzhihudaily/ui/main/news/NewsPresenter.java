package com.example.zy1584.myzhihudaily.ui.main.news;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsBeforeBean;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsLatestBean;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class NewsPresenter extends BasePresenter<NewsFragment> implements NewsContract.Presenter {


    @Override
    public void getLatestNews() {
        Subscription subscribe = new NewsBiz().getLatestNews().compose(new
                CommonTransformer<NewsLatestBean>()).subscribe(new CommonSubscriber<NewsLatestBean>(getIView().getContext()) {
            @Override
            public void onNext(NewsLatestBean bean) {
                getIView().onLoadLatestNewsSuccess(bean);
            }
        });
        addSubscription(subscribe);
    }

    @Override
    public void getBeforeNews(String date) {
        Subscription subscribe = new NewsBiz().getBeforeNews(date).compose(new
                CommonTransformer<NewsBeforeBean>()).subscribe(new CommonSubscriber<NewsBeforeBean>(getIView().getContext()) {
            @Override
            public void onNext(NewsBeforeBean newsBeforeBean) {
                getIView().onLoadBeforeNewsSuccess(newsBeforeBean);
            }
        });
        addSubscription(subscribe);
    }
}
