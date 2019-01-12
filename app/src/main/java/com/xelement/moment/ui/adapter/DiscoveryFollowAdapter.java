package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.FollowEntity;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryFollowAdapter extends BaseQuickAdapter<FollowEntity, BaseViewHolder> {

    public DiscoveryFollowAdapter(int layoutResId, @Nullable List<FollowEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FollowEntity item) {

    }
}
