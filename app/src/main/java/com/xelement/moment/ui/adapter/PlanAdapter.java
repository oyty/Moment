package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.PlanGroupEntity;

import java.util.List;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanAdapter extends BaseQuickAdapter<OrderEntity, BaseViewHolder> {

    public PlanAdapter(int layoutResId, @Nullable List<OrderEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderEntity item) {

    }
}
