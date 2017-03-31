package com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.utils.MyUtils;

/**
 * Created by OO on 2017/2/14.
 */

public class DailyStoriesSection implements BaseItem {
    private final String date;

    public DailyStoriesSection(String date) {
        this.date = date;
    }

    public String getDate() {
        if (date == null) {
            return null;
        }
        return MyUtils.formatDate(date);
    }
}
