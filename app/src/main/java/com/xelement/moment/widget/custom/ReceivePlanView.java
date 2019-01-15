package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.ui.activity.AdmireDetailActivity;
import com.xelement.moment.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class ReceivePlanView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mDayLabel)
    TextView mDayLabel;
    @BindView(R.id.mSaleLabel)
    TextView mSaleLabel;
    @BindView(R.id.mPlanView)
    LinearLayout mPlanView;

    public ReceivePlanView(@NonNull Context context) {
        this(context, null);
    }

    public ReceivePlanView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReceivePlanView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_receive_plan, this);
        ButterKnife.bind(this, view);
    }

    public void setChoosed(boolean isChoosed) {
        mPlanView.setBackgroundResource(isChoosed ? R.drawable.public_round_border_red : R.drawable.public_round_grey_bg);
        mDayLabel.setTextColor(UIUtil.getColor(isChoosed ? R.color.tag : R.color.black));
        mSaleLabel.setTextColor(UIUtil.getColor(isChoosed ? R.color.tag : R.color.black));
    }

    public void refresh(String day, String sale) {
        mDayLabel.setText(day);
        mSaleLabel.setText(sale);
    }

}
