package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.widget.custom.FresherView;

import java.util.List;

/**
 * Created by oyty on 2019/1/15.
 */
public class FresherAdapter extends BaseQuickAdapter<ProductEntity, BaseViewHolder> {

    public FresherAdapter(int layoutResId, @Nullable List<ProductEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductEntity item) {
        FresherView view = helper.getView(R.id.mFresherView);
        view.refresh(item);
    }
}
