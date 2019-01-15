package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/15.
 */
public class MomentFarmActivity extends BaseActivity {

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("时光农场");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_moment_farm;
    }

    @Override
    protected void process() {

    }
}
