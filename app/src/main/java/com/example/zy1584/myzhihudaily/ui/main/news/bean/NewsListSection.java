package com.example.zy1584.myzhihudaily.ui.main.news.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.utils.MyUtils;

/**
 * Created by OO on 2017/2/14.
 */

public class NewsListSection implements BaseItem {
    private final String date;

    public NewsListSection(String date) {
        this.date = date;
    }

    public String getDate() {
        if (date == null) {
            return null;
        }
        return MyUtils.formatDate(date);
    }
}
