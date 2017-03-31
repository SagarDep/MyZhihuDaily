package com.example.zy1584.myzhihudaily.ui.main.otherStories;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-3-31.
 */

public class OtherStoriesPresenter extends BasePresenter<OtherStoriesFragment> implements OtherStoriesContract.Presenter {


    @Override
    public void getThemesContent(int id) {
        Subscription subscribe = new OtherStoriesBiz().getThemesContent(id).compose(new
                CommonTransformer<OtherStoriesBean>()).subscribe(new CommonSubscriber<OtherStoriesBean>() {
            @Override
            public void onNext(OtherStoriesBean bean) {
                getIView().getThemesContent(bean);
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
    public void getBeforeThemesContent(int id, int story_id) {
        Subscription subscribe = new OtherStoriesBiz().getBeforeThemesContent(id, story_id)
                .compose(new CommonTransformer<OtherStoriesBean>()).subscribe(new CommonSubscriber<OtherStoriesBean>() {
            @Override
            public void onNext(OtherStoriesBean bean) {
                getIView().getBeforeThemesContent(bean);
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
