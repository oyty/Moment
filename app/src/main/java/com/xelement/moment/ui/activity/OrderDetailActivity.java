package com.xelement.moment.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.event.NewEntityEvent;
import com.xelement.moment.ui.dialog.PayDialog;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.OrderAddressView;
import com.xelement.moment.widget.custom.OrderView;
import com.xelement.moment.widget.custom.PublicTitleView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/15.
 */
public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.mTitleView)
    PublicTitleView mTitleView;
    @BindView(R.id.mStatusImg)
    ImageView mStatusImg;
    @BindView(R.id.mStatusDesLabel)
    TextView mStatusDesLabel;
    @BindView(R.id.mOrderAddressView)
    OrderAddressView mOrderAddressView;
    @BindView(R.id.mCurrentLabel)
    TextView mCurrentLabel;
    @BindView(R.id.mCurrentDesLabel)
    TextView mCurrentDesLabel;
    @BindView(R.id.mLastLabel)
    TextView mLastLabel;
    @BindView(R.id.mLastView)
    LinearLayout mLastView;
    @BindView(R.id.mDepositLabel)
    TextView mDepositLabel;
    @BindView(R.id.mDaysLabel)
    TextView mDaysLabel;
    @BindView(R.id.mOrderView)
    OrderView mOrderView;
    @BindView(R.id.mDetailPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mDepositLastLabel)
    TextView mDepositLastLabel;
    @BindView(R.id.mSecondLastLabel)
    TextView mSecondLastLabel;
    @BindView(R.id.mDetailLastPayLabel)
    TextView mLastPayLabel;
    @BindView(R.id.mDayBottomLabel)
    TextView mDayBottomLabel;
    @BindView(R.id.mLastActionLabel)
    TextView mLastActionLabel;
    @BindView(R.id.mTimeLabel2)
    TextView mTimeLabel2;
    @BindView(R.id.mTimeLabel1)
    TextView mTimeLabel1;
    @BindView(R.id.mTimeLabel3)
    TextView mTimeLabel3;
    private OrderEntity entity;
    private PayDialog payDialog;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("订单详情");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void process() {
        entity = getIntent().getParcelableExtra(Constants.ORDER_DATA);
        update();
    }

    private void update() {
        mStatusImg.setImageResource(entity.status == 0 ? R.mipmap.for_last : R.mipmap.for_receive);
        mStatusDesLabel.setText(entity.status == 0 ? CommonUtil.getPrice("待支付尾款", entity.deposit_after) : "待收货");

        mOrderAddressView.refresh();

        mDepositLabel.setText(CommonUtil.getPrice("已支付第一阶段付款(定金", entity.deposit) + ")");
        mDepositLastLabel.setText(CommonUtil.getPrice("", entity.deposit));
        mPriceLabel.setText(CommonUtil.getPrice("", entity.current_price));

        mDayBottomLabel.setText(entity.days + "天");

        mLastActionLabel.setText(entity.status == 0 ? CommonUtil.getPrice("支付尾款", entity.deposit_after) : "确认收货");


        mTimeLabel1.setText(entity.time);
        mTimeLabel2.setText(entity.time);
        mTimeLabel3.setText(entity.time);

        if (entity.status == 0) {
            mCurrentLabel.setText(CommonUtil.getPrice("等待支付剩余尾款", entity.deposit_after));
            mCurrentDesLabel.setText("支付尾款后，才能顺利收到商品哦");
            String str = "第2阶段尾款付款(未完成)";
            mSecondLastLabel.setText(CommonUtil.getColorfulString(str, UIUtil.getColor(R.color.flash_red), 8, str.length()));
            mLastPayLabel.setText(CommonUtil.getPrice("", entity.deposit_after));
            mLastView.setVisibility(View.GONE);
        } else {
            mCurrentLabel.setText("请耐心等待商品到货");
            mCurrentDesLabel.setText("商品发货后，地址将不可更改，请确认您的地址");
            mLastLabel.setText(CommonUtil.getPrice("已支付第二阶段付款(尾款", entity.deposit_after) + ")");

            mSecondLastLabel.setText("第2阶段尾款付款(已完成)");
            mLastView.setVisibility(View.VISIBLE);
        }

        mOrderView.refreshDetail(entity);
        if (entity.status == 0) {
            mLastActionLabel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    payDialog = new PayDialog(mContext, null, null);
                    payDialog.setPrice(entity);
                    if (!payDialog.isShowing()) {
                        payDialog.show();
                    }
                }
            });
        } else {
            mLastActionLabel.setOnClickListener(null);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mOrderAddressView.refresh();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void newEntityEvent(NewEntityEvent event) {
        this.entity = event.entity;
        update();
    }

    @Override
    public boolean registerEventBus() {
        return true;
    }
}
