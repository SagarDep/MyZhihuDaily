package com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;

import java.util.List;

/**
 * Created by OO on 2017/2/15.
 */

public class DailyStoriesHeader implements BaseItem {
    private final List<DailyStoriesBean.TopStoriesBean> mTopStories;

    public DailyStoriesHeader(List<DailyStoriesBean.TopStoriesBean> topStories) {
        mTopStories = topStories;
    }


    public List<DailyStoriesBean.TopStoriesBean> getTopStories() {
        return mTopStories;
    }

}
