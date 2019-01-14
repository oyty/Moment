package com.xelement.moment.ui.fragment;

import android.content.Intent;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.ui.activity.AddressActivity;
import com.xelement.moment.ui.activity.OrderManagerActivity;
import com.xelement.moment.ui.activity.PersonalInfoActivity;

import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class PersonalFragment extends BaseFragment {

    @Override
    public int initViewID() {
        return R.layout.fragment_personal;
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


}
