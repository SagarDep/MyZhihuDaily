package com.example.zy1584.myzhihudaily.http;


import com.example.zy1584.myzhihudaily.ui.comment.StoryCommentsBean;
import com.example.zy1584.myzhihudaily.ui.launch.LaunchImageBean;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesBean;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesBean;
import com.example.zy1584.myzhihudaily.ui.newsDetail.StoryContentBean;
import com.example.zy1584.myzhihudaily.ui.newsDetail.StoryContentExtraBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zy1584 on 2017-3-27.
 */

public interface HttpService {

    //登录接口
//    @FormUrlEncoded
//    @POST("demo/login")
//    Observable<BaseHttpResult<LoginBean>> login(@Field("userName") String username, @Field
//            ("passWord") String pwd);

    @GET("api/7/prefetch-launch-images/1080*1920")
    Observable<LaunchImageBean> getLaunchImage();

    @GET("api/4/themes")
    Observable<ThemesBean> getThemes();

    @GET("api/4/news/latest")
    Observable<DailyStoriesBean> getLatestNews();

    @GET("api/4/news/before/{date}")
    Observable<DailyStoriesBean> getBeforeNews(@Path("date") String date);

    @GET("api/4/theme/{id}")
    Observable<OtherStoriesBean> getThemesContent(@Path("id") int id);

    @GET("api/4/theme/{id}/before/{story_id}")
    Observable<OtherStoriesBean> getBeforeThemesContent(@Path("id") int id, @Path("story_id") int story_id);

    @GET("api/4/news/{id}")
    Observable<StoryContentBean> getStoryContent(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    Observable<StoryContentExtraBean> getStoryContentExtra(@Path("id") int id);

    @GET("/api/4/story/{id}/long-comments")
    Observable<StoryCommentsBean> getStoryContentLongComments(@Path("id") int id);

    @GET("/api/4/story/{id}/short-comments")
    Observable<StoryCommentsBean> getStoryContentShortComments(@Path("id") int id);

}
