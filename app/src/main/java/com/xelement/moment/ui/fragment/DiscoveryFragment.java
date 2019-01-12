package com.xelement.moment.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.ui.adapter.DiscoveryPagerAdapter;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryFragment extends BaseFragment {

    @BindView(R.id.mDiscoveryBarView)
    View mDiscoveryBarView;
    @BindView(R.id.mTabLayout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    private DiscoveryPagerAdapter adapter;

    private String[] titles = {
            "热门", "百货", "数码", "食品", "电器", "家居", "母婴", "家居", "母婴", "家居", "母婴", "家居", "母婴"
    };

    @Override
    public int initViewID() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mDiscoveryBarView);
    }

    @Override
    protected void process() {
        adapter = new DiscoveryPagerAdapter(getChildFragmentManager(), titles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setViewPager(mViewPager);
        mTabLayout.onPageSelected(0);
    }
}
