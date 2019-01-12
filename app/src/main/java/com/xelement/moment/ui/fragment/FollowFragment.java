package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.ui.adapter.FollowAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.PublicTitleView;
import com.xelement.moment.widget.custom.SpacesVerticalItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowFragment extends BaseFragment {


    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private FollowAdapter adapter;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("我的跟单");
    }

    @Override
    public int initViewID() {
        return R.layout.fragment_admire;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new SpacesVerticalItemDecoration((int) UIUtil.getDimen(R.dimen.x12)));
        mRecyclerView.setAdapter(adapter = new FollowAdapter(R.layout.adapter_follow, new ArrayList<FollowEntity>()));
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getFollowData());
    }
}
