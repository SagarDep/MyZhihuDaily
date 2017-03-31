package com.example.zy1584.myzhihudaily.ui.main.otherStories.adapter;

import android.content.Context;

import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;


/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public OtherStoriesListAdapter(Context context, List<BaseItem> itemList) {
        super(context, itemList);
        addItemViewDelegate(new OtherStoriesHeaderDelegate());
        addItemViewDelegate(new OtherStoriesSectionDelegate());
        addItemViewDelegate(new OtherStoriesItemDelegate());
    }
}
