package com.xelement.moment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.jaeger.library.StatusBarUtil;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.event.DismissFreshEvent;
import com.xelement.moment.ui.adapter.MomentViewPagerAdapter;
import com.xelement.moment.ui.dialog.FreshDialog;
import com.xelement.moment.ui.fragment.AdmireFragment;
import com.xelement.moment.ui.fragment.DiscoveryFragment;
import com.xelement.moment.ui.fragment.FollowFragment;
import com.xelement.moment.ui.fragment.PersonalFragment;
import com.xelement.moment.util.UIUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mViewPager)
    AHBottomNavigationViewPager mViewPager;
    @BindView(R.id.mBottomNavigation)
    AHBottomNavigation mBottomNavigation;
    private MomentViewPagerAdapter adapter;
    private FreshDialog dialog;
    @Override
    protected void initBeforeSetView() {
        StatusBarUtil.setTransparent(this);
    }

    @Override
    public int initViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void process() {
        initUI();

        dialog = new FreshDialog(mContext);
        dialog.show();
    }

    private void initUI() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("发现", R.mipmap.navi_discovery, R.color.bid_cd0061);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("种草", R.mipmap.navi_admire, R.color.bid_cd0061);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("跟单", R.mipmap.navi_follow, R.color.bid_cd0061);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("我", R.mipmap.navi_me, R.color.bid_cd0061);

        List<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);

        mBottomNavigation.addItems(bottomNavigationItems);
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mBottomNavigation.setAccentColor(UIUtil.getColor(R.color.bid_cd0061));
        mBottomNavigation.setInactiveColor(UIUtil.getColor(R.color.flash_black));
        mBottomNavigation.setBehaviorTranslationEnabled(false);

        mBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // true: was already selected
                if (wasSelected) {
//                    currentFragment.refresh();
                    return true;
                }

                mViewPager.setCurrentItem(position, false);

                return true;
            }
        });


        mViewPager.setOffscreenPageLimit(4);
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new DiscoveryFragment());
        fragments.add(new AdmireFragment());
        fragments.add(new FollowFragment());
        fragments.add(new PersonalFragment());
        adapter = new MomentViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DismissFreshEvent(DismissFreshEvent event) {
        dialog.dismiss();
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }
}
