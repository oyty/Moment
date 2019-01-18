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
import com.xelement.moment.entity.OrderEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class PlanItemView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mTimeLabel)
    TextView mTimeLabel;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mDaysLabel)
    TextView mDaysLabel;

    public PlanItemView(@NonNull Context context) {
        this(context, null);
    }

    public PlanItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_plan_item, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(OrderEntity entity) {
        mTimeLabel.setText(entity.time);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);

        mTitleLabel.setText(entity.title);
        mDaysLabel.setText(entity.days + "天收货");
    }
}
