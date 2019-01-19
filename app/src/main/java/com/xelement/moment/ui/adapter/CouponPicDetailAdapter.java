package com.xelement.moment.ui.adapter;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xelement.moment.R;
import com.xelement.moment.util.ScreenUtil;

import java.io.File;
import java.util.List;

/**
 * Created by oyty on 2018/8/13.
 */
public class CouponPicDetailAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public CouponPicDetailAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        final ImageView imageView = helper.getView(R.id.mImgView);
        final SubsamplingScaleImageView scaleImageView = helper.getView(R.id.mScaleImgView);
        Glide.with(mContext)
                .downloadOnly()
                .load(item)
                .into(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(resource.getAbsolutePath(), options);
                        if(options.outHeight > ScreenUtil.getDeviceHeight()) {
                            scaleImageView.setVisibility(View.VISIBLE);
                            scaleImageView.setImage(ImageSource.uri(resource.getAbsolutePath()));
                        } else {
                            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                            params.width = ScreenUtil.getDeviceWidth();
                            params.height = params.width * options.outHeight / options.outWidth;
                            imageView.setVisibility(View.VISIBLE);
                            imageView.setImageBitmap(BitmapFactory.decodeFile(resource.getAbsolutePath()));
                        }
                    }
                });
    }
}
