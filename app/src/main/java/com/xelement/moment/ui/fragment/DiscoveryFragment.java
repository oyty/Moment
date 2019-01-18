package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.event.UpdateOrderEvent;
import com.xelement.moment.ui.activity.MessageActivity;
import com.xelement.moment.ui.activity.SearchActivity;
import com.xelement.moment.ui.adapter.DiscoveryPagerAdapter;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.PreferenceHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

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
            "热门", "3C数码", "宠物生活", "服饰内衣", "家电", "家居家具", "美食饮料"
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

    @OnClick(R.id.mSearchAction)
    public void searchAction() {
        mContext.startActivity(new Intent(mContext, SearchActivity.class));
    }

    @OnClick(R.id.mMessageView)
    public void notificationAction() {
        mContext.startActivity(new Intent(mContext, MessageActivity.class));
    }

}
