package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.widget.custom.OrderView;

import java.util.List;

/**
 * Created by oyty on 2019/1/15.
 */
public class OrderAdapter extends BaseQuickAdapter<OrderEntity, BaseViewHolder> {

    public OrderAdapter(int layoutResId, @Nullable List<OrderEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderEntity item) {
        OrderView view = helper.getView(R.id.mOrderView);
        view.refresh(item);
    }
}
