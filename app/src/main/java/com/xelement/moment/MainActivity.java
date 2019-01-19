package com.xelement.moment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.google.gson.reflect.TypeToken;
import com.jaeger.library.StatusBarUtil;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.event.DismissFreshEvent;
import com.xelement.moment.event.FollowNewEvent;
import com.xelement.moment.event.UpdateOrderEvent;
import com.xelement.moment.ui.adapter.MomentViewPagerAdapter;
import com.xelement.moment.ui.dialog.FreshDialog;
import com.xelement.moment.ui.fragment.AdmireFragment;
import com.xelement.moment.ui.fragment.DiscoveryFragment;
import com.xelement.moment.ui.fragment.FollowFragment;
import com.xelement.moment.ui.fragment.PersonalFragment;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.UIUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mViewPager)
    AHBottomNavigationViewPager mViewPager;
    @BindView(R.id.mBottomNavigation)
    AHBottomNavigation mBottomNavigation;
    @BindView(R.id.mMaskView)
    View mMaskView;

    private MomentViewPagerAdapter adapter;
    private FreshDialog dialog;
    private ArrayList<BaseFragment> fragments;

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

        PreferenceHelper.putString(Constants.ORDER_DATA, "");
        PreferenceHelper.putString(Constants.ADDRESS_DATA, "");
        PreferenceHelper.putString(Constants.FOLLOW_DATA, "");
        PreferenceHelper.putBoolean(Constants.IS_FIRST_MASK, false);
        dialog = new FreshDialog(mContext);
        mViewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        }, 1500);
        mBottomNavigation.setNotificationBackgroundColor(UIUtil.getColor(R.color.flash_red));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String type = intent.getStringExtra(Constants.MAIN_TYPE);
        boolean hasFound = false;
        if (TextUtils.isEmpty(type)) {
            mBottomNavigation.setCurrentItem(0);
        } else {
            for (int i = 0; i < fragments.size(); i++) {
                String simpleName = fragments.get(i).getClass().getSimpleName();
                if (simpleName.equals(type)) {
                    mBottomNavigation.setCurrentItem(i);
                    hasFound = true;
                    break;
                }
            }
            if (!hasFound) {
                mBottomNavigation.setCurrentItem(0);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
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

                adapter.getCurrentFragment().willBeDisplayed();
                return true;
            }
        });

        mViewPager.setOffscreenPageLimit(4);

        fragments = new ArrayList<>();
        fragments.add(new DiscoveryFragment());
        fragments.add(new AdmireFragment());
        fragments.add(new FollowFragment());
        fragments.add(new PersonalFragment());
        adapter = new MomentViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void followNewEvent(FollowNewEvent event) {
        String string = PreferenceHelper.getString(Constants.FOLLOW_DATA);
        if(!TextUtils.isEmpty(string)) {
            List<AdmireEntity> entities = GsonUtil.json2Array(string, new TypeToken<List<AdmireEntity>>(){});
            mBottomNavigation.setNotification(AHNotification.justText(entities.size() + ""), 2);
        } else {
            mBottomNavigation.setNotification((AHNotification) null, 2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DismissFreshEvent(DismissFreshEvent event) {
        dialog.dismiss();
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateOrderEvent(UpdateOrderEvent event) {
        boolean mask = PreferenceHelper.getBoolean(Constants.IS_FIRST_MASK, false);
        if(mask) {

        } else {
            mMaskView.setVisibility(View.VISIBLE);
            mMaskView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMaskView.setVisibility(View.GONE);
                    PreferenceHelper.putBoolean(Constants.IS_FIRST_MASK, true);
                }
            });
        }
    }

}
