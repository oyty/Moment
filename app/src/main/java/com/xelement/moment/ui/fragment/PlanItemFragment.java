package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.PlanGroupEntity;
import com.xelement.moment.entity.PlanMultipleType;
import com.xelement.moment.ui.adapter.PlanAdapter;
import com.xelement.moment.ui.adapter.PlanItemAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanItemFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mNumLabel)
    TextView mNumLabel;
    @BindView(R.id.mDesLeftLabel)
    TextView mDesLeftLabel;
    @BindView(R.id.mDesRightLabel)
    TextView mDesRightLabel;

    private PlanItemAdapter adapter;

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

        mRecyclerView.setAdapter(adapter = new PlanItemAdapter(R.layout.adapter_plan_item, new ArrayList<OrderEntity>()));
    }

    @Override
    protected void process() {
        int type = getArguments().getInt(Constants.PLAN_ITEM_TYPE);


        if(type == 0) {
            adapter.setNewData(new ArrayList<OrderEntity>());
        } else {
            String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
            if(!TextUtils.isEmpty(cache)) {
                List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
                });
                mDesLeftLabel.setText("您共有");
                mNumLabel.setText(entities.size() + "");
                mDesRightLabel.setText("件商品等待签收");

                adapter.setNewData(entities);
            } else {
                adapter.setNewData(new ArrayList<OrderEntity>());
            }
        }

    }
}
