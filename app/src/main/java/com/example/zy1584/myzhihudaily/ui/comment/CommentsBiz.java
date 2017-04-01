package com.example.zy1584.myzhihudaily.ui.comment;

import com.example.zy1584.myzhihudaily.base.BaseModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zy1584 on 2017-4-1.
 */

public class CommentsBiz extends BaseModel {

    public Observable<StoryCommentsBean>getStoryContentLongComments(int id){
        return httpService.getStoryContentLongComments(id);
    }

    public Observable<StoryCommentsBean>getStoryContentShortComments(int id){
        return httpService.getStoryContentShortComments(id);
    }

}
