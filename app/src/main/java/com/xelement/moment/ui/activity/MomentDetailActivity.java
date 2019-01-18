package com.xelement.moment.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xelement.moment.MainActivity;
import com.xelement.moment.R;
import com.xelement.moment.base.BannerImageLoader;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.DaysEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.event.DismissSkuEvent;
import com.xelement.moment.event.GotoHomeEvent;
import com.xelement.moment.ui.adapter.StoreAdapter;
import com.xelement.moment.ui.dialog.PayDialog;
import com.xelement.moment.ui.dialog.SkuDialog;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

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
    @BindView(R.id.mCommentLabel)
    TextView mCommentLabel;
    @BindView(R.id.mNicePriceLabel)
    TextView mNicePriceLabel;
    @BindView(R.id.mDirectBuyLabel)
    TextView mDirectBuyLabel;
    @BindView(R.id.mDepositBuyLabel)
    TextView mDepositBuyLabel;

    private StoreAdapter adapter;
    private PayDialog payDialog;
    private SkuDialog skuDialog;
    private boolean isFresher;
    private ProductEntity entity;
    private String days;
    private String count;
    private String choosedTag;
    private String deposit;

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

        adapter.setNewData(isFresher ? DataUtil.getFresherData() : DataUtil.getHotData());
    }

    private void updateView() {
        mBannerView.setImageLoader(new BannerImageLoader());
        mBannerView.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBannerView.setImages(entity.getImages());
        mBannerView.start();
        mBannerView.stopAutoPlay();


        mTagLabel.setText(isFresher ? "新人时光价" : "时光惊喜价");
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.price));
        CommonUtil.updateStroke(mMallPriceLabel);
        mTitleLabel.setText(entity.title);

        days = String.valueOf(entity.days_tag.get(entity.days_tag.size() - 1).day);
        count = "1";
        choosedTag = entity.getTags().get(0);
        if(isFresher) {
            deposit = "0.50";
        } else {
            deposit = entity.days_tag.get(entity.days_tag.size() - 1).deposit;
        }

        updateSku();

        mCommentLabel.setText(entity.comment);

    }

    private void updateSku() {
        mPriceLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(getPrice()))));

        mSkuLabel.setText(choosedTag + "，" + count +"件");
        mReceiveLabel.setText(days + "天收货");
        mMomentPriceLabel.setText("时光为您减免¥" + CommonUtil.getMoneyLabel(String.valueOf(getBenifit() * Integer.parseInt(count))));

        mDirectBuyLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(entity.currentPrice) * Integer.parseInt(count)))));
        mDepositBuyLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(deposit) * Integer.parseInt(count)))));

        if(isFresher) {
            mNicePriceLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(entity.price) - Float.parseFloat(entity.currentPrice)))));
        } else {
            mNicePriceLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(getBenifit() * Integer.parseInt(count)))));
        }
    }

    public float getBenifit() {
        if(isFresher) {
            return Float.parseFloat(entity.price) - 1.0f;
        }
        for(DaysEntity daysEntity : entity.days_tag) {
            if(daysEntity.day == Integer.parseInt(days)) {
                return daysEntity.benifit;
            }
        }
        return 0;
    }

    public float getPrice() {
        if(isFresher) {
            return 1.0f;
        }
        for(DaysEntity daysEntity : entity.days_tag) {
            if(daysEntity.day == Integer.parseInt(days)) {
                return daysEntity.current_price;
            }
        }
        return 0;
    }

    @OnClick(R.id.mDirectPayAction)
    public void directPayAction() {
        pay(false);
    }

    @OnClick(R.id.mSkuAction)
    public void skuAction() {
        if (skuDialog == null) {
            skuDialog = new SkuDialog(mContext, entity, isFresher, new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    backData();
                    updateSku();
                }
            }, new SkuDialog.OnActionListener() {
                @Override
                public void onDownPay() {
                    backData();
                    downPayAction();
                }

                @Override
                public void onDirectPay() {
                    backData();
                    directPayAction();
                }
            });
        }
//        payDialog.setPayPrice(useOrderPayPrice ? String.format(Locale.CHINA, "¥%1$s", CommonUtil.getMoneyLabel(orderEntity.pay_price)) : mOrderSumLabel.getText().toString().trim());
        if (!skuDialog.isShowing()) {
            skuDialog.show();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dismissEvent(DismissSkuEvent event) {
        if(skuDialog.isShowing()) {
            skuDialog.dismiss();
        }
    }

    private void backData() {
        choosedTag = skuDialog.getChoosedTag();
        count = skuDialog.getNum();
        days = skuDialog.getDays();
        deposit = skuDialog.getDeposit();
        updateSku();
    }

    @OnClick(R.id.mLeftAction)
    public void finishAction() {
        finish();
    }

    @OnClick(R.id.mDownPayAction)
    public void downPayAction() {
        pay(true);
    }

    @OnClick(R.id.mDirectPayAction)
    public void mDirectPayAction() {
        pay(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void gotoHomeEvent(GotoHomeEvent event) {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
        finish();
    }

    private void pay(boolean isDeposit) {
        payDialog = new PayDialog(mContext, this, this);
        payDialog.setPayPrice(CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(deposit) * Integer.parseInt(count))),
                CommonUtil.getMoneyLabel(String.valueOf((getPrice()) * Integer.parseInt(count))),
                isFresher ? CommonUtil.getMoneyLabel(String.valueOf((1 - Float.parseFloat(deposit)) * Integer.parseInt(count))) : CommonUtil.getMoneyLabel(String.valueOf((getPrice() - Float.parseFloat(deposit)) * Integer.parseInt(count))),
                isDeposit, entity, mSkuLabel.getText().toString().trim(), days, count);
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
    public boolean registerEventBus() {
        return true;
    }
}
