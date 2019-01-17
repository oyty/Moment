package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.widget.custom.StoreProductView;

import java.util.List;

/**
 * Created by oyty on 2019/1/14.
 */
public class StoreAdapter extends BaseQuickAdapter<ProductEntity, BaseViewHolder> {

    public StoreAdapter(int layoutResId, @Nullable List<ProductEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductEntity item) {
        StoreProductView view = helper.getView(R.id.mStoreView);
        view.refresh(item);
    }
}
