package com.xelement.moment.ui.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.CircleImageView;
import com.xelement.moment.widget.custom.PublicTitleView;
import com.xelement.moment.widget.custom.RowIconView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/14.
 */
public class PersonalInfoActivity extends BaseActivity {


    @BindView(R.id.mTitleView)
    PublicTitleView mTitleView;
    @BindView(R.id.mAvatarImg)
    CircleImageView mAvatarImg;
    @BindView(R.id.mUpdateAvatarAction)
    RelativeLayout mUpdateAvatarAction;
    @BindView(R.id.mNicknameView)
    RowIconView mNicknameView;
    @BindView(R.id.mMobileView)
    RowIconView mMobileView;
    @BindView(R.id.mNinetyIdView)
    RowIconView mNinetyIdView;
    @BindView(R.id.mSoundView)
    RowIconView mSoundView;
    @BindView(R.id.mPushSwitchView)
    RowIconView mPushSwitchView;
    @BindView(R.id.mClearCacheView)
    RowIconView mClearCacheView;
    @BindView(R.id.mServiceView)
    RowIconView mServiceView;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("设置");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected void process() {
        mNicknameView.setValue("神奇小胖子");
        mNinetyIdView.setValue("289236482332");
    }

}
