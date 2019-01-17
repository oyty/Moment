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
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.ui.activity.OrderDetailActivity;
import com.xelement.moment.util.TimeUtil;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class MessageView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mTimeLabel)
    TextView mTimeLabel;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mDesLabel)
    TextView mDesLabel;
    private OrderEntity entity;

    public MessageView(@NonNull Context context) {
        this(context, null);
    }

    public MessageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_message, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(OrderEntity entity) {
        this.entity = entity;
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
//        mProductImg.setImageResource(entity.image);
        mTimeLabel.setText(TimeUtil.getTimeFormatText(entity.time));
        if (entity.status == 0) {
            mTitleLabel.setText("您进行时光购买的【" + entity.title + "】已经支付定金！");
            mDesLabel.setText("请尽快支付尾款确认收货地址");
        } else {
            mTitleLabel.setText("您进行时光购买的【" + entity.title + "】已经支付全款！");
            mDesLabel.setText("请尽快确认收货地址");
        }
    }

    @OnClick(R.id.mCheckDetailAction)
    public void onViewClicked() {
        Intent intent = new Intent(mContext, OrderDetailActivity.class);
        intent.putExtra(Constants.ORDER_DATA, entity);
        mContext.startActivity(intent);
    }
}
