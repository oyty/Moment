package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xelement.moment.R;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.ui.adapter.FollowItemAdapter;
import com.xelement.moment.ui.adapter.PlanItemAdapter;
import com.xelement.moment.util.DataUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class PlanView extends FrameLayout {

    private final Context mContext;

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private PlanItemAdapter adapter;

    public PlanView(@NonNull Context context) {
        this(context, null);
    }

    public PlanView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_plan, this);
        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mRecyclerView.setAdapter(adapter = new PlanItemAdapter(R.layout.adapter_plan_item, new ArrayList<FollowItemEntity>()));
//
//        adapter.setNewData(DataUtil.getFollowItemData());
    }
}
