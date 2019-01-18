package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.widget.custom.PlanItemView;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class PlanItemAdapter extends BaseQuickAdapter<OrderEntity, BaseViewHolder> {

    public PlanItemAdapter(int layoutResId, @Nullable List<OrderEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderEntity item) {
        PlanItemView itemView = helper.getView(R.id.mItemView);
        itemView.refresh(item);
    }
}
