package com.example.zy1584.myzhihudaily.ui.main.dailyStories.adapter;

import android.content.Context;

import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;


/**
 * Created by OO on 2017/2/13.
 */

public class DailyStoriesAdapter extends MultiItemTypeAdapter<BaseItem> {
    public DailyStoriesAdapter(Context context, List<BaseItem> itemList) {
        super(context, itemList);
        addItemViewDelegate(new DailyStoriesHeaderDelegate());
        addItemViewDelegate(new DailyStoriesSectionDelegate());
        addItemViewDelegate(new DailyStoriesItemDelegate());
    }
}
