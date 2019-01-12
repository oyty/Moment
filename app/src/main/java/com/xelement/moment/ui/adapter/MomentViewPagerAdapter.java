package com.xelement.moment.ui.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.xelement.moment.base.BaseFragment;

import java.util.ArrayList;


/**
 * Created by oyty on 2019/1/12.
 */
public class MomentViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> fragments;
    private BaseFragment currentFragment;

    public MomentViewPagerAdapter(FragmentManager manager, ArrayList<BaseFragment> fragments) {
        super(manager);
        this.fragments = fragments;
    }

    @Override
    public BaseFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = (BaseFragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    public BaseFragment getCurrentFragment() {
        return currentFragment;
    }
}
