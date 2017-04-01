package com.example.zy1584.myzhihudaily.ui.newsDetail;

import com.example.zy1584.myzhihudaily.base.BaseModel;

import rx.Observable;

/**
 * Created by zy1584 on 2017-4-1.
 */

public class StoryContentBiz extends BaseModel {

    public Observable<StoryContentBean>getStoryContent(int id){
        return httpService.getStoryContent(id);
    }

    public Observable<StoryContentExtraBean>getStoryContentExtra(int id){
        return httpService.getStoryContentExtra(id);
    }

}
