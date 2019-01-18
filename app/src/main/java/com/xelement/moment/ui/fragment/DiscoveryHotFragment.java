package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BannerImageLoader;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.event.UpdateOrderEvent;
import com.xelement.moment.ui.activity.FresherActivity;
import com.xelement.moment.ui.activity.MomentFarmActivity;
import com.xelement.moment.ui.activity.ReceivePlanActivity;
import com.xelement.moment.ui.activity.RechargeCenterActivity;
import com.xelement.moment.ui.adapter.DiscoveryFollowAdapter;
import com.xelement.moment.ui.adapter.DiscoveryHotAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.BadgeView;
import com.xelement.moment.widget.custom.FloatingNotificationView;
import com.xelement.moment.widget.custom.SpacesItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryHotFragment extends BaseFragment {
    @BindView(R.id.mBannerView)
    Banner mBannerView;
    @BindView(R.id.mHotRecyclerView)
    RecyclerView mHotRecyclerView;
    @BindView(R.id.mFollowRecyclerView)
    RecyclerView mFollowRecyclerView;
    @BindView(R.id.mBadgeThisView)
    BadgeView mBadgeView;
    @BindView(R.id.mFloatingView)
    FloatingNotificationView mFloatingView;

    private DiscoveryHotAdapter hotAdapter;
    private DiscoveryFollowAdapter followAdapter;

    @Override
    public int initViewID() {
        return R.layout.fragment_discovery_hot;
    }

    @Override
    protected void initView() {

        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mHotRecyclerView.setLayoutManager(manager);
        mHotRecyclerView.setHasFixedSize(true);
        mHotRecyclerView.setNestedScrollingEnabled(false);
        hotAdapter = new DiscoveryHotAdapter(R.layout.adapter_discovery_hot, new ArrayList<ProductEntity>());
        mHotRecyclerView.setAdapter(hotAdapter);
        LinearSnapHelper hotHelper = new LinearSnapHelper();
        hotHelper.attachToRecyclerView(mHotRecyclerView);
        mHotRecyclerView.addItemDecoration(new SpacesItemDecoration((int) UIUtil.getDimen(R.dimen.x10)));

        LinearLayoutManager followManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        followManager.setSmoothScrollbarEnabled(true);
        followManager.setAutoMeasureEnabled(true);
        mFollowRecyclerView.setLayoutManager(followManager);
        mFollowRecyclerView.setHasFixedSize(true);
        mFollowRecyclerView.setNestedScrollingEnabled(false);
        followAdapter = new DiscoveryFollowAdapter(R.layout.adapter_discovery_follow, new ArrayList<AdmireEntity>());
        mFollowRecyclerView.setAdapter(followAdapter);
        LinearSnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(mFollowRecyclerView);
        mFollowRecyclerView.addItemDecoration(new SpacesItemDecoration((int) UIUtil.getDimen(R.dimen.x10)));

        mBadgeView.setBadgeBackgroundColor(UIUtil.getColor(R.color.flash_red));
        mBadgeView.setTextColor(UIUtil.getColor(R.color.white));
    }

    @Override
    protected void process() {
        hotAdapter.setNewData(DataUtil.getHotData());
        followAdapter.setNewData(DataUtil.getAdmireData());

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.banner1);
        images.add(R.mipmap.banner2);
        images.add(R.mipmap.banner3);
        images.add(R.mipmap.banner4);
        mBannerView.setImageLoader(new BannerImageLoader());
        mBannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBannerView.setImages(images);
        mBannerView.start();
        mBannerView.stopAutoPlay();

        updateOrderEvent(new UpdateOrderEvent());

        mFloatingView.refresh();
    }

    @OnClick(R.id.mReceivePlanAction)
    public void receivePlanAction(){
        mContext.startActivity(new Intent(mContext, ReceivePlanActivity.class));
    }

    @OnClick(R.id.mFresherAction)
    public void fresherAction() {
        mContext.startActivity(new Intent(mContext, FresherActivity.class));
    }

    @OnClick(R.id.mMomentPartAction)
    public void momentPartyAction() {
        mContext.startActivity(new Intent(mContext, MomentFarmActivity.class));
    }

    @OnClick(R.id.mRechargeCenterAction)
    public void rechargeCenterAction() {
        mContext.startActivity(new Intent(mContext, RechargeCenterActivity.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateOrderEvent(UpdateOrderEvent event) {
        String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
            });
            List<OrderEntity> orderEntities = new ArrayList<>();
            for (OrderEntity entity : entities) {
                if (entity.status == 1) {
                    orderEntities.add(entity);
                }
            }
            if(orderEntities.isEmpty()) {
                mBadgeView.setText(View.GONE);
                mBadgeView.setText(orderEntities.size());
            } else {
                mBadgeView.setText(View.VISIBLE);
                mBadgeView.setText(orderEntities.size());
            }

        }
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }
}
