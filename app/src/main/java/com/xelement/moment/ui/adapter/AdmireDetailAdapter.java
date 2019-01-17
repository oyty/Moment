package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.widget.custom.AdmireDetailView;

import java.util.List;

/**
 * Created by oyty on 2019/1/15.
 */
public class AdmireDetailAdapter extends BaseQuickAdapter<AdmireItemEntity, BaseViewHolder> {

    public AdmireDetailAdapter(int layoutResId, @Nullable List<AdmireItemEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AdmireItemEntity item) {
        AdmireDetailView view = helper.getView(R.id.mAdmireDetailView);
        view.refresh(item);
    }
}
