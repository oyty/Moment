package com.xelement.moment.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.adapter.AdmireDetailAdapter;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.widget.custom.ParallaxScrollView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/15.
 */
public class AdmireDetailActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mAdmireBarView)
    View mAdmireBarView;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mBackAction)
    View mBackAction;
    @BindView(R.id.mTitleLayout)
    View mTitleLayout;

    private AdmireDetailAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.activity_admire_detail;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mAdmireBarView);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setAdapter(adapter = new AdmireDetailAdapter(R.layout.adapter_admire_detail, new ArrayList<ProductEntity>()));
    }

    @Override
    protected void initViewListener() {
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getAdmireDetailData());
    }

}
