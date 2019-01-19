package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xelement.moment.R;

import java.util.List;

/**
 * Created by oyty on 2019/1/19.
 */
public class PicAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public PicAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        ImageView imageView = helper.getView(R.id.mPicImg);
        Glide.with(mContext)
                .load(item)
                .into(imageView);
    }
}
