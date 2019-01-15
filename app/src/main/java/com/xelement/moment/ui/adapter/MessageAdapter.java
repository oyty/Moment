package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.entity.MessageEntity;

import java.util.List;

/**
 * Created by oyty on 2019/1/15.
 */
public class MessageAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {

    public MessageAdapter(int layoutResId, @Nullable List<MessageEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageEntity item) {

    }
}
