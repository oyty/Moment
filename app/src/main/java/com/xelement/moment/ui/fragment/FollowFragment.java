package com.xelement.moment.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.MainActivity;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.ui.adapter.FollowAdapter;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.MultipleStatusView;
import com.xelement.moment.widget.custom.PublicTitleView;
import com.xelement.moment.widget.custom.SpacesVerticalItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowFragment extends BaseFragment {


    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mTotalPriceLabel)
    TextView mTotalPriceLabel;
    @BindView(R.id.mDepositDesLabel)
    TextView mDepositDesLabel;
    @BindView(R.id.mBottomView)
    View mBottomView;
    @BindView(R.id.mStatusView)
    MultipleStatusView mStatusView;

    private FollowAdapter adapter;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("我的跟单");
    }

    @Override
    public int initViewID() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new SpacesVerticalItemDecoration((int) UIUtil.getDimen(R.dimen.x12)));
        mRecyclerView.setAdapter(adapter = new FollowAdapter(R.layout.adapter_follow, new ArrayList<AdmireEntity>()));
    }

    @Override
    protected void process() {

        mStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra(Constants.MAIN_TYPE, DiscoveryFragment.class.getSimpleName());
                mContext.startActivity(intent);

            }
        });

        mStatusView.showEmpty();
    }

    @Override
    public void willBeDisplayed() {
        String cache = PreferenceHelper.getString(Constants.FOLLOW_DATA);
        if (!TextUtils.isEmpty(cache)) {
            List<AdmireEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<AdmireEntity>>() {
            });
            adapter.setNewData(entities);

            mBottomView.setVisibility(View.VISIBLE);

            float totalPrice = 0;
            float totalDeposit = 0;
            for(AdmireEntity entity : entities) {
                totalDeposit += Float.parseFloat(entity.total_deposit);
                totalPrice += Float.parseFloat(entity.total_price);
            }
            mTotalPriceLabel.setText(CommonUtil.getPrice("全选    合计", CommonUtil.getMoneyLabel(totalPrice + "")));
            mDepositDesLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(totalDeposit + "")));
            mStatusView.showContent();
        } else {
            mStatusView.showEmpty();
            mBottomView.setVisibility(View.GONE);
            adapter.setNewData(new ArrayList<AdmireEntity>());
        }

    }

}
