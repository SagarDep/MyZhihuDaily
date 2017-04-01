package com.example.zy1584.myzhihudaily.ui.newsDetail;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-4-1.
 */

public class StoryContentPresenter extends BasePresenter<StoryContentActivity> implements StoryContentContract.Presenter {

    @Override
    public void getStoryContent(int id) {
        Subscription subscribe = new StoryContentBiz().getStoryContent(id).compose(new
                CommonTransformer<StoryContentBean>()).subscribe(new CommonSubscriber<StoryContentBean>(getIView(), true, true) {
            @Override
            public void onNext(StoryContentBean bean) {
                getIView().getStoryContent(bean);
            }
        });
        addSubscription(subscribe);
    }

    @Override
    public void getStoryContentExtra(int id) {
        Subscription subscribe = new StoryContentBiz().getStoryContentExtra(id).compose(new
                CommonTransformer<StoryContentExtraBean>()).subscribe(new CommonSubscriber<StoryContentExtraBean>() {
            @Override
            public void onNext(StoryContentExtraBean bean) {
                getIView().getStoryContentExtra(bean);
            }
        });
        addSubscription(subscribe);
    }
}
