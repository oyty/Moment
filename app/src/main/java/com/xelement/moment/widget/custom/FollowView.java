package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.ui.activity.AdmireDetailActivity;
import com.xelement.moment.ui.adapter.FollowItemAdapter;
import com.xelement.moment.util.CommonUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowView extends FrameLayout {

    private final Context mContext;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mCheckImg)
    ImageView mCheckImg;
    @BindView(R.id.mCheckAction)
    RelativeLayout mCheckAction;
    @BindView(R.id.mFollowImg)
    CircleImageView mFollowImg;
    @BindView(R.id.mArrowImg)
    ImageView mArrowImg;
    @BindView(R.id.mNicknameLabel)
    TextView mNicknameLabel;
    @BindView(R.id.mDesLabel)
    TextView mDesLabel;
    @BindView(R.id.mDetailAction)
    LinearLayout mDetailAction;
    @BindView(R.id.mNumLabel)
    TextView mNumLabel;
    @BindView(R.id.mTotalPriceLabel)
    TextView mTotalPriceLabel;
    @BindView(R.id.mDepositLabel)
    TextView mDepositLabel;
    private FollowItemAdapter adapter;
    private AdmireEntity entity;

    public FollowView(@NonNull Context context) {
        this(context, null);
    }

    public FollowView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_follow, this);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter = new FollowItemAdapter(R.layout.adapter_follow_item, new ArrayList<AdmireItemEntity>()));

    }

    public void refresh(AdmireEntity entity) {
        this.entity = entity;
        mCheckImg.setImageResource(entity.isChecked() ? R.mipmap.check_checked_follow : R.mipmap.check_normal);
        Glide.with(mContext)
                .load(entity.user.image)
                .into(mFollowImg);
        mNicknameLabel.setText(entity.user.nickname + "的跟单");
        mDesLabel.setText(entity.user.desc);
        adapter.setNewData(entity.products);
        mNumLabel.setText(entity.products.size() + "件商品，小计");
        mTotalPriceLabel.setText(CommonUtil.getPrice("", entity.total_price));
        mDepositLabel.setText(CommonUtil.getPrice("", entity.total_deposit));
    }


    @OnClick(R.id.mDetailAction)
    public void onViewClicked() {
        if(entity.isClickable()) {
            Intent intent = new Intent(mContext, AdmireDetailActivity.class);
            intent.putExtra(Constants.ADMIRE_DATA, entity);
            mContext.startActivity(intent);
        }
    }
}
