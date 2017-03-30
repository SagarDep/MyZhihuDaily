package com.example.zy1584.myzhihudaily.ui.main.menu.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.zy1584.myzhihudaily.R;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by zy1584 on 2017-3-30.
 */

public class ThemeListAdapter extends MultiItemTypeAdapter {

    private int mSelection = 1;
    private OnItemClickListener mOnItemClickListener;

    public ThemeListAdapter(Context context, List datas) {
        super(context, datas);
        addItemViewDelegate(new DrawerHeaderDelegate());
        addItemViewDelegate(new DrawerHomeDelegate());
        addItemViewDelegate(new ThemeItemDelegate());
    }

    @Override
    protected void setListener(ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        super.setListener(parent, viewHolder, viewType);
        switch (viewType){
            case 0:
                LinearLayout login = viewHolder.getView(R.id.login);
                Button collect = viewHolder.getView(R.id.collect);
                Button download = viewHolder.getView(R.id.download);

                login.setOnClickListener(mListener);
                collect.setOnClickListener(mListener);
                download.setOnClickListener(mListener);
                break;
            case 2:
                viewHolder.getView(R.id.add_follow).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onFollowClick();
                        }
                    }
                });
                // 注意这里没用break，原因就是当type为2时要设置两种点击事件
            case 1:
                viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            int position = viewHolder.getAdapterPosition();
                            mSelection = position;
                            notifyDataSetChanged();
                            mOnItemClickListener.onItemViewClick(position);
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (mSelection == position) {
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.drawer_select));
        } else if (position > 0) {
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.drawer_normal));
        }
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onDrawerHeaderClick(v);
            }
        }
    };

    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onDrawerHeaderClick(View view);

        void onItemViewClick(int position);

        void onFollowClick();
    }
}
