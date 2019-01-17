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
import com.xelement.moment.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowItemView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mSkuLabel)
    TextView mSkuLabel;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;

    public FollowItemView(@NonNull Context context) {
        this(context, null);
    }

    public FollowItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_follow_item, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(AdmireItemEntity entity) {
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mTitleLabel.setText(entity.title);
        mPriceLabel.setText(CommonUtil.getPrice("", entity.current_price));
        mMallPriceLabel.setText(CommonUtil.getPrice("", entity.mall_price));
        CommonUtil.updateStroke(mMallPriceLabel);
        String sku = "花白条纹，1件，15天收货（定金" + CommonUtil.getPrice("", entity.deposit) +"）";
        mSkuLabel.setText(CommonUtil.getColorfulString(sku, UIUtil.getColor(R.color.flash_red), 16, 16 + CommonUtil.getPrice("", entity.deposit).length()));
    }
}
