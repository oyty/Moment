package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.AddressEntity;
import com.xelement.moment.widget.custom.AddressItemView;

import java.util.List;

/**
 * Created by oyty on 2018/8/31.
 */
public class AddressItemAdapter extends BaseQuickAdapter<AddressEntity, BaseViewHolder> {

    public AddressItemAdapter(int layoutResId, @Nullable List<AddressEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressEntity item) {
        ((AddressItemView)helper.getView(R.id.mAddressItemView)).refresh(item);
    }
}
