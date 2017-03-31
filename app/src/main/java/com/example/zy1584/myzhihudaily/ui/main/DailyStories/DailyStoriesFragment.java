package com.example.zy1584.myzhihudaily.ui.main.dailyStories;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.adapter.DailyStoriesAdapter;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesBean;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesHeader;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesSection;
import com.example.zy1584.myzhihudaily.utils.MyUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.R.attr.id;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class DailyStoriesFragment extends BaseFragment<DailyStoriesPresenter> implements DailyStoriesContract.View ,
        SwipeRefreshLayout.OnRefreshListener, LoadMoreWrapper.OnLoadMoreListener{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<BaseItem> mData = new ArrayList<>();
    private boolean isLoading;
    private String date;
    private LoadMoreWrapper mAdapter;

    @Override
    protected DailyStoriesPresenter loadPresenter() {
        return new DailyStoriesPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        mSwipeRefreshLayout.setColorSchemeColors(UIUtils.getColor(R.color.colorPrimary));

        DailyStoriesAdapter originalAdapter = new DailyStoriesAdapter(mActivity, mData);
        mAdapter = new LoadMoreWrapper(originalAdapter);
        mAdapter.setLoadMoreView(R.layout.layout_load_more);
        mAdapter.setOnLoadMoreListener(this);

        initRecyclerView(mRecyclerView);
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
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                if (!isLoading && id != 0){
                    isLoading = true;
                    mSwipeRefreshLayout.setRefreshing(true);
                    mPresenter.getLatestNews();
                }
            }
        });
    }

    @Override
    public void onLoadLatestNewsSuccess(DailyStoriesBean bean) {
        isLoading = false;
        date = bean.getDate();
        mData.clear();
        mData.add(new DailyStoriesHeader(bean.getTop_stories()));
        mData.add(new DailyStoriesSection(bean.getDate()));
        mData.addAll(bean.getStories());
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadBeforeNewsSuccess(DailyStoriesBean bean) {
        isLoading = false;
        date = bean.getDate();
        mData.add(new DailyStoriesSection(bean.getDate()));
        mData.addAll(bean.getStories());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError() {
        isLoading = false;
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if (!isLoading){
            isLoading = true;
            mPresenter.getLatestNews();
        }
    }

    @Override
    public void onLoadMoreRequested() {
        // 当数据不足以铺满屏幕的时候，onLoadMoreRequested会执行，所以需要添加限制
        if (!isLoading && !TextUtils.isEmpty(date)){
            isLoading = true;
            mPresenter.getBeforeNews(date);
        }
    }
}
