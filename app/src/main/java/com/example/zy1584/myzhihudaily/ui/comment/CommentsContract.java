package com.example.zy1584.myzhihudaily.ui.comment;

/**
 * Created by zy1584 on 2017-4-1.
 */

public interface CommentsContract {

    interface View{

        void getStoryContentLongComments(StoryCommentsBean bean);

        void getStoryContentShortComments(StoryCommentsBean bean);

    }

    interface Presenter{

        void getStoryContentLongComments(int id);

        void getStoryContentShortComments(int id);

    }
}
