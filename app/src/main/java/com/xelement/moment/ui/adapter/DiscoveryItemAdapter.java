package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.DiscoveryItemEntity;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryItemAdapter extends BaseQuickAdapter<DiscoveryItemEntity, BaseViewHolder> {

    public DiscoveryItemAdapter(int layoutResId, @Nullable List<DiscoveryItemEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscoveryItemEntity item) {

    }
}
