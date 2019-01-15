package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.ui.adapter.OrderAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesVerticalItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class OrderFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private OrderAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new SpacesVerticalItemDecoration((int) UIUtil.getDimen(R.dimen.x20)));
        adapter = new OrderAdapter(R.layout.adapter_order, new ArrayList<OrderEntity>());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getOrderData());
    }
}
