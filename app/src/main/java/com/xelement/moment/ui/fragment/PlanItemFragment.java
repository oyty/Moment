package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.PlanGroupEntity;
import com.xelement.moment.entity.PlanMultipleType;
import com.xelement.moment.ui.adapter.PlanAdapter;
import com.xelement.moment.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanItemFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private PlanAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.fragment_plan_item;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);

        adapter = new PlanAdapter(R.layout.adapter_plan, new ArrayList<PlanGroupEntity>());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {
        int type = getArguments().getInt(Constants.PLAN_ITEM_TYPE);

        List<PlanGroupEntity> entities = DataUtil.getPlanWeekData();

        adapter.setNewData(entities);

    }
}
