package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.event.FollowNewEvent;
import com.xelement.moment.ui.activity.AdmireDetailActivity;
import com.xelement.moment.util.AddToCartAnimUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.ScreenUtil;
import com.xelement.moment.util.ToastUtil;
import com.xelement.moment.util.UIUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class AdmireView extends FrameLayout {

    private final Context mContext;
    @BindView(R.id.mFollowImg)
    CircleImageView mFollowImg;
    @BindView(R.id.mNicknameLabel)
    TextView mNicknameLabel;
    @BindView(R.id.mTagLabel)
    TextView mTagLabel;
    @BindView(R.id.mAdmireDesLabel)
    TextView mAdmireDesLabel;
    @BindView(R.id.mImage1)
    ImageView mImage1;
    @BindView(R.id.mImage2)
    ImageView mImage2;
    @BindView(R.id.mImage3)
    ImageView mImage3;
    @BindView(R.id.mBaseAction)
    LinearLayout mBaseAction;
    @BindView(R.id.mNumLabel)
    TextView mNumLabel;
    @BindView(R.id.mLikesLabel)
    TextView mLikesLabel;
    private AdmireEntity admireEntity;

    public AdmireView(@NonNull Context context) {
        this(context, null);
    }

    public AdmireView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdmireView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_admire, this);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        if(admireEntity.isClickable()) {
            Intent intent = new Intent(mContext, AdmireDetailActivity.class);
            intent.putExtra(Constants.ADMIRE_DATA, admireEntity);
            mContext.startActivity(intent);
        }
    }

    public void refresh(AdmireEntity entity) {
        this.admireEntity = entity;
        Glide.with(mContext)
                .load(entity.user.image)
                .into(mFollowImg);
//        mFollowImg.setImageResource(entity.user.image);
        mNicknameLabel.setText(entity.user.nickname);
        mTagLabel.setText(entity.user.tags.get(0));
        mAdmireDesLabel.setText(entity.desc);
        Glide.with(mContext)
                .load(entity.products.get(0).image)
                .into(mImage1);
        Glide.with(mContext)
                .load(entity.products.get(1).image)
                .into(mImage2);
        Glide.with(mContext)
                .load(entity.products.get(2).image)
                .into(mImage3);
        mLikesLabel.setText(entity.user.likes + "人跟单");
        mNumLabel.setText(entity.products.size() + "件");
//        mImage1.setImageResource(entity.products.get(0).image);
//        mImage2.setImageResource(entity.products.get(1).image);
//        mImage3.setImageResource(entity.products.get(2).image);
    }

    @OnClick(R.id.mFollowAction)
    public void followAction() {
        if(!admireEntity.isClickable()) {
            return;
        }
        String string = PreferenceHelper.getString(Constants.FOLLOW_DATA);
        List<AdmireEntity> entities;
        if(!TextUtils.isEmpty(string)) {
            entities = GsonUtil.json2Array(string, new TypeToken<List<AdmireEntity>>(){});
            for(AdmireEntity entity : entities) {
                if(entity.user.nickname.equals(admireEntity.user.nickname)) {
                    ToastUtil.show(mContext, "已在跟单列表中");
                    AddToCartAnimUtil.startAnim((BaseActivity)mContext, (FrameLayout) ((BaseActivity)mContext).getWindow().getDecorView(), new PointF(UIUtil.getDimen(R.dimen.x448), ScreenUtil.getDeviceHeight() - 40), admireEntity.products.get(0).image);
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
        EventBus.getDefault().post(new FollowNewEvent());
        AddToCartAnimUtil.startAnim((BaseActivity)mContext, (FrameLayout) ((BaseActivity)mContext).getWindow().getDecorView(), new PointF(UIUtil.getDimen(R.dimen.x448), ScreenUtil.getDeviceHeight() - 40), admireEntity.products.get(0).image);
    }
}
