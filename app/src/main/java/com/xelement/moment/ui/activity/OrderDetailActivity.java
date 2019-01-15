package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/15.
 */
public class OrderDetailActivity extends BaseActivity {


    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("订单详情");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void process() {

    }
}
