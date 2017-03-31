package com.example.zy1584.myzhihudaily.ui.main.menu;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.login.LoginActivity;
import com.example.zy1584.myzhihudaily.ui.main.MainActivity;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.DailyStoriesFragment;
import com.example.zy1584.myzhihudaily.ui.main.menu.adapter.ThemeListAdapter;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.DrawerHeader;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.DrawerHome;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesBean;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesFragment;
import com.example.zy1584.myzhihudaily.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class MenuFragment extends BaseFragment<ThemesPresenter> implements ThemesContract.View,
        ThemeListAdapter.OnItemClickListener{

    @BindView(R.id.nav_view)
    RecyclerView nav_view;

    private List<BaseItem> mData = new ArrayList<>();
    private ThemeListAdapter mAdapter;

    @Override
    protected ThemesPresenter loadPresenter() {
        return new ThemesPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_menu;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAdapter = new ThemeListAdapter(mActivity, mData);
        mAdapter.setOnItemClickListener(this);
        nav_view.setHasFixedSize(true);
        nav_view.setLayoutManager(new LinearLayoutManager(mActivity));
        nav_view.setItemAnimator(new DefaultItemAnimator());
        nav_view.setAdapter(mAdapter);
    }

    @Override
    protected void doBusiness(Bundle savedInstanceState) {
        mPresenter.getThemes();
    }

    @Override
    public void onSuccess(ThemesBean bean) {
        mData.clear();
        mData.add(new DrawerHeader());
        mData.add(new DrawerHome());
        mData.addAll(bean.getOthers());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDrawerHeaderClick(View view) {
        switch (view.getId()) {
            case R.id.download:
                Toast.makeText(getContext(), "离线下载什么鬼东西哦，又不说~", Toast.LENGTH_SHORT).show();
                break;
            default:
                mActivity.gotoActivity(LoginActivity.class);
                break;
        }
    }

    @Override
    public void onItemViewClick(int position) {
        MainActivity activity = (MainActivity) mActivity;
        if (activity.isNeedToSwitch(position)) {
            if (position == 1){
                DailyStoriesFragment dailyStoriesFragment = new DailyStoriesFragment();
                activity.switchFragment(dailyStoriesFragment,"首页", position);
            }else{
                int id = ((ThemesBean.OthersBean) mData.get(position)).getId();
                String name = ((ThemesBean.OthersBean) mData.get(position)).getName();
                OtherStoriesFragment otherStoriesFragment = OtherStoriesFragment.newInstance(id);
                activity.switchFragment(otherStoriesFragment, name, position);
            }
        }
        activity.onBackPressed();
    }

    @Override
    public void onFollowClick() {
        ToastUtils.showShort(mActivity,"还没开发(⊙o⊙)哦~");
    }

}
