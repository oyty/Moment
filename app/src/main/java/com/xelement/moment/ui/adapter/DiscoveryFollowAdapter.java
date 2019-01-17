package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.widget.custom.DiscoveryFollowView;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryFollowAdapter extends BaseQuickAdapter<AdmireEntity, BaseViewHolder> {

    public DiscoveryFollowAdapter(int layoutResId, @Nullable List<AdmireEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AdmireEntity item) {
        DiscoveryFollowView view = helper.getView(R.id.mFollowView);
        view.refresh(item);
    }
}
