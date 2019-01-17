package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public class FresherView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mItemValue)
    TextView mItemValue;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;
    @BindView(R.id.mFreshLabel)
    TextView mFreshLabel;
    @BindView(R.id.mFreshPriceLabel)
    TextView mFreshPriceLabel;
    private ProductEntity entity;

    public FresherView(@NonNull Context context) {
        this(context, null);
    }

    public FresherView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FresherView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_fresher, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(ProductEntity entity, int adapterPosition) {
        this.entity = entity;
//        mProductImg.setImageResource(entity.image);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mItemValue.setText(CommonUtil.getPrice("新人价", entity.currentPrice));
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.price));
        CommonUtil.updateStroke(mMallPriceLabel);
        if(adapterPosition == 1) {
            mFreshPriceLabel.setText("¥5");
        } else if(adapterPosition == 3) {
            mFreshLabel.setText("新人");
            mFreshPriceLabel.setText("限量");
        } else {
            mFreshPriceLabel.setText("¥1");
        }
    }

    @OnClick(R.id.mBaseAction)
    public void onViewClicked() {
        if (entity.isClickable()) {
            Intent intent = new Intent(mContext, MomentDetailActivity.class);
            intent.putExtra(Constants.DETAIL_DATA, entity);
            intent.putExtra(Constants.IS_FRESH, true);
            mContext.startActivity(intent);
        }
    }
}
