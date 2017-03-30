package com.example.zy1584.myzhihudaily.ui.main.menu;

import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;

/**
 * Created by zy1584 on 2017-3-30.
 */

public interface ThemesContract {

    interface View {

        void onSuccess(ThemesBean bean);

    }

    interface Presenter {

        void getThemes();

    }
}
