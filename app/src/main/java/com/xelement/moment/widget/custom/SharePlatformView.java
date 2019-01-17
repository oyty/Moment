package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseAdapter;
import com.xelement.moment.base.ShareConstant;
import com.xelement.moment.util.UIUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Datetime: 2018/7/28 11:33
 * Author: zcj
 */
public class SharePlatformView extends FrameLayout {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private Context mContext;
    private int mMaxItemPerPage = 5;

    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ShareConstant.SharePlatform> mPlatformList = new ArrayList<>();

    public SharePlatformView(@NonNull Context context) {
        this(context, null);
    }

    public SharePlatformView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SharePlatformView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        init();
    }


    public void setMaxItemPerPage(int max) {
        this.mMaxItemPerPage = max;
    }

    public void setData(List<ShareConstant.SharePlatform> platformList) {
        mPlatformList.clear();
        mPlatformList.addAll(platformList);
        mAdapter.setDataAndNotify(mPlatformList);
    }

    private void init() {
        initView();
        initData();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_share_platform, this, true);
        ButterKnife.bind(view);
    }

    private void initData() {
        mAdapter = new Adapter(mContext, mPlatformList);
        mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class Adapter extends com.xelement.moment.ui.dialog.BaseAdapter<ShareConstant.SharePlatform, ViewHolder> {

        public Adapter(Context context, List<ShareConstant.SharePlatform> list) {
            super(context, list);
        }

        @Override
        protected int getItemViewResId(int viewType) {
            return R.layout.adapter_share_platform;
        }

        @Override
        protected ViewHolder createVH(View view, int viewType) {
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final ShareConstant.SharePlatform platform = getItemData(position);

            Glide.with(mContext)
                    .load(platform.iconId)
                    .into(holder.mImg);
//            holder.mImg.setImageResource(platform.iconId);
            holder.mLabel.setText(platform.name);
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

            //UI要求，多于 max 个，则一屏放 ((max-1) + 半个) 图标，可左右滑动，少于等于 max 个则填充满屏幕
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (getItemCount() >= mMaxItemPerPage) {
                layoutParams.width = (int) (UIUtil.getDimen(R.dimen.x750) / (mMaxItemPerPage - 0.5f) + 0.5f);
            } else {
                layoutParams.width = (int) (UIUtil.getDimen(R.dimen.x750) / getItemCount());
            }
            holder.itemView.setLayoutParams(layoutParams);
            holder.itemView.requestLayout();
        }
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.mImg)
        ImageView mImg;
        @BindView(R.id.mLabel)
        TextView mLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
