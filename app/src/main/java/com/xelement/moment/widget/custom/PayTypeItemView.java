package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.entity.PayTypeEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2018/8/31.
 */
public class PayTypeItemView extends FrameLayout {

    private Context mContext;

    @BindView(R.id.mIconImg)
    ImageView mIconImg;
    @BindView(R.id.mPayTypeLabel)
    TextView mPayTypeLabel;
    @BindView(R.id.mCheckImg)
    ImageView mCheckImg;
    @BindView(R.id.mLineView)
    View mLineView;

    public PayTypeItemView(@NonNull Context context) {
        this(context, null);
    }

    public PayTypeItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PayTypeItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_pay_type_item, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(PayTypeEntity entity, boolean showLine) {
        mLineView.setVisibility(showLine ? VISIBLE : GONE);
        mPayTypeLabel.setText(entity.name);
        if(entity.isWechat()) {
            mIconImg.setImageResource(R.mipmap.pay_wechat);
        } else if(entity.isAlipay()) {
            mIconImg.setImageResource(R.mipmap.pay_alipay);
        } else if(entity.isJD()) {
            mIconImg.setImageResource(R.mipmap.pay_jd);
        }
        mCheckImg.setBackgroundResource(entity.isChoosed() ? R.mipmap.check_checked : R.mipmap.check_normal);
    }

}
