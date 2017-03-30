package com.example.zy1584.myzhihudaily.ui.main.menu;

import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.http.subscriber.CommonSubscriber;
import com.example.zy1584.myzhihudaily.http.transformer.CommonTransformer;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;

import rx.Subscription;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class ThemesPresenter extends BasePresenter<MenuFragment> implements ThemesContract.Presenter{

    @Override
    public void getThemes() {
        Subscription subscribe = new ThemesBiz().getThemes().compose(new CommonTransformer<ThemesBean>
                ()).subscribe(new CommonSubscriber<ThemesBean>(getIView().getContext(), false,
                true) {
            @Override
            public void onNext(ThemesBean bean) {
                getIView().onSuccess(bean);
            }
        });
        addSubscription(subscribe);
    }
}
