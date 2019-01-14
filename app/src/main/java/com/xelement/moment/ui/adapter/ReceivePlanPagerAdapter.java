package com.xelement.moment.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.util.UIUtil;

import java.util.List;

/**
 * Created by oyty on 2018/9/3.
 */
public class ReceivePlanPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    private String[] titles;

    public ReceivePlanPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        titles = UIUtil.getStringArray(R.array.receive_plan);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
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
