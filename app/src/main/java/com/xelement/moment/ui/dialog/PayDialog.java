package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.xelement.moment.R;
import com.xelement.moment.entity.ConfigEntity;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.PayTypeView;

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
    private OnPayActionListener listener;
    private CustomBottomSheet bottomSheetDialog;

    @BindView(R.id.mPayAction)
    TextView mPayAction;
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

    private int currentState = INIT_LOADING;

    public PayDialog(Context context, OnPayActionListener listener, DialogInterface.OnDismissListener dismissListener) {
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

    @OnClick(R.id.mPayAction)
    public void payAction() {
        if (listener != null) {
            listener.onPayAction();
        }
    }

    @OnClick(R.id.mCloseAction)
    public void closeAction() {
        if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
            bottomSheetDialog.dismiss();
        }
    }

    public void setPayPrice(String price) {
        mPayMoneyLabel.setText(String.format(Locale.CHINA, "%1$s", price));
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

    @OnClick({R.id.mFailDetailAction, R.id.mSuccessDetailAction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mFailDetailAction:
                if(listener != null) {
                    listener.onFailDetailAction();
                }
                bottomSheetDialog.dismiss();
                break;
            case R.id.mSuccessDetailAction:
                if(listener != null) {
                    listener.onSuccessDetailAction();
                }
                break;
        }
    }

    public boolean isPayedState() {
        return currentState == PAY_SUCCESS;
    }

    public interface OnPayActionListener {
        void onPayAction();
        void onFailDetailAction();
        void onSuccessDetailAction();
    }
}
