package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.DiscoveryItemEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.widget.custom.DiscoveryItemView;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryItemAdapter extends BaseQuickAdapter<ProductEntity, BaseViewHolder> {

    public DiscoveryItemAdapter(int layoutResId, @Nullable List<ProductEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductEntity item) {
        DiscoveryItemView view = helper.getView(R.id.mItemView);
        view.refresh(item);
    }
}
