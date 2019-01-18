package com.xelement.moment.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.ui.fragment.DiscoveryItemFragment;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/18.
 */
public class SearchResultActivity extends BaseActivity {

    @BindView(R.id.mSearchBarView)
    View mSearchBarView;

    @Override
    public int initViewID() {
        return R.layout.activity_search_result;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mSearchBarView);
    }

    @Override
    protected void process() {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DiscoveryItemFragment fragment = new DiscoveryItemFragment();
        ft.replace(R.id.mContainerView, fragment);
        ft.commit();
    }
}
