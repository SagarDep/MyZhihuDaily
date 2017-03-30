package com.example.zy1584.myzhihudaily.ui.main.menu.adapter;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.ui.main.menu.bean.DrawerHome;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class DrawerHomeDelegate implements ItemViewDelegate {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.drawer_home_item;
    }

    @Override
    public boolean isForViewType(Object item, int position) {
        return item instanceof DrawerHome;
    }

    @Override
    public void convert(ViewHolder holder, Object o, int position) {

    }
}
