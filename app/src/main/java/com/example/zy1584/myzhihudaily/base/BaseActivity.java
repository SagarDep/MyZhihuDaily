package com.example.zy1584.myzhihudaily.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.interfaces.IView;
import com.example.zy1584.myzhihudaily.utils.ActivityCollector;
import com.example.zy1584.myzhihudaily.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by zy1584 on 2017-3-27.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements
        IView {
    protected View view;
    protected P mPresenter;

    protected String TAG;
    protected LayoutInflater mInflater;
    protected Activity activity;
    protected FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFullScreen())
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏android系统的状态栏
        setContentView(getLayoutId());
        mPresenter = loadPresenter();
        initCommonData();

        ActivityCollector.addActivity(this);
        initPublicMembers();// 初始化公共成员
        initSystemBar();// 4.4以上沉浸式状态栏

        ButterKnife.bind(this);
        initView();// 因为使用了butterKnife，所以这个方法将很少使用，因此这里不作为抽象方法。
        initListener();// 同上
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        doBusiness();// 需要时可以复写
    }

    protected boolean isFullScreen() {
        return false;
    }

    protected void handleIntent(Intent intent) {}

    protected void doBusiness(){};

    protected void initListener(){};

    protected void initView(){};

    protected abstract int getLayoutId();

    public interface OnRightClickListener {
        void rightClick();
    }

    protected abstract P loadPresenter();

    private void initCommonData() {

        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    private void initPublicMembers() {
        TAG = this.getClass().getSimpleName();
        mInflater = getLayoutInflater();
        activity = this;
        transaction = getSupportFragmentManager().beginTransaction();
    }

    /**
     * 对应的Activity的根布局需要继承style = "Activity"
     */
    private void initSystemBar() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(getResources().getColor(R.color.colorPrimary));
    }

    /******************************************* activity生命周期封装 ***********************************************/

    @Override
    protected void onDestroy() {
        ActivityCollector.removeActivity(this);// activity管理
        mPresenter.unsubscribe();// rx生命周期管理
        super.onDestroy();
    }

    /******************************************* toolbar封装 ***********************************************/


    /******************************************* 高频操作封装 ***********************************************/
    /**
     * 打开一个Activity 默认 不关闭当前activity
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            finish();
        }
    }

    /**
     * @param str 显示一个内容为str的toast
     */
    public void toast(String str) {
        ToastUtils.showShort(this, str);
    }

    /**
     * @param contentId 显示一个内容为contentId指定的toast
     */
    public void toast(int contentId) {
        ToastUtils.showShort(this, contentId);
    }

    /**
     * @param str 日志的处理
     */
    public void LogI(String str) {
        Logger.t(TAG).i(str);
    }

    /******************************************* fragment操作封装 ***********************************************/

    /**
     * 添加fragment
     *
     * @param fragment
     * @param contentId
     * @param addToBackStack
     */
    public void addFragment(BaseFragment fragment, int contentId, boolean addToBackStack) {
        if (fragment != null) {
            transaction.add(contentId, fragment, fragment.getClass().getSimpleName());
            if (addToBackStack) {
                transaction.addToBackStack("");
            }
            transaction.commit();
        }
    }

    /**
     * 替换fragment
     *
     * @param fragment
     * @param contentId
     * @param addToBackStack
     */
    public void replaceFragment(BaseFragment fragment, int contentId, boolean addToBackStack) {

        transaction.replace(contentId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            transaction.addToBackStack("");
        }
        transaction.commit();

    }

    //移除fragment
    protected void doBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /******************************************* Android 6.0权限封装 ***********************************************/

    public static  int REQUEST_CODE = 0;

    public void requestPermission(String[] permissions,int requestCode)
    {

        this.REQUEST_CODE = requestCode;

        //检查权限是否授权
        if(checkPermissions(permissions))
        {
            permissionSucceed(REQUEST_CODE);
        }
        else
        {
            List<String> needPermissions = getPermissions(permissions);
            ActivityCompat.requestPermissions(this, needPermissions.toArray(new String[needPermissions.size()]), REQUEST_CODE);
        }
    }

    /**
     * 检测所有的权限是否都已授权
     *
     * @param permissions
     * @return
     */
    private boolean checkPermissions(String[] permissions)
    {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M)
        {
            return true;
        }

        for(String permission:permissions)
        {

            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
            {
                return false;
            }
        }
        return true;
    }

    private List<String> getPermissions(String[] permissions)
    {
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                permissionList.add(permission);
            }
        }
        return permissionList;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == REQUEST_CODE) {
            if (verificationPermissions(grantResults)) {
                permissionSucceed(REQUEST_CODE);
            } else {
                permissionFailing(REQUEST_CODE);
                showFailingDialog();
            }
        }
    }

    private boolean verificationPermissions(int[] results)
    {

        for (int result : results) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;

    }

    private void showFailingDialog()
    {

        new AlertDialog.Builder(this)
                .setTitle("消息")
                .setMessage("当前应用无此权限，该功能暂时无法使用。如若需要，请单击确定按钮进行权限授权！")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        return;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startSettings();
                    }
                }).show();

    }

    private void startSettings() {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    public void permissionFailing(int code) {

        Log.d(TAG, "获取权限失败=" + code);
    }

    public void permissionSucceed(int code) {

        Log.d(TAG, "获取权限成功=" + code);
    }

}
