package com.example.zy1584.myzhihudaily.ui.main.otherStories.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesBean;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.NetUtils;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/28.
 */

class OtherStoriesItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesBean.StoriesBean;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final OtherStoriesBean.StoriesBean item = (OtherStoriesBean.StoriesBean) baseItem;
        holder.setText(R.id.title, item.getTitle());
        holder.getView(R.id.multiPic).setVisibility(View.GONE);
        if (item.getImages().size() > 0) {
            if ((boolean) SPUtils.get(GlobalParams.NO_IMAGE_MODE, false)
                    && !NetUtils.isWifi(UIUtils.getContext())) {
                Glide.with(mContext)
                        .load(R.drawable.image_small_default)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into((ImageView) holder.getView(R.id.image));
            } else {
                Glide.with(mContext)
                        .load(item.getImages().get(0))
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into((ImageView) holder.getView(R.id.image));
            }
        } else {
            holder.getView(R.id.image).setVisibility(View.GONE);
        }
        holder.setOnClickListener(R.id.cardView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, OtherStoryContentActivity.class);
//                intent.putExtra("id", item.getId());
//                mContext.startActivity(intent);
            }
        });
    }
}
