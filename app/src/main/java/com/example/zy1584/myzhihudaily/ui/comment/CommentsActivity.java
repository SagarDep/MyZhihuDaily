package com.example.zy1584.myzhihudaily.ui.comment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseActivity;

public class CommentsActivity extends BaseActivity<CommentsPresenter> implements CommentsContract.View {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_comments;
    }

    @Override
    protected CommentsPresenter loadPresenter() {
        return new CommentsPresenter();
    }

    @Override
    public void getStoryContentLongComments(StoryCommentsBean bean) {

    }

    @Override
    public void getStoryContentShortComments(StoryCommentsBean bean) {

    }
}
