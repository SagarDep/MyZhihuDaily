package com.example.zy1584.myzhihudaily.ui.main.news;

import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsBeforeBean;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsLatestBean;

/**
 * Created by zy1584 on 2017-3-30.
 */

public interface NewsContract {

    interface View {

        void onLoadLatestNewsSuccess(NewsLatestBean bean);

        void onLoadBeforeNewsSuccess(NewsBeforeBean bean);

    }

    interface Presenter {

        void getLatestNews();

        void getBeforeNews(String date);

    }
}
