package com.example.zy1584.myzhihudaily.ui.newsDetail;

/**
 * Created by zy1584 on 2017-4-1.
 */

public interface StoryContentContract {

    interface View{

        void getStoryContent(StoryContentBean bean);

        void getStoryContentExtra(StoryContentExtraBean bean);

    }

    interface Presenter{

        void getStoryContent(int id);

        void getStoryContentExtra(int id);

    }
}
