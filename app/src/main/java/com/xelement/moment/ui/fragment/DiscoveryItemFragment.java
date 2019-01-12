package com.xelement.moment.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.entity.DiscoveryItemEntity;
import com.xelement.moment.ui.adapter.DiscoveryItemAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.GridSpacingItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryItemFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private DiscoveryItemAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.fragment_discovery_item;
    }

    @Override
    protected void initView() {
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, (int) UIUtil.getDimen(R.dimen.x14), true));
        adapter = new DiscoveryItemAdapter(R.layout.adapter_discovery_item, new ArrayList<DiscoveryItemEntity>());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getDiscoveryItemData());
    }
}
