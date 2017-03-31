package com.example.zy1584.myzhihudaily.ui.main.otherStories.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesHeader implements BaseItem {
    private final String url;
    private final String description;

    public OtherStoriesHeader(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
