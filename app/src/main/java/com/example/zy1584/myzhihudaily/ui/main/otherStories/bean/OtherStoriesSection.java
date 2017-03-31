package com.example.zy1584.myzhihudaily.ui.main.otherStories.bean;


import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesBean.EditorsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OO on 2017/2/28.
 */

public class OtherStoriesSection implements BaseItem {
    private final List<EditorsBean> mEditors;

    public OtherStoriesSection(List<EditorsBean> editors) {
        mEditors = editors;
    }

    public List<EditorsBean> getEditors() {
        return mEditors;
    }
}
