package com.example.zy1584.myzhihudaily.ui.main.news.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.news.bean.NewsLatestBean;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.NetUtils;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/13.
 */

class NewsListItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof NewsLatestBean.StoriesBean;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

        final NewsLatestBean.StoriesBean stories = (NewsLatestBean.StoriesBean) baseItem;
        holder.setText(R.id.title, stories.getTitle());
        mContext = holder.getConvertView().getContext();
        if ((boolean) SPUtils.get(GlobalParams.NO_IMAGE_MODE, false)
                && !NetUtils.isWifi(UIUtils.getContext())) {
            Glide.with(mContext)
                    .load(R.drawable.image_small_default)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.image));
        } else {
            Glide.with(mContext)
                    .load(stories.getImages().get(0))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.image));
        }
        holder.setOnClickListener(R.id.cardView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, StoryContentActivity.class);
//                intent.putExtra("id", stories.getId());
//                mContext.startActivity(intent);
            }
        });
    }

}
