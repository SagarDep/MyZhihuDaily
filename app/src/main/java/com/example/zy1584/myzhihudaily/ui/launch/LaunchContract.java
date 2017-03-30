package com.example.zy1584.myzhihudaily.ui.launch;

/**
 * Created by zy1584 on 2017-3-30.
 */

public interface LaunchContract {

    interface View {

        void onSuccess(LaunchImageBean bean);

        void  requestEnd();
    }

    interface Presenter {

        void getLaunchImage();

    }
}
