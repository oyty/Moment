package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class StoreProductView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;

    public StoreProductView(@NonNull Context context) {
        this(context, null);
    }

    public StoreProductView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StoreProductView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_store_product, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(ProductEntity entity) {
//        mProductImg.setImageResource(entity.image);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mTitleLabel.setText(entity.title);
        mPriceLabel.setText(CommonUtil.getPrice("", entity.currentPrice));
        mMallPriceLabel.setText(CommonUtil.getPrice("", entity.price));
        CommonUtil.updateStroke(mMallPriceLabel);
    }
}
