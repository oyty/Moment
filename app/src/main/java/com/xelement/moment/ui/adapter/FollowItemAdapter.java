package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.widget.custom.FollowItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowItemAdapter extends BaseQuickAdapter<AdmireItemEntity, BaseViewHolder> {

    public FollowItemAdapter(int layoutResId, @Nullable List<AdmireItemEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AdmireItemEntity item) {
        FollowItemView view = helper.getView(R.id.mFollowItemView);
        view.refresh(item);
    }
}
