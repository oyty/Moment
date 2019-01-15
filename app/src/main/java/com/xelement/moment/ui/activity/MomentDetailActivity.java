package com.xelement.moment.ui.activity;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.base.BannerImageLoader;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.adapter.StoreAdapter;
import com.xelement.moment.ui.dialog.PayDialog;
import com.xelement.moment.ui.dialog.SkuDialog;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class MomentDetailActivity extends BaseActivity implements DialogInterface.OnDismissListener, PayDialog.OnPayActionListener {

    @BindView(R.id.mPlanBarView)
    View mPlanBarView;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mBannerView)
    Banner mBannerView;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mTagLabel)
    TextView mTagLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;
    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mSkuLabel)
    TextView mSkuLabel;
    @BindView(R.id.mReceiveLabel)
    TextView mReceiveLabel;
    @BindView(R.id.mMomentPriceLabel)
    TextView mMomentPriceLabel;

    private StoreAdapter adapter;
    private PayDialog payDialog;
    private SkuDialog skuDialog;
    private boolean isFresher;
    private ProductEntity entity;

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
        isFresher = getIntent().getBooleanExtra(Constants.IS_FRESH, false);
        entity = getIntent().getParcelableExtra(Constants.DETAIL_DATA);

        updateView();

        adapter.setNewData(DataUtil.getStoreProductData());
    }

    private void updateView() {
        mBannerView.setImageLoader(new BannerImageLoader());
        mBannerView.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBannerView.setImages(entity.getImages());
        mBannerView.start();
        mBannerView.stopAutoPlay();

        mPriceLabel.setText(CommonUtil.getPrice("", "1.00"));
        mTagLabel.setText(isFresher ? "新人时光价" : "sss");
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.price));
        mMallPriceLabel.setPaintFlags(mMallPriceLabel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        mTitleLabel.setText(entity.title);

        mSkuLabel.setText(entity.getTags().get(0) + "，1件");
        mReceiveLabel.setText("7天收货");
        mMomentPriceLabel.setText("时光为您减免¥" + CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(entity.price) - 1)));
    }

    @OnClick(R.id.mDirectPayAction)
    public void directPayAction() {


    }

    @OnClick(R.id.mSkuAction)
    public void skuAction() {
        if (skuDialog == null) {
            skuDialog = new SkuDialog(mContext, entity.getTags());
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
