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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.ui.activity.OrderDetailActivity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class OrderView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mTimeLabel)
    TextView mTimeLabel;
    @BindView(R.id.mStateLabel)
    TextView mStateLabel;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mCurrentPriceLabel)
    TextView mCurrentPriceLabel;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mPriceView)
    LinearLayout mPriceView;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mSkuLabel)
    TextView mSkuLabel;
    @BindView(R.id.mTagLabel1)
    TextView mTagLabel1;
    @BindView(R.id.mTagLabel2)
    TextView mTagLabel2;
    @BindView(R.id.mPlanLabel)
    TextView mPlanLabel;
    @BindView(R.id.mActionLabel)
    TextView mActionLabel;
    @BindView(R.id.mBaseAction)
    LinearLayout mBaseAction;
    @BindView(R.id.mTopView)
    RelativeLayout mTopView;
    @BindView(R.id.mBottomView)
    LinearLayout mBottomView;
    private OrderEntity entity;

    public OrderView(@NonNull Context context) {
        this(context, null);
    }

    public OrderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_order, this);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        Intent intent = new Intent(mContext, OrderDetailActivity.class);
        intent.putExtra(Constants.ORDER_DATA, entity);
        mContext.startActivity(intent);
    }

    public void refresh(OrderEntity entity) {
        this.entity = entity;
        mTimeLabel.setText(entity.time);
        mStateLabel.setText(entity.status == 0 ? "待支付尾款" : "待收货");
//        mProductImg.setImageResource(entity.image);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mTitleLabel.setText(entity.title);
        mSkuLabel.setText(entity.sku);
        mTagLabel1.setText(entity.tag1);
        mTagLabel2.setText(entity.tag2);
        mPriceLabel.setText(CommonUtil.getPrice("", entity.price));
        mCurrentPriceLabel.setText(CommonUtil.getPrice("", entity.current_price));
        CommonUtil.updateStroke(mPriceLabel);
        mActionLabel.setText(entity.status == 0 ? CommonUtil.getPrice("支付尾款", entity.deposit_after) : "确认收货");
        mPlanLabel.setText("支付定金后" + entity.days + "天内发货");
    }

    public void refreshDetail(OrderEntity entity) {
        refresh(entity);
        mTopView.setVisibility(GONE);
        mBottomView.setVisibility(GONE);
    }
}
