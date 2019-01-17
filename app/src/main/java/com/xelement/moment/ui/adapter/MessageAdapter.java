package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;
import com.xelement.moment.entity.MessageEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.widget.custom.MessageView;

import java.util.List;

/**
 * Created by oyty on 2019/1/15.
 */
public class MessageAdapter extends BaseQuickAdapter<OrderEntity, BaseViewHolder> {

    public MessageAdapter(int layoutResId, @Nullable List<OrderEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderEntity item) {
        MessageView view = helper.getView(R.id.mMessageView);
        view.refresh(item);
    }
}
