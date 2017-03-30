package com.example.zy1584.myzhihudaily.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zy1584.myzhihudaily.interfaces.IView;
import com.example.zy1584.myzhihudaily.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import rx.subjects.BehaviorSubject;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {
    public String TAG;
    protected View mContentView;
    protected BaseActivity mActivity;
    protected P mPresenter;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        TAG = this.getClass().getSimpleName();
        mActivity = (BaseActivity) activity;
        mPresenter = loadPresenter();
        initCommonData();
    }

    protected abstract P loadPresenter();

    private void initCommonData() {

        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onUserVisible();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            mContentView = inflater.inflate(getLayoutId(), null);
            ButterKnife.bind(this, mContentView);
            initView(savedInstanceState);
            setListener();
            doBusiness(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    protected abstract int getLayoutId();

    protected void initView(Bundle savedInstanceState){};

    protected void setListener(){};

    protected void doBusiness(Bundle savedInstanceState){};

    /**
     * 当fragment对用户可见时，会调用该方法，可在该方法中懒加载网络数据
     */
    protected void onUserVisible(){};

    public void toast(String str) {
        ToastUtils.showShort(mActivity, str);
    }

    public void toast(int contentId) {
        ToastUtils.showShort(mActivity, contentId);
    }

    public void LogI(String str) {
        Logger.t(TAG).i(str);
    }

    @Override
    public void onDestroy() {
        mPresenter.unsubscribe();// rx 生命周期管理
        super.onDestroy();
    }
}