package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.ui.adapter.AdmireAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.PublicTitleView;
import com.xelement.moment.widget.custom.SpacesVerticalItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/12.
 */
public class AdmireFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private AdmireAdapter adapter;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("时光草园");
    }

    @Override
    public int initViewID() {
        return R.layout.fragment_admire;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new SpacesVerticalItemDecoration((int) UIUtil.getDimen(R.dimen.x12)));
        mRecyclerView.setAdapter(adapter = new AdmireAdapter(R.layout.adapter_admire, new ArrayList<AdmireEntity>()));
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getAdmireData());
    }
}
