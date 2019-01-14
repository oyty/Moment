package com.xelement.moment.ui.activity;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.widget.custom.PublicTitleView;

/**
 * Created by oyty on 2019/1/14.
 */
public class PersonalInfoActivity extends BaseActivity {


    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("设置");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected void process() {

    }
}
