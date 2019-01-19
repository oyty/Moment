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
import com.xelement.moment.event.DismissFreshEvent;
import com.xelement.moment.ui.activity.MomentDetailActivity;
import com.xelement.moment.util.CommonUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class FreshView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mCurrentPriceLabel)
    TextView mCurrentPriceLabel;

    private ProductEntity entity;

    public FreshView(@NonNull Context context) {
        this(context, null);
    }

    public FreshView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FreshView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_fresh, this);
        ButterKnife.bind(this, view);
        CommonUtil.updateStroke(mPriceLabel);
    }

    public void refresh(ProductEntity entity) {
        this.entity = entity;
//        mProductImg.setImageResource(entity.image);
        Glide.with(mContext)
                .load(entity.image)
                .into(mProductImg);
        mTitleLabel.setText(entity.title);
        mPriceLabel.setText(String.format(Locale.CHINA, "¥%1$s", entity.price));
        mCurrentPriceLabel.setText(CommonUtil.getPrice("", entity.currentPrice));
    }

    @OnClick(R.id.mBuyAction)
    public void onViewClicked() {
        if(entity.isClickable()) {
            Intent intent = new Intent(mContext, MomentDetailActivity.class);
            intent.putExtra(Constants.DETAIL_DATA, entity);
            intent.putExtra(Constants.IS_FRESH, true);
            mContext.startActivity(intent);
            EventBus.getDefault().post(new DismissFreshEvent());
        }
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        onViewClicked();
    }
}
