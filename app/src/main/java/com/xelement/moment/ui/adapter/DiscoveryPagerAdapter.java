package com.xelement.moment.ui.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.ui.fragment.DiscoveryHotFragment;
import com.xelement.moment.ui.fragment.DiscoveryItemFragment;

import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public DiscoveryPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public BaseFragment getItem(int position) {
        if(position == 0) {
            return new DiscoveryHotFragment();
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.POSITION, position);
            DiscoveryItemFragment fragment = new DiscoveryItemFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
