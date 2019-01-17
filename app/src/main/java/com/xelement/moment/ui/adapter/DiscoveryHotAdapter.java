package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.widget.custom.DiscoveryHotView;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryHotAdapter extends BaseQuickAdapter<ProductEntity, BaseViewHolder> {

    public DiscoveryHotAdapter(int layoutResId, @Nullable List<ProductEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductEntity item) {
        DiscoveryHotView view = helper.getView(R.id.mHotView);
        view.refresh(item);
    }
}
