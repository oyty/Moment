package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.MyIntegerEditor;
import com.xelement.moment.widget.custom.ReceivePlanView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/15.
 */
public class SkuDialog {
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

    private int choosedTag;

    private final List<String> tags;
    private CustomBottomSheet bottomSheetDialog;
    private int choosedDay;

    public SkuDialog(Context context, List<String> tags) {
        this.tags = tags;
        bottomSheetDialog = new CustomBottomSheet(context);
        View view = View.inflate(context, R.layout.dialog_sku, null);
        ButterKnife.bind(this, view);

//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (UIUtil.getDimen(R.dimen.x420) * 2f));
        bottomSheetDialog.setContentView(view);

        mNumView.getEtView().setEnabled(false);
        choosedTag = 0;
        mTagLabel1.setText(tags.get(0));
        mTagLabel2.setText(tags.get(1));
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

        mPlanView7.refresh("7天", getSale(7));
        mPlanView15.refresh("15天", getSale(15));
        mPlanView30.refresh("30天", getSale(30));
        mPlanView60.refresh("60天", getSale(60));
        mPlanView90.refresh("90天", getSale(90));
        mPlanView180.refresh("180天", getSale(180));
        choosedDay = 7;
        updatePlan();

        mPlanView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 7;
                updatePlan();
            }
        });
        mPlanView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 15;
                updatePlan();
            }
        });
        mPlanView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 30;
                updatePlan();
            }
        });
        mPlanView60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 60;
                updatePlan();
            }
        });
        mPlanView90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 90;
                updatePlan();
            }
        });
        mPlanView180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosedDay = 180;
                updatePlan();
            }
        });
    }

    private void updatePlan() {
        mPlanView7.setChoosed(choosedDay == 7);
        mPlanView15.setChoosed(choosedDay == 15);
        mPlanView30.setChoosed(choosedDay == 30);
        mPlanView60.setChoosed(choosedDay == 60);
        mPlanView90.setChoosed(choosedDay == 90);
        mPlanView180.setChoosed(choosedDay == 180);
    }

    private String getSale(int sale) {
        return CommonUtil.getPrice("减", sale + "");
    }

    private void updateTag() {
        if (choosedTag == 0) {
            mTagLabel1.setTextColor(UIUtil.getColor(R.color.tag));
            mTagLabel1.setBackgroundResource(R.drawable.public_round_border_red);
            mTagLabel2.setTextColor(UIUtil.getColor(R.color.black));
            mTagLabel2.setBackgroundResource(R.drawable.public_round_grey_bg);
        } else {
            mTagLabel2.setTextColor(UIUtil.getColor(R.color.tag));
            mTagLabel2.setBackgroundResource(R.drawable.public_round_border_red);
            mTagLabel1.setTextColor(UIUtil.getColor(R.color.black));
            mTagLabel1.setBackgroundResource(R.drawable.public_round_grey_bg);
        }
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

}
