package com.example.zy1584.myzhihudaily.ui.main;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseActivity;
import com.example.zy1584.myzhihudaily.base.BaseFragment;
import com.example.zy1584.myzhihudaily.base.BasePresenter;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.DailyStoriesFragment;
import com.example.zy1584.myzhihudaily.utils.MyUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

    private int mCurrentPosition;
    private DailyStoriesFragment mDailyStoriesFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mDailyStoriesFragment = new DailyStoriesFragment();
        switchFragment(mDailyStoriesFragment,"首页", 1);
    }

    public void switchFragment(BaseFragment f, String title, int position){
        if (MyUtils.checkNull(f))return;
        replaceFragment(f, R.id.container, false);
        setTitle(title);
        mCurrentPosition = position;
    }

    public boolean isNeedToSwitch(int position){
        if (mCurrentPosition == position){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (mCurrentPosition != 1) {
                switchFragment(mDailyStoriesFragment, "首页", 1);
            } else {
                super.onBackPressed();
            }
        }
    }
}
