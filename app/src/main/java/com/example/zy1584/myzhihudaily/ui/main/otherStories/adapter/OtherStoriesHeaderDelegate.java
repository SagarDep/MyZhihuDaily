package com.example.zy1584.myzhihudaily.ui.main.otherStories.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.bean.OtherStoriesHeader;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.NetUtils;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/27.
 */

class OtherStoriesHeaderDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_other_story_header;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        OtherStoriesHeader storiesHeader = (OtherStoriesHeader) baseItem;
        ImageView imageView = holder.getView(R.id.image);
        TextView textView = holder.getView(R.id.title);
        if ((boolean) SPUtils.get(GlobalParams.NO_IMAGE_MODE, false)
                && !NetUtils.isWifi(UIUtils.getContext())) {
            Glide.with(holder.getConvertView().getContext())
                    .load(R.drawable.image_top_default)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .centerCrop()
                    .into(imageView);
        } else {
            Glide.with(holder.getConvertView().getContext())
                    .load(storiesHeader.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .centerCrop()
                    .into(imageView);
        }
        textView.setText(storiesHeader.getDescription());
    }
}
