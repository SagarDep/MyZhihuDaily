package com.example.zy1584.myzhihudaily.ui.main.dailyStories.adapter;

import android.content.Context;

import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.dailyStories.bean.DailyStoriesHeader;
import com.example.zy1584.myzhihudaily.widget.Banner.Banner;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/15.
 */

class DailyStoriesHeaderDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_header;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof DailyStoriesHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final DailyStoriesHeader dailyStoriesHeader = (DailyStoriesHeader) baseItem;
        Banner banner = holder.getView(R.id.banner);
        banner.setDataList(dailyStoriesHeader.getTopStories())
                .start();

        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(int id) {
//                Intent intent = new Intent(mContext,StoryContentActivity.class);
//                intent.putExtra("id", id);
//                mContext.startActivity(intent);
            }
        });
    }
}
