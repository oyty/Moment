package com.xelement.moment.ui.activity;

import android.view.View;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.util.CommonUtil;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/17.
 */
public class SearchActivity extends BaseActivity {

    @BindView(R.id.mSearchBarView)
    View mSearchBarView;

    @Override
    public int initViewID() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mSearchBarView);
    }

    @Override
    protected void process() {

    }
}
