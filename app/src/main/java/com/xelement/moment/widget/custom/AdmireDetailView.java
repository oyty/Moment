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
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class AdmireDetailView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mDesLabel1)
    TextView mDesLabel1;
    @BindView(R.id.mDesLabel2)
    TextView mDesLabel2;
    @BindView(R.id.mDesLabel3)
    TextView mDesLabel3;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;
    @BindView(R.id.mDepositLabel)
    TextView mDepositLabel;

    public AdmireDetailView(@NonNull Context context) {
        this(context, null);
    }

    public AdmireDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdmireDetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_admire_detail, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(AdmireItemEntity entity) {
        mTitleLabel.setText(entity.desc);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mDesLabel1.setText(entity.sell_points1);
        mDesLabel2.setText(entity.sell_points2);
        mDesLabel3.setText(entity.sell_points3);
        mPriceLabel.setText(CommonUtil.getPrice("", entity.current_price));
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.mall_price));
        CommonUtil.updateStroke(mMallPriceLabel);
        mDepositLabel.setText(CommonUtil.getPrice("", entity.deposit));
    }
}
