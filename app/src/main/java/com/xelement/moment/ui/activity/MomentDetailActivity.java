package com.xelement.moment.ui.activity;

import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.adapter.DiscoveryHotAdapter;
import com.xelement.moment.ui.adapter.StoreAdapter;
import com.xelement.moment.ui.dialog.PayDialog;
import com.xelement.moment.ui.dialog.SkuDialog;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class MomentDetailActivity extends BaseActivity implements DialogInterface.OnDismissListener, PayDialog.OnPayActionListener {

    @BindView(R.id.mPlanBarView)
    View mPlanBarView;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private StoreAdapter adapter;
    private PayDialog payDialog;
    private SkuDialog skuDialog;

    @Override
    public int initViewID() {
        return R.layout.activity_moment_detail;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mPlanBarView);


        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        adapter = new StoreAdapter(R.layout.adapter_store, new ArrayList<ProductEntity>());
        mRecyclerView.setAdapter(adapter);
        LinearSnapHelper hotHelper = new LinearSnapHelper();
        hotHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration((int) UIUtil.getDimen(R.dimen.x10)));
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getStoreProductData());
    }

    @OnClick(R.id.mDirectPayAction)
    public void directPayAction() {


    }

    @OnClick(R.id.mSkuAction)
    public void skuAction() {
        if (skuDialog == null) {
            skuDialog = new SkuDialog(mContext);
        }
//        payDialog.setPayPrice(useOrderPayPrice ? String.format(Locale.CHINA, "¥%1$s", CommonUtil.getMoneyLabel(orderEntity.pay_price)) : mOrderSumLabel.getText().toString().trim());
        if (!skuDialog.isShowing()) {
            skuDialog.show();
        }
    }

    @OnClick(R.id.mDownPayAction)
    public void downPayAction() {
        if (payDialog == null) {
            payDialog = new PayDialog(mContext, this, this);
        }
//        payDialog.setPayPrice(useOrderPayPrice ? String.format(Locale.CHINA, "¥%1$s", CommonUtil.getMoneyLabel(orderEntity.pay_price)) : mOrderSumLabel.getText().toString().trim());
        if (!payDialog.isShowing()) {
            payDialog.show();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }

    @Override
    public void onPayAction() {

    }

    @Override
    public void onFailDetailAction() {

    }

    @Override
    public void onSuccessDetailAction() {

    }
}
