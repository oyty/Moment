package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.DiscoveryHotEntity;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryHotAdapter extends BaseQuickAdapter<DiscoveryHotEntity, BaseViewHolder> {

    public DiscoveryHotAdapter(int layoutResId, @Nullable List<DiscoveryHotEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscoveryHotEntity item) {

    }
}
