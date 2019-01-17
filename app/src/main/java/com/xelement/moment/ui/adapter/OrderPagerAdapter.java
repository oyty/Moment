package com.xelement.moment.ui.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.ui.fragment.OrderFragment;
import com.xelement.moment.util.UIUtil;

/**
 * Created by oyty on 2018/9/3.
 */
public class OrderPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = UIUtil.getStringArray(R.array.order_array);
    }

    @Override
    public Fragment getItem(int position) {
        OrderFragment fragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.ORDER_TYPE, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
