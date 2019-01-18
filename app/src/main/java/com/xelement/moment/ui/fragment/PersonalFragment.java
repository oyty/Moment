package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.event.UpdateOrderEvent;
import com.xelement.moment.ui.activity.AddressActivity;
import com.xelement.moment.ui.activity.CouponActivity;
import com.xelement.moment.ui.activity.MessageActivity;
import com.xelement.moment.ui.activity.OrderManagerActivity;
import com.xelement.moment.ui.activity.PersonalInfoActivity;
import com.xelement.moment.ui.dialog.SimpleShareDialog;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.widget.custom.OrderTypeView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by oyty on 2019/1/12.
 */
public class PersonalFragment extends BaseFragment {

    @BindView(R.id.mPersonalBarView)
    View mPersonalBarView;
    @BindView(R.id.mPayDepositView)
    OrderTypeView mPayDepositView;
    @BindView(R.id.mPayLastView)
    OrderTypeView mPayLastView;
    @BindView(R.id.mWaitToReceiveView)
    OrderTypeView mWaitToReceiveView;
    @BindView(R.id.mWaitToRemarkView)
    OrderTypeView mWaitToRemarkView;
    @BindView(R.id.mAfterSoldView)
    OrderTypeView mAfterSoldView;

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

    @OnClick(R.id.mCouponAction)
    public void couponAction() {
        mContext.startActivity(new Intent(mContext, CouponActivity.class));
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

    @OnClick(R.id.mShareView)
    public void shareAction() {
        SimpleShareDialog dialog = new SimpleShareDialog(mContext);
        dialog.show();
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateOrderEvent(UpdateOrderEvent event) {
        String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
            });
            List<OrderEntity> entityList = new ArrayList<>();
            for(OrderEntity entity : entities) {
                if(entity.status == 1){
                    entityList.add(entity);
                }
            }
            mWaitToReceiveView.setMessage(entityList.size());

            List<OrderEntity> entityList1 = new ArrayList<>();
            for(OrderEntity entity : entities) {
                if(entity.status == 0){
                    entityList1.add(entity);
                }
            }
            mPayLastView.setMessage(entityList1.size());
        }
    }

    @OnClick({R.id.mPayDepositView, R.id.mPayLastView, R.id.mWaitToReceiveView, R.id.mWaitToRemarkView, R.id.mAfterSoldView})
    public void onViewClicked(View view) {
        Intent intent = new Intent(mContext, OrderManagerActivity.class);
        switch (view.getId()) {
            case R.id.mPayDepositView:
                intent.putExtra(Constants.ORDER_TYPE, 1);
                break;
            case R.id.mPayLastView:
                intent.putExtra(Constants.ORDER_TYPE, 2);
                break;
            case R.id.mWaitToReceiveView:
                intent.putExtra(Constants.ORDER_TYPE, 3);
                break;
            case R.id.mWaitToRemarkView:
                intent.putExtra(Constants.ORDER_TYPE, 4);
                break;
            case R.id.mAfterSoldView:
                intent.putExtra(Constants.ORDER_TYPE, 5);
                break;
        }
        mContext.startActivity(intent);
    }
}
