package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.entity.DaysEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.MyIntegerEditor;
import com.xelement.moment.widget.custom.ReceivePlanView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/15.
 */
public class SkuDialog {
    private DialogInterface.OnDismissListener dismissListener;
    private OnActionListener payListener;
    private ProductEntity entity;
    private boolean isFresher;
    @BindView(R.id.mNumView)
    MyIntegerEditor mNumView;
    @BindView(R.id.mTagLabel1)
    TextView mTagLabel1;
    @BindView(R.id.mTagLabel2)
    TextView mTagLabel2;
    @BindView(R.id.mPlanView7)
    ReceivePlanView mPlanView7;
    @BindView(R.id.mPlanView15)
    ReceivePlanView mPlanView15;
    @BindView(R.id.mPlanView30)
    ReceivePlanView mPlanView30;
    @BindView(R.id.mPlanView60)
    ReceivePlanView mPlanView60;
    @BindView(R.id.mPlanView90)
    ReceivePlanView mPlanView90;
    @BindView(R.id.mPlanView180)
    ReceivePlanView mPlanView180;
    @BindView(R.id.mProductImg)
    ImageView mProductImg;
    @BindView(R.id.mPriceLabel)
    TextView mPriceLabel;
    @BindView(R.id.mMallPriceLabel)
    TextView mMallPriceLabel;
    @BindView(R.id.mSkuLabel)
    TextView mSkuLabel;
    @BindView(R.id.mCustomPlanView)
    EditText mCustomPlanView;
    @BindView(R.id.mBenifitLabel)
    TextView mBenifitLabel;
    @BindView(R.id.mDirectLabel)
    TextView mDirectLabel;
    @BindView(R.id.mDepositLabel)
    TextView mDepositLabel;

    private int choosedTag;

    private List<String> tags;
    private CustomBottomSheet bottomSheetDialog;
    private int choosedDay;

    public SkuDialog(Context context, ProductEntity entity, boolean isFresher, DialogInterface.OnDismissListener listener, OnActionListener payActionListener) {
        this.dismissListener = listener;
        this.payListener = payActionListener;
        this.entity = entity;
        this.tags = entity.tags;
        this.isFresher = isFresher;
        bottomSheetDialog = new CustomBottomSheet(context);
        View view = View.inflate(context, R.layout.dialog_sku, null);
        ButterKnife.bind(this, view);

//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (UIUtil.getDimen(R.dimen.x420) * 2f));
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setOnDismissListener(listener);

        Glide.with(context)
                .load(entity.image)
                .into(mProductImg);

        mPriceLabel.setText(CommonUtil.getPrice("", entity.currentPrice));
        mMallPriceLabel.setText(CommonUtil.getPrice("某猫价：", entity.price));
        CommonUtil.updateStroke(mMallPriceLabel);

        mNumView.getEtView().setFocusable(false);

        if(isFresher) {
            mNumView.setVisibility(View.GONE);
        } else {
            mNumView.setVisibility(View.VISIBLE);
        }

        choosedTag = 0;
        mTagLabel1.setText(tags.get(0));
        mTagLabel2.setText(tags.get(1));
        choosedDay = entity.days_tag.get(entity.days_tag.size() - 1).day;
        updateTag();

        mTagLabel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedTag = 0;
                updateTag();
            }
        });
        mTagLabel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedTag = 1;
                updateTag();
            }
        });

        mPlanView7.setVisibility(View.GONE);
        mPlanView15.setVisibility(View.GONE);
        mPlanView30.setVisibility(View.GONE);
        mPlanView60.setVisibility(View.GONE);
        mPlanView90.setVisibility(View.GONE);
        mPlanView180.setVisibility(View.GONE);
        mCustomPlanView.setVisibility(View.GONE);

        if(isFresher) {
            mPlanView7.setVisibility(View.VISIBLE);
            mPlanView30.setVisibility(View.VISIBLE);
        } else {
            for(DaysEntity daysEntity : entity.days_tag) {
                if(daysEntity.day == 7) {
                    mPlanView7.setVisibility(View.VISIBLE);
                } else if(daysEntity.day == 15) {
                    mPlanView15.setVisibility(View.VISIBLE);
                } else if(daysEntity.day == 30) {
                    mPlanView30.setVisibility(View.VISIBLE);
                } else if(daysEntity.day == 60) {
                    mPlanView60.setVisibility(View.VISIBLE);
                } else if(daysEntity.day == 90) {
                    mPlanView90.setVisibility(View.VISIBLE);
                } else if(daysEntity.day == 180) {
                    mPlanView180.setVisibility(View.VISIBLE);
                }
            }
        }

        mPlanView7.refresh("7天", getSale(7));
        mPlanView15.refresh("15天", getSale(15));
        mPlanView30.refresh("30天", getSale(30));
        mPlanView60.refresh("60天", getSale(60));
        mPlanView90.refresh("90天", getSale(90));
        mPlanView180.refresh("180天", getSale(180));
        updatePlan();

        mPlanView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 7;
                updatePlan();
                updateSku();
            }
        });
        mPlanView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 15;
                updatePlan();
                updateSku();
            }
        });
        mPlanView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 30;
                updatePlan();
                updateSku();
            }
        });
        mPlanView60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 60;
                updatePlan();
                updateSku();
            }
        });
        mPlanView90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 90;
                updatePlan();
                updateSku();
            }
        });
        mPlanView180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 180;
                updatePlan();
                updateSku();
            }
        });

        mNumView.addOnAfterTextChangedListener(new MyIntegerEditor.OnAfterTextChangedListener() {
            @Override
            public void OnAfterTextChanged(int num) {
                updateSku();
            }
        });

    }

    public void updateSku() {
        mSkuLabel.setText(tags.get(choosedTag) + "，" + mNumView.getTextNum() + "件，" + "收货周期" + choosedDay + "天");

        if(isFresher) {
            mBenifitLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf((Float.parseFloat(entity.price) - 1) * Integer.parseInt(mNumView.getTextNum())))));
        } else {
            mBenifitLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(getBenifit() * Integer.parseInt(mNumView.getTextNum())))));
        }

        if(isFresher) {
            mDepositLabel.setText(choosedDay == 7 ? CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(0.5f * Integer.parseInt(mNumView.getTextNum())))) : CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(0.99f * Integer.parseInt(mNumView.getTextNum())))));
        } else {
            mDepositLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(getDeposit()) * Integer.parseInt(mNumView.getTextNum())))));
        }
        mDirectLabel.setText(CommonUtil.getPrice("", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(entity.currentPrice) * Integer.parseInt(mNumView.getTextNum())))));

//        dismissListener.onDismiss(bottomSheetDialog);
    }

    public float getBenifit() {
        for(DaysEntity daysEntity : entity.days_tag) {
            if(daysEntity.day == choosedDay) {
                return daysEntity.benifit;
            }
        }
        return 0;
    }

    private void updatePlan() {
        mPlanView7.setChoosed(choosedDay == 7);
        mPlanView15.setChoosed(choosedDay == 15);
        mPlanView30.setChoosed(choosedDay == 30);
        mPlanView60.setChoosed(choosedDay == 60);
        mPlanView90.setChoosed(choosedDay == 90);
        mPlanView180.setChoosed(choosedDay == 180);

        mDepositLabel.setText(CommonUtil.getPrice("", getDeposit()));
    }

    private String getSale(int sale) {
        if(isFresher) {
            return CommonUtil.getPrice("减", CommonUtil.getMoneyLabel(String.valueOf(Float.parseFloat(entity.price) - 1)) + "");
        } else {
            for(DaysEntity daysEntity : entity.days_tag) {
                if(daysEntity.day == sale) {
                    return CommonUtil.getPrice("减", CommonUtil.getMoneyLabel(daysEntity.benifit + ""));
                }
            }
            return "";
        }
    }

    private void updateTag() {
        if (choosedTag == 0) {
            mTagLabel1.setTextColor(UIUtil.getColor(R.color.tag));
            mTagLabel1.setBackgroundResource(R.drawable.public_round_border_red);
            mTagLabel2.setTextColor(UIUtil.getColor(R.color.flash_grey));
            mTagLabel2.setBackgroundResource(R.drawable.public_round_grey_bg);
        } else {
            mTagLabel2.setTextColor(UIUtil.getColor(R.color.tag));
            mTagLabel2.setBackgroundResource(R.drawable.public_round_border_red);
            mTagLabel1.setTextColor(UIUtil.getColor(R.color.flash_grey));
            mTagLabel1.setBackgroundResource(R.drawable.public_round_grey_bg);
        }
        updateSku();
    }

    public void show() {
        if (bottomSheetDialog != null) {
            bottomSheetDialog.show();
        }
    }

    public boolean isShowing() {
        if (bottomSheetDialog != null) {
            return bottomSheetDialog.isShowing();
        }
        return false;
    }

    public String getChoosedTag() {
        return tags.get(choosedTag);
    }

    public String getNum() {
        return mNumView.getTextNum();
    }

    public String getDays() {
        return choosedDay + "";
    }

    public String getDeposit() {
        if(isFresher) {
            return choosedDay == 7 ? "0.50" : "0.99";
        } else {
            for(DaysEntity daysEntity : entity.days_tag) {
                if(daysEntity.day == choosedDay) {
                    return daysEntity.deposit;
                }
            }
        }
        return "";
    }

    @OnClick(R.id.mCloseAction)
    public void closeAction() {
        bottomSheetDialog.dismiss();
    }

    @OnClick(R.id.mDownPayAction)
    public void downPayAction() {
        payListener.onDownPay();
    }

    @OnClick(R.id.mDirectPayAction)
    public void directPayAction() {
        payListener.onDirectPay();
    }

    public void dismiss() {
        bottomSheetDialog.dismiss();
    }

    public interface OnActionListener {
        void onDownPay();
        void onDirectPay();
    }
}
