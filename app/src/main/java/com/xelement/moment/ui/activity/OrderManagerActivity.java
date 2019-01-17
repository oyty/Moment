package com.xelement.moment.ui.activity;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;

import com.flyco.tablayout.SlidingTabLayout;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.ui.adapter.OrderPagerAdapter;
import com.xelement.moment.widget.custom.PublicTitleView;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class OrderManagerActivity extends BaseActivity {
    @BindView(R.id.mTabLayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    private OrderPagerAdapter adapter;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle(R.string.my_order);
    }

    @Override
    public int initViewID() {
        return R.layout.activity_order_manager;
    }

    @Override
    public void initView() {
        adapter = new OrderPagerAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(adapter);
        mTabLayout.setViewPager(mViewPager);
        mTabLayout.onPageSelected(0);
    }

    @Override
    protected void initViewListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void process() {
        int tab = getIntent().getIntExtra(Constants.ORDER_TYPE, 0);
        mViewPager.setCurrentItem(tab);
    }
}
