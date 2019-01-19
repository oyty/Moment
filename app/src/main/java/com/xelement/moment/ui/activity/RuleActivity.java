package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/19.
 */
public class RuleActivity extends BaseActivity {


    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("减免规则");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_rule;
    }

    @Override
    protected void process() {

    }
}
