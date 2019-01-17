package com.xelement.moment.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import com.xelement.moment.R;
import com.xelement.moment.base.ShareConstant;
import com.xelement.moment.widget.custom.SharePlatformView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Datetime: 2018/9/4 9:46
 * Author: zcj
 */
public class SimpleShareDialog extends AbstractPriorityDialog {

    @BindView(R.id.mTitleLabel)
    TextView mTitleLabel;
    @BindView(R.id.mSharePlatformView)
    SharePlatformView mSharePlatformView;

    public SimpleShareDialog(Context context) {
        this(context, DialogManager.LEVEL_HIGHEST);
    }

    public SimpleShareDialog(Context context, int priority) {
        super(context, priority);

        createDialog(context);
    }


    @OnClick(R.id.mCancelAction)
    public void cancelAction() {
        mDialog.dismiss();
    }

    private void createDialog(Context context) {
        mDialog = new Dialog(context, R.style.CustomDialog);

        initView(context);
        initListener();
        initData();
        initStyle();
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.dialog_simple_social_share, null);
        ButterKnife.bind(this, view);

        mDialog.setContentView(view);
    }

    private void initListener() {
    }

    private void initData() {
        List<ShareConstant.SharePlatform> mPlatformList = new ArrayList<>();
        mPlatformList.add(ShareConstant.SharePlatform.WEI_CHAT);
        mPlatformList.add(ShareConstant.SharePlatform.MOMENT);
        mPlatformList.add(ShareConstant.SharePlatform.QQ);
        mPlatformList.add(ShareConstant.SharePlatform.QZONG);
        mPlatformList.add(ShareConstant.SharePlatform.WEI_BO);

        mSharePlatformView.setData(mPlatformList);
    }

    private void initStyle() {
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.AnimEnterExit);
    }

    public void setDismissListener(DialogInterface.OnDismissListener listener) {
        mDialog.setOnDismissListener(listener);
    }
}
