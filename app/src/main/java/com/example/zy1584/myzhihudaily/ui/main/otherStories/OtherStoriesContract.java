package com.example.zy1584.myzhihudaily.ui.main.otherStories;

/**
 * Created by zy1584 on 2017-3-31.
 */

public interface OtherStoriesContract {

    interface View{

        void getThemesContent(OtherStoriesBean bean);

        void getBeforeThemesContent(OtherStoriesBean bean);

        void onError();

    }

    interface Presenter{

        void getThemesContent(int id);

        void getBeforeThemesContent(int id, int story_id);

    }
}
