package com.example.zy1584.myzhihudaily.ui.main.menu;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.menu.adapter.ThemeListAdapter;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.DrawerHeader;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.DrawerHome;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;

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

    }

    @Override
    public void onItemViewClick(int position) {

    }

    @Override
    public void onFollowClick() {

    }

}
