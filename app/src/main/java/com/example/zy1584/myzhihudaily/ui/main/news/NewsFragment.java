package com.example.zy1584.myzhihudaily.ui.main.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.news.adapter.NewsListAdapter;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsBeforeBean;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsLatestBean;
import com.example.zy1584.myzhihudaily.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View ,
        SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<BaseItem> mData = new ArrayList<>();
    private NewsListAdapter mAdapter;

    @Override
    protected NewsPresenter loadPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NewsListAdapter(mActivity, mData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {
        super.setListener();
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void doBusiness(Bundle savedInstanceState) {
        super.doBusiness(savedInstanceState);
        mPresenter.getLatestNews();
    }

    @Override
    public void onLoadLatestNewsSuccess(NewsLatestBean bean) {
        if (!MyUtils.checkNull(bean) && bean.getStories().size() > 0){

        }
    }

    @Override
    public void onLoadBeforeNewsSuccess(NewsBeforeBean bean) {

    }

    @Override
    public void onRefresh() {

    }
}
