package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/15.
 */
public class RechargeCenterActivity extends BaseActivity {

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("充值中心");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_recharge_center;
    }

    @Override
    protected void process() {

    }
}
