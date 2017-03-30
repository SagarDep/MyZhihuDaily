package com.example.zy1584.myzhihudaily.ui.main.news.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;

import java.util.List;

/**
 * Created by OO on 2017/2/15.
 */

public class NewsListHeader implements BaseItem {
    private final List<NewsLatestBean.TopStoriesBean> mTopStories;

    public NewsListHeader(List<NewsLatestBean.TopStoriesBean> topStories) {
        mTopStories = topStories;
    }


    public List<NewsLatestBean.TopStoriesBean> getTopStories() {
        return mTopStories;
    }

}
