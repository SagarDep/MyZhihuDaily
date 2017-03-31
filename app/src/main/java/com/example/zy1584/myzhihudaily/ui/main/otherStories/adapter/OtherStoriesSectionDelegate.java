package com.example.zy1584.myzhihudaily.ui.main.otherStories.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zy1584.myzhihudaily.R;
import com.example.zy1584.myzhihudaily.base.BaseItem;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.OtherStoriesBean;
import com.example.zy1584.myzhihudaily.ui.main.otherStories.bean.OtherStoriesSection;
import com.example.zy1584.myzhihudaily.utils.GlobalParams;
import com.example.zy1584.myzhihudaily.utils.NetUtils;
import com.example.zy1584.myzhihudaily.utils.SPUtils;
import com.example.zy1584.myzhihudaily.utils.UIUtils;
import com.example.zy1584.myzhihudaily.widget.CircleTransform;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/27.
 */

class OtherStoriesSectionDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_other_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final OtherStoriesSection section = (OtherStoriesSection) baseItem;
        LinearLayout editorGroup = holder.getView(R.id.editor_group);
        if (editorGroup.getChildCount() == 0) {
            int defaultMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, holder.getConvertView().getResources().getDisplayMetrics());
            for (OtherStoriesBean.EditorsBean editors : section.getEditors()) {
                ImageView imageView = new ImageView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(defaultMargin, defaultMargin);
                imageView.setLayoutParams(params);
                if ((boolean) SPUtils.get(GlobalParams.NO_IMAGE_MODE, false)
                        && !NetUtils.isWifi(UIUtils.getContext())) {
                    Glide.with(mContext)
                            .load(R.drawable.editor_profile_avatar)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .transform(new CircleTransform(mContext))
                            .into(imageView);
                } else {
                    Glide.with(mContext)
                            .load(editors.getAvatar())
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .transform(new CircleTransform(mContext))
                            .into(imageView);
                }
                editorGroup.addView(imageView);
            }
        }
        holder.getView(R.id.editors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, EditorListActivity.class);
//                intent.putParcelableArrayListExtra("editorList", section.getEditors());
//                mContext.startActivity(intent);
            }
        });
    }
}
