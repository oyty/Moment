package com.xelement.moment.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.ui.adapter.OrderPagerAdapter;
import com.xelement.moment.ui.adapter.ReceivePlanPagerAdapter;
import com.xelement.moment.ui.fragment.PlanFragment;
import com.xelement.moment.ui.fragment.PlanItemFragment;
import com.xelement.moment.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/14.
 */
public class ReceivePlanActivity extends BaseActivity {

    @BindView(R.id.mTabLayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.mPlanBarView)
    View mPlanBarView;

    private ReceivePlanPagerAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.activity_receive_plan;
    }

    @Override
    public void initView() {
        List<BaseFragment> fragments = new ArrayList<>();
        PlanItemFragment fragment = new PlanItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.PLAN_ITEM_TYPE, 0);
        fragment.setArguments(bundle);
        fragments.add(fragment);

        fragments.add(new PlanFragment());

        PlanItemFragment fragment1 = new PlanItemFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt(Constants.PLAN_ITEM_TYPE, 1);
        fragment1.setArguments(bundle1);
        fragments.add(fragment1);


        adapter = new ReceivePlanPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        mTabLayout.setViewPager(mViewPager);
        mTabLayout.onPageSelected(0);
        CommonUtil.updateStatusBarHeight(mContext, mPlanBarView);
    }

    @Override
    protected void process() {

    }

    @OnClick(R.id.mLeftAction)
    public void leftAction() {
        finish();
    }
}
