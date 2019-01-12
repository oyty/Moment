package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.FollowItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowItemAdapter extends BaseQuickAdapter<FollowItemEntity, BaseViewHolder> {

    public FollowItemAdapter(int layoutResId, @Nullable List<FollowItemEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FollowItemEntity item) {

    }
}
