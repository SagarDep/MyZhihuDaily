package com.example.zy1584.myzhihudaily.ui.main.news.adapter;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsListSection;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/14.
 */

class NewsListSectionDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof NewsListSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        if (position == 1) {
            holder.setText(R.id.story_section, "今日热闻");
        } else {
            holder.setText(R.id.story_section, ((NewsListSection) baseItem).getDate());
        }
    }
}
