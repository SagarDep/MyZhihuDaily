package com.example.zy1584.myzhihudaily.ui.launch;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;

import rx.Subscription;


/**
 * Created by zy1584 on 2017-3-30.
 */

public class SplashPresenter extends BasePresenter<SplashActivity> implements LaunchContract.Presenter {

    @Override
    public void getLaunchImage() {
        Subscription subscribe = new SplashBiz().getLaunchImage().compose(new
                CommonTransformer<LaunchImageBean>()).subscribe(new CommonSubscriber<LaunchImageBean>(getIView(), false, true) {
            @Override
            public void onNext(LaunchImageBean bean) {
                getIView().onSuccess(bean);
                getIView().requestEnd();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getIView().requestEnd();
            }
        });
        addSubscription(subscribe);
    }

}
