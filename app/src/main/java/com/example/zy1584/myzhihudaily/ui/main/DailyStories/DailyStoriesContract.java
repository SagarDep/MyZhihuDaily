package com.example.zy1584.myzhihudaily.ui.main.dailyStories;

import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesBean;

/**
 * Created by zy1584 on 2017-3-30.
 */

public interface DailyStoriesContract {

    interface View {

        void onLoadLatestNewsSuccess(DailyStoriesBean bean);

        void onLoadBeforeNewsSuccess(DailyStoriesBean bean);

        void onError();

    }

    interface Presenter {

        void getLatestNews();

        void getBeforeNews(String date);

    }
}
