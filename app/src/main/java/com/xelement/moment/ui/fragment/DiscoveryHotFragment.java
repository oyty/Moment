package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.ui.activity.ReceivePlanActivity;
import com.xelement.moment.ui.adapter.DiscoveryFollowAdapter;
import com.xelement.moment.ui.adapter.DiscoveryHotAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesItemDecoration;
import com.youth.banner.Banner;

import java.util.ArrayList;

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
        hotAdapter = new DiscoveryHotAdapter(R.layout.adapter_discovery_hot, new ArrayList<DiscoveryHotEntity>());
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
        followAdapter = new DiscoveryFollowAdapter(R.layout.adapter_discovery_follow, new ArrayList<FollowEntity>());
        mFollowRecyclerView.setAdapter(followAdapter);
        LinearSnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(mFollowRecyclerView);
        mFollowRecyclerView.addItemDecoration(new SpacesItemDecoration((int) UIUtil.getDimen(R.dimen.x10)));
    }

    @Override
    protected void process() {
        hotAdapter.setNewData(DataUtil.getDiscoveryHotData());
        followAdapter.setNewData(DataUtil.getFollowData());
    }

    @OnClick(R.id.mReceivePlanAction)
    public void receivePlanAction(){
        mContext.startActivity(new Intent(mContext, ReceivePlanActivity.class));
    }

    @OnClick(R.id.mFresherAction)
    public void fresherAction() {

    }

    @OnClick(R.id.mMomentPartAction)
    public void momentPartyAction() {

    }

    @OnClick(R.id.mRechargeCenterAction)
    public void rechargeCenterAction() {

    }

}
