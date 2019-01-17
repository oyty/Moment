package com.xelement.moment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.adapter.AdmireDetailAdapter;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.ToastUtil;
import com.xelement.moment.widget.custom.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/15.
 */
public class AdmireDetailActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mAdmireBarView)
    View mAdmireBarView;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mBackAction)
    View mBackAction;
    @BindView(R.id.mTitleLayout)
    View mTitleLayout;
    @BindView(R.id.mDesLabel)
    TextView mDesLabel;
    @BindView(R.id.mLikesLabel)
    TextView mLikesLabel;
    @BindView(R.id.mFollowImg)
    CircleImageView mFollowImg;
    @BindView(R.id.mNicknameLabel)
    TextView mNicknameLabel;
    @BindView(R.id.mTagLabel)
    TextView mTagLabel;
    @BindView(R.id.mLeftImg)
    ImageView mLeftImg;
    @BindView(R.id.mLeftAction)
    RelativeLayout mLeftAction;
    @BindView(R.id.mTotalPriceLabel)
    TextView mTotalPriceLabel;
    @BindView(R.id.mDepositDesLabel)
    TextView mDepositDesLabel;
    @BindView(R.id.mGoodLabel)
    TextView mGoodLabel;

    private AdmireDetailAdapter adapter;
    private AdmireEntity admireEntity;

    @Override
    public int initViewID() {
        return R.layout.activity_admire_detail;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mAdmireBarView);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(adapter = new AdmireDetailAdapter(R.layout.adapter_admire_detail, new ArrayList<AdmireItemEntity>()));
    }

    @Override
    protected void initViewListener() {
    }

    @Override
    protected void process() {

        admireEntity = getIntent().getParcelableExtra(Constants.ADMIRE_DATA);

        Glide.with(mContext)
                .load(admireEntity.image)
                .into(mProductImg);
//        mProductImg.setImageResource(admireEntity.image);

        Glide.with(mContext)
                .load(admireEntity.user.image)
                .into(mFollowImg);
//        mFollowImg.setImageResource(entity.user.image);
        mNicknameLabel.setText(admireEntity.user.nickname);
        mTagLabel.setText(admireEntity.user.tags.get(0));
        mDesLabel.setText(admireEntity.desc);

        mLikesLabel.setText(admireEntity.user.likes + "人跟单");
        mGoodLabel.setText((Integer.parseInt(admireEntity.user.likes) + 1234) + "");
        adapter.setNewData(admireEntity.products);
        mTotalPriceLabel.setText(CommonUtil.getPrice("合计 ", admireEntity.total_price));
        mDepositDesLabel.setText(CommonUtil.getPrice("时光定金", admireEntity.total_deposit));
    }

    @OnClick(R.id.mFollowAction)
    public void followAction() {
        String string = PreferenceHelper.getString(Constants.FOLLOW_DATA);
        List<AdmireEntity> entities;
        if(!TextUtils.isEmpty(string)) {
            entities = GsonUtil.json2Array(string, new TypeToken<List<AdmireEntity>>(){});
            for(AdmireEntity entity : entities) {
                if(entity.user.nickname.equals(admireEntity.user.nickname)) {
                    ToastUtil.show(mContext, "已在跟单列表中");
                    return;
                }
            }
            admireEntity.setChecked(true);
            entities.add(0, admireEntity);
            ToastUtil.show(mContext, "已加入跟单");
        } else {
            entities = new ArrayList<>();
            admireEntity.setChecked(true);
            entities.add(0, admireEntity);
            ToastUtil.show(mContext, "已加入跟单");
        }
        PreferenceHelper.putString(Constants.FOLLOW_DATA, GsonUtil.array2Json(entities));
    }

}
