package com.example.zy1584.myzhihudaily.ui.main.menu;

import com.example.zy1584.myzhihudaily.base.BaseModel;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.ThemesBean;

import rx.Observable;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class ThemesBiz extends BaseModel {

    public Observable<ThemesBean> getThemes(){
        return httpService.getThemes();
    }
}
