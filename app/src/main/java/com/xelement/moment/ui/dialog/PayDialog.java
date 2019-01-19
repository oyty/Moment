package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.gson.reflect.TypeToken;
import com.xelement.moment.MainActivity;
import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.ConfigEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.event.DismissSkuEvent;
import com.xelement.moment.event.FollowNewEvent;
import com.xelement.moment.event.GotoHomeEvent;
import com.xelement.moment.event.NewEntityEvent;
import com.xelement.moment.event.UpdateOrderEvent;
import com.xelement.moment.ui.activity.EditAddressActivity;
import com.xelement.moment.ui.fragment.DiscoveryFragment;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DateTimeUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.PayTypeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by oyty on 2018/8/27.
 */
public class PayDialog {

    private static final int INIT_LOADING = 0x01;
    private static final int PAY_STATE = 0x02;
    private static final int PAY_LOADING = 0x03;
    private static final int PAY_SUCCESS = 0x04;
    private static final int PAY_FAIL = 0x05;
    private final Context mContext;
    private OnPayActionListener listener;
    private CustomBottomSheet bottomSheetDialog;

    @BindView(R.id.mLoadingView)
    LinearLayout mLoadingView;
    @BindView(R.id.mFailLayout)
    LinearLayout mFailLayout;
    @BindView(R.id.mFailView)
    RelativeLayout mFailView;
    @BindView(R.id.mPaySuccessLabel)
    TextView mPaySuccessLabel;
    @BindView(R.id.mSuccessView)
    RelativeLayout mSuccessView;
    @BindView(R.id.mPayTypeView)
    PayTypeView mPayTypeView;
    @BindView(R.id.mProgressView)
    View mProgressView;
    @BindView(R.id.mPayMoneyLabel)
    TextView mPayMoneyLabel;
    @BindView(R.id.mPayView)
    View mPayView;
    @BindView(R.id.mPriceLeftLabel)
    TextView mPriceLeftLabel;
    @BindView(R.id.mDesLabel)
    TextView mDesLabel;
    @BindView(R.id.mPayDesLabel)
    TextView mPayDesLabel;
    @BindView(R.id.mSuccessLeftLabel)
    TextView mSuccessLeftLabel;
    @BindView(R.id.mSuccessRightLabel)
    TextView mSuccessRightLabel;
    @BindView(R.id.mDirectPayAction)
    View mDirectPayAction;
    @BindView(R.id.mSuccessDesLabel)
    TextView mSuccessDesLabel;
    @BindView(R.id.mDownPayAction)
    View mDownPayAction;
    @BindView(R.id.mSuccessBottomView)
    View mSuccessBottomView;

    private int currentState = INIT_LOADING;
    private String deposit;
    private String price;
    private boolean isDeposit;
    private String depositAfter;
    private ProductEntity entity;
    private String sku;
    private String days;
    private String count;


    public PayDialog(Context context, OnPayActionListener listener, DialogInterface.OnDismissListener dismissListener) {
        this.mContext = context;
        this.listener = listener;
        bottomSheetDialog = new CustomBottomSheet(context);
        View view = View.inflate(context, R.layout.dialog_pay, null);
        ButterKnife.bind(this, view);
        mPayMoneyLabel.setTypeface(CommonUtil.getPriceTypeface(context));
        mPaySuccessLabel.setTypeface(CommonUtil.getPriceTypeface(context));

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (UIUtil.getDimen(R.dimen.x420) * 2f));
        bottomSheetDialog.setContentView(view, params);

        bottomSheetDialog.setOnDismissListener(dismissListener);
        queryConfig();
    }

    private void queryConfig() {
        String str = "{\"login_verify\":1000,\"switch_ad\":1,\"switch_pay\":[{\"name\":\"微信（推荐使用）\",\"pay_channel\":\"1\",\"icon\":\"FlmSzxaehxXem_31gsJzoTdl5S-O\",\"pay_platform\":\"1\",\"limit\":\"1\",\"limit_desc\":\"2\",\"limit_high\":\"2\",\"limit_high_desc\":\"2\",\"limit_low_hc\":\"2\",\"limit_low_hc_desc\":\"2\",\"limit_high_hc\":\"2\",\"limit_high_hc_desc\":\"2\"},{\"name\":\"支付宝\",\"pay_channel\":\"2\",\"icon\":\"FlAZXCK0rs1f4ehat52bIAk4Cvnc\",\"pay_platform\":\"1\",\"limit\":\"1\",\"limit_desc\":\"2\",\"limit_high\":\"2\",\"limit_high_desc\":\"2\",\"limit_low_hc\":\"2\",\"limit_low_hc_desc\":\"2\",\"limit_high_hc\":\"2\",\"limit_high_hc_desc\":\"2\"},{\"name\":\"京东\",\"pay_channel\":\"3\",\"icon\":\"FveMmDxHlBuZ6mBZ6oGmMiKSPDy9\",\"pay_platform\":\"1\",\"limit\":\"1\",\"limit_desc\":\"2\",\"limit_high\":\"2\",\"limit_high_desc\":\"2\",\"limit_low_hc\":\"2\",\"limit_low_hc_desc\":\"2\",\"limit_high_hc\":\"2\",\"limit_high_hc_desc\":\"2\"}]}";
        mPayTypeView.refresh(GsonUtil.json2Bean(str, ConfigEntity.class));
        currentState = PAY_STATE;
        updateView();
    }

    private void updateView() {
        mPayView.setVisibility(currentState == PAY_STATE ? View.VISIBLE : View.GONE);
        mProgressView.setVisibility(currentState == INIT_LOADING ? View.VISIBLE : View.GONE);
        mLoadingView.setVisibility(currentState == PAY_LOADING ? View.VISIBLE : View.GONE);
        mSuccessView.setVisibility(currentState == PAY_SUCCESS ? View.VISIBLE : View.GONE);
        mFailView.setVisibility(currentState == PAY_FAIL ? View.VISIBLE : View.GONE);
    }

    public void show() {
        if (bottomSheetDialog != null) {
            bottomSheetDialog.show();
        }
        mProgressView.setVisibility(View.VISIBLE);
        queryConfig();
    }

    public boolean isShowing() {
        if (bottomSheetDialog != null) {
            return bottomSheetDialog.isShowing();
        }
        return false;
    }

    public void dismiss() {
        if (isShowing()) {
            bottomSheetDialog.dismiss();
        }
    }

//    @OnClick(R.id.mPayAction)
//    public void payAction() {
//        if (listener != null) {
//            listener.onPayAction();
//        }
//    }

    @OnClick(R.id.mCloseAction)
    public void closeAction() {
        if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
            bottomSheetDialog.dismiss();
        }
    }

    public void setPayPrice(String deposit, String price, String depositAfter, boolean isDeposit, ProductEntity entity, String tag, String days, String count) {
        this.entity = entity;
        this.sku = tag;
        this.days = days;
        this.deposit = deposit;
        this.price = price;
        this.isDeposit = isDeposit;
        this.depositAfter = depositAfter;
        this.count = count;
        update();
        mPayView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
        mSuccessView.setVisibility(View.GONE);
    }

    private void update() {
        if (isDeposit) {
            mPayMoneyLabel.setText(CommonUtil.getPrice("", deposit));
            mPriceLeftLabel.setText(CommonUtil.getPrice("支付全款", price));
            mPayDesLabel.setText("确认支付定金");
            mDesLabel.setText("支付定金");
        } else {
            mPayMoneyLabel.setText(CommonUtil.getPrice("", price));
            mPriceLeftLabel.setText(CommonUtil.getPrice("支付定金", deposit));
            mPayDesLabel.setText("确认支付全款");
            mDesLabel.setText("支付全款");
        }
    }

    public int getPayChannel() {
        return mPayTypeView.getPayChannel();
    }

    public int getPayPlatform() {
        return mPayTypeView.getPayPlatform();
    }

    public void payLoading() {
        currentState = PAY_LOADING;
        updateView();
    }

    public void paySuccess(String payAmount) {
        currentState = PAY_SUCCESS;
        mPaySuccessLabel.setText(String.format(Locale.CHINA, "¥%1$s", payAmount));
        updateView();
    }

    public void payFail() {
        currentState = PAY_FAIL;
        updateView();
    }

    @OnClick({R.id.mFailDetailAction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mFailDetailAction:
                if (listener != null) {
                    listener.onFailDetailAction();
                }
                bottomSheetDialog.dismiss();
                break;
        }
    }

    @OnClick(R.id.mDirectPayAction)
    public void directPayAction() {
        if (isDeposit) {
            isDeposit = false;
        } else {
            isDeposit = true;
        }
        update();
    }

    @OnClick(R.id.mDownPayAction)
    public void payAction() {
        mDesLabel.setText("支付结果");
        mPayView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingView.setVisibility(View.GONE);
                mSuccessView.setVisibility(View.VISIBLE);
                if (isDeposit) {

                    mSuccessLeftLabel.setText(CommonUtil.getPrice("继续支付尾款\n", depositAfter));
                    mSuccessRightLabel.setText("逛逛其它");
                    mSuccessLeftLabel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPayMoneyLabel.setText(CommonUtil.getPrice("", depositAfter));
                            mPayView.setVisibility(View.VISIBLE);
                            mSuccessView.setVisibility(View.GONE);
                            mDirectPayAction.setVisibility(View.GONE);
                            mPayDesLabel.setText("确认支付");
                            mDesLabel.setText("确认支付尾款");
                            isDeposit = false;
                        }
                    });
                    mSuccessRightLabel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dismiss();
                            EventBus.getDefault().post(new GotoHomeEvent());
                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.putExtra(Constants.MAIN_TYPE, DiscoveryFragment.class.getSimpleName());
                            mContext.startActivity(intent);
                        }
                    });
                    mSuccessDesLabel.setText(CommonUtil.getPrice("恭喜成功支付定金，还需支付尾款", depositAfter));

                    if(entity == null) {
                        PreferenceHelper.putString(Constants.FOLLOW_DATA, "");
                        EventBus.getDefault().post(new FollowNewEvent());
                        return;
                    }
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.image = entity.image;
                    orderEntity.title = entity.title;
                    orderEntity.price = entity.price;
                    orderEntity.current_price = entity.currentPrice;
                    orderEntity.deposit_after = depositAfter;
                    orderEntity.deposit = deposit;
                    orderEntity.sku = sku;
                    orderEntity.tag1 = days + "天发货";
                    orderEntity.days = days;
                    orderEntity.count = count;
                    orderEntity.time = DateTimeUtil.getCurrentTime();
                    orderEntity.tag2 = CommonUtil.getPrice("时光减免", CommonUtil.getMoneyLabel(String.valueOf((Float.parseFloat(entity.price) - Float.parseFloat(entity.currentPrice)) * Integer.parseInt(count))));
                    orderEntity.status = 0;
                    String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
                    List<OrderEntity> entities;
                    if (!TextUtils.isEmpty(cache)) {
                        entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
                        });
                    } else {
                        entities = new ArrayList<>();
                    }
                    entities.add(0, orderEntity);
                    PreferenceHelper.putString(Constants.ORDER_DATA, GsonUtil.array2Json(entities));


                } else {
                    mSuccessDesLabel.setText("您已成功支付全款，可以确认收货地址，也可等商品发货前通知您填写哦~");
                    mSuccessLeftLabel.setText("逛逛其它");
                    mSuccessLeftLabel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dismiss();
                            EventBus.getDefault().post(new GotoHomeEvent());
                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.putExtra(Constants.MAIN_TYPE, DiscoveryFragment.class.getSimpleName());
                            mContext.startActivity(intent);
                        }
                    });
                    mSuccessRightLabel.setText("确认收货地址");
                    mSuccessRightLabel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mContext.startActivity(new Intent(mContext, EditAddressActivity.class));
                            EventBus.getDefault().post(new DismissSkuEvent());
                            dismiss();
                        }
                    });
                    if(entity == null) {
                        PreferenceHelper.putString(Constants.FOLLOW_DATA, "");
                        EventBus.getDefault().post(new FollowNewEvent());

                        return;
                    }
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.image = entity.image;
                    orderEntity.title = entity.title;
                    orderEntity.price = entity.price;
                    orderEntity.deposit_after = depositAfter;
                    orderEntity.deposit = deposit;
                    orderEntity.count = count;
                    orderEntity.current_price = entity.currentPrice;
                    orderEntity.sku = sku;
                    orderEntity.days = days;
                    orderEntity.tag1 = days + "天发货";
                    orderEntity.tag2 = CommonUtil.getPrice("时光减免", CommonUtil.getMoneyLabel(String.valueOf((Float.parseFloat(entity.price) - Float.parseFloat(entity.currentPrice)) * Integer.parseInt(count))));
                    orderEntity.status = 1;
                    orderEntity.time = DateTimeUtil.getCurrentTime();
                    String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
                    List<OrderEntity> entities;
                    if (!TextUtils.isEmpty(cache)) {
                        entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
                        });
                    } else {
                        entities = new ArrayList<>();
                    }
                    entities.add(0, orderEntity);
                    PreferenceHelper.putString(Constants.ORDER_DATA, GsonUtil.array2Json(entities));


                }

                EventBus.getDefault().post(new UpdateOrderEvent());

            }
        }, 2000);
    }

    public boolean isPayedState() {
        return currentState == PAY_SUCCESS;
    }

    public void setPrice(final OrderEntity entity) {
        mPayMoneyLabel.setText(CommonUtil.getPrice("", entity.deposit_after));
        mPayView.setVisibility(View.VISIBLE);
        mSuccessView.setVisibility(View.GONE);
        mDirectPayAction.setVisibility(View.GONE);
        mPayDesLabel.setText("确认支付");
        mDesLabel.setText("确认支付尾款");
        mDownPayAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDesLabel.setText("支付结果");
                mPayView.setVisibility(View.GONE);
                mLoadingView.setVisibility(View.VISIBLE);
                mLoadingView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingView.setVisibility(View.GONE);
                        mSuccessView.setVisibility(View.VISIBLE);
                        mSuccessBottomView.setVisibility(View.GONE);
                        entity.status = 1;
                        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                EventBus.getDefault().post(new NewEntityEvent(entity));
                            }
                        });
                    }
                }, 2000);
            }
        });
    }

    public interface OnPayActionListener {
        void onPayAction();

        void onFailDetailAction();

        void onSuccessDetailAction();
    }
}
