package com.xelement.moment.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.ui.fragment.DiscoveryItemFragment;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/18.
 */
public class SearchResultActivity extends BaseActivity {

    @BindView(R.id.mSearchBarView)
    View mSearchBarView;
    @BindView(R.id.mSearchValue)
    TextView mSearchValue;

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
        String data = getIntent().getStringExtra(Constants.SEARCH_DATA);

        if(!TextUtils.isEmpty(data)) {
            mSearchValue.setText(data);
        }

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DiscoveryItemFragment fragment = new DiscoveryItemFragment();
        ft.replace(R.id.mContainerView, fragment);
        ft.commit();
    }

    @OnClick(R.id.mCancelAction)
    public void cancelAction() {
        finish();
    }
}
