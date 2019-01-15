package com.xelement.moment.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.adapter.FresherAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.GridSpacingItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/15.
 */
public class FresherActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private FresherAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.activity_fresher;
    }

    @Override
    public void initView() {
        GridLayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, (int) UIUtil.getDimen(R.dimen.x18), true));
        mRecyclerView.setAdapter(adapter = new FresherAdapter(R.layout.adapter_fresher, new ArrayList<ProductEntity>()));
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getFresherData());
    }
}
