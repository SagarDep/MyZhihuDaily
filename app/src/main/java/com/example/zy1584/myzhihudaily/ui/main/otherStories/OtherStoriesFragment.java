package com.example.zy1584.myzhihudaily.ui.main.otherStories;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.adapter.OtherStoriesListAdapter;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.bean.OtherStoriesHeader;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.bean.OtherStoriesSection;
import com.example.zy1584.myzhihudaily.utils.MyUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zy1584 on 2017-3-31.
 */

public class OtherStoriesFragment extends BaseFragment<OtherStoriesPresenter> implements SwipeRefreshLayout.OnRefreshListener,
        OtherStoriesContract.View, LoadMoreWrapper.OnLoadMoreListener{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private static final String LIST_ID = "list_id";
    private List<BaseItem> mData = new ArrayList<>();
    private LoadMoreWrapper mAdapter;
    private boolean isLoading;
    private int id;
    private int story_id;

    public static OtherStoriesFragment newInstance(int param1) {
        OtherStoriesFragment fragment = new OtherStoriesFragment();
        Bundle args = new Bundle();
        args.putInt(LIST_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void handleArguments(Bundle arguments) {
        super.handleArguments(arguments);
        if (!MyUtils.checkNull(arguments)){
            id = arguments.getInt(LIST_ID);
        }
    }

    @Override
    protected OtherStoriesPresenter loadPresenter() {
        return new OtherStoriesPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_other_stories;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mSwipeRefreshLayout.setColorSchemeColors(UIUtils.getColor(R.color.colorPrimary));

        OtherStoriesListAdapter originalAdapter = new OtherStoriesListAdapter(mActivity, mData);
        mAdapter = new LoadMoreWrapper(originalAdapter);
        mAdapter.setLoadMoreView(R.layout.layout_load_more);

        initRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {
        super.setListener();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(this);
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
                    mPresenter.getThemesContent(id);
                }
            }
        });
    }

    @Override
    public void getThemesContent(OtherStoriesBean bean) {
        stopLoading();
        mData.clear();
        mData.add(new OtherStoriesHeader(bean.getBackground(), bean.getDescription()));
        mData.add(new OtherStoriesSection(bean.getEditors()));
        mData.addAll(bean.getStories());
        story_id = bean.getStories().get(bean.getStories().size() - 1).getId();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getBeforeThemesContent(OtherStoriesBean bean) {
        stopLoading();
        mData.addAll(bean.getStories());
        story_id = bean.getStories().get(bean.getStories().size() - 1).getId();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError() {
        stopLoading();
    }

    @Override
    public void onLoadMoreRequested() {
        if (!isLoading && id != 0 && story_id != 0){
            isLoading = true;
            mPresenter.getBeforeThemesContent(id, story_id);
        }
    }

    @Override
    public void onRefresh() {
        if (!isLoading && id != 0){
            isLoading = true;
            mPresenter.getThemesContent(id);
        }
    }

    private void stopLoading() {
        isLoading = false;
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
