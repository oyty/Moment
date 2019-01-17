package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.widget.custom.AdmireView;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class AdmireAdapter extends BaseQuickAdapter<AdmireEntity, BaseViewHolder> {

    public AdmireAdapter(int layoutResId, @Nullable List<AdmireEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AdmireEntity item) {
        AdmireView view = helper.getView(R.id.mAdmireView);
        view.refresh(item);
    }
}
