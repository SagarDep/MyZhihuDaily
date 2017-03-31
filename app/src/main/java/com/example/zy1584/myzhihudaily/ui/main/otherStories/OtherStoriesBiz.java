package com.example.zy1584.myzhihudaily.ui.main.otherStories;

import com.example.zy1584.myzhihudaily.base.BaseModel;

import rx.Observable;

/**
 * Created by zy1584 on 2017-3-31.
 */

public class OtherStoriesBiz extends BaseModel {

    public Observable<OtherStoriesBean>getThemesContent(int id){
        return httpService.getThemesContent(id);
    }

    public Observable<OtherStoriesBean>getBeforeThemesContent(int id, int story_id){
        return httpService.getBeforeThemesContent(id, story_id);
    }

}
