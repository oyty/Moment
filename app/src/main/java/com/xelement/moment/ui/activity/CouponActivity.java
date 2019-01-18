package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/18.
 */
public class CouponActivity extends BaseActivity {

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("我的优惠券");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_coupon;
    }

    @Override
    protected void process() {

    }
}
