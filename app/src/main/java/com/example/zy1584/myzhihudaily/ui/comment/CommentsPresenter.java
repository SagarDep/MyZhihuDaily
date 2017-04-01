package com.example.zy1584.myzhihudaily.ui.comment;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-4-1.
 */

public class CommentsPresenter extends BasePresenter<CommentsActivity> implements CommentsContract.Presenter {
    @Override
    public void getStoryContentLongComments(int id) {
        Subscription subscribe = new CommentsBiz().getStoryContentLongComments(id).compose(new
                CommonTransformer<StoryCommentsBean>()).subscribe(new CommonSubscriber<StoryCommentsBean>(getIView(), true, true) {
            @Override
            public void onNext(StoryCommentsBean bean) {
                getIView().getStoryContentLongComments(bean);
            }
        });
        addSubscription(subscribe);
    }

    @Override
    public void getStoryContentShortComments(int id) {
        Subscription subscribe = new CommentsBiz().getStoryContentShortComments(id).compose(new
                CommonTransformer<StoryCommentsBean>()).subscribe(new CommonSubscriber<StoryCommentsBean>(getIView(), true, true) {
            @Override
            public void onNext(StoryCommentsBean bean) {
                getIView().getStoryContentShortComments(bean);
            }
        });
        addSubscription(subscribe);
    }
}
