package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.activity.MomentDetailActivity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryHotView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;
    @BindView(R.id.mBaseAction)
    LinearLayout mBaseAction;
    private ProductEntity entity;

    public DiscoveryHotView(@NonNull Context context) {
        this(context, null);
    }

    public DiscoveryHotView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiscoveryHotView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_discovery_hot, this);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        if(entity.isClickable()) {
            Intent intent = new Intent(mContext, MomentDetailActivity.class);
            intent.putExtra(Constants.DETAIL_DATA, entity);
            mContext.startActivity(intent);
        }
    }

    public void refresh(ProductEntity entity) {
        this.entity = entity;
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);

        mTitleLabel.setText(entity.title);
        mPriceLabel.setText(CommonUtil.getPrice("", entity.currentPrice));
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.price));
    }
}
