package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.ui.activity.AddressActivity;
import com.xelement.moment.ui.activity.MessageActivity;
import com.xelement.moment.ui.activity.OrderManagerActivity;
import com.xelement.moment.ui.activity.PersonalInfoActivity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class PersonalFragment extends BaseFragment {

    @BindView(R.id.mPersonalBarView)
    View mPersonalBarView;

    @Override
    public int initViewID() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mPersonalBarView);
    }

    @Override
    protected void process() {

    }

    @OnClick(R.id.mPersonalInfoAction)
    public void personalInfoAction() {
        Intent intent = new Intent(mContext, PersonalInfoActivity.class);
        mContext.startActivity(intent);
    }

    @OnClick(R.id.mAddressView)
    public void addressAction() {
        mContext.startActivity(new Intent(mContext, AddressActivity.class));
    }

    @OnClick(R.id.mOrderManagerAction)
    public void orderManagerAction() {
        mContext.startActivity(new Intent(mContext, OrderManagerActivity.class));
    }

    @OnClick(R.id.mNotificationAction)
    public void notificationAction() {
        mContext.startActivity(new Intent(mContext, MessageActivity.class));
    }


}
