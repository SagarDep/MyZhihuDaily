package com.example.zy1584.myzhihudaily.ui.launch;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseActivity;
import com.example.zy1584.myzhihudaily.ui.main.MainActivity;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements LaunchContract.View {

    private String imgUrl;
    @BindView(R.id.launch_image) ImageView launch_image;

    @Override
    protected boolean isFullScreen() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected SplashPresenter loadPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void doBusiness() {
        mPresenter.getLaunchImage();
    }

    @Override
    public void onSuccess(LaunchImageBean bean) {
        if (null != bean && bean.getCreatives().size()>0){
            imgUrl = bean.getCreatives().get(0).getUrl();
            Glide.with(this).load(imgUrl).into(launch_image);
            if (!TextUtils.isEmpty(imgUrl))
                SPUtils.put(GlobalParams.LAUNCH_IMG_URL, imgUrl);
        }
    }

    @Override
    public void requestEnd() {
        UIUtils.runOnUiDelayed(new Runnable() {
            @Override
            public void run() {
                gotoActivity(MainActivity.class,true);
            }
        },3000);
    }
}
