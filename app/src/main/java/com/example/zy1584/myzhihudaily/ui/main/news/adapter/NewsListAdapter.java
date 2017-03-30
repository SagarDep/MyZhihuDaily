package com.example.zy1584.myzhihudaily.ui.main.news.adapter;

import android.content.Context;

import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;


/**
 * Created by OO on 2017/2/13.
 */

public class NewsListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public NewsListAdapter(Context context, List<BaseItem> itemList) {
        super(context, itemList);
        addItemViewDelegate(new NewsListHeaderDelegate());
        addItemViewDelegate(new NewsListSectionDelegate());
        addItemViewDelegate(new NewsListItemDelegate());
    }
}
