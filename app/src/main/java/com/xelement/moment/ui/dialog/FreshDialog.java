package com.xelement.moment.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.xelement.moment.R;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.FreshView;
import com.xelement.moment.widget.custom.FresherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2018/10/11.
 */
public class FreshDialog {

    private final Context mContext;
    private Dialog mDialog;


    private View.OnClickListener listener;

    public FreshDialog(Context context) {
        this.mContext = context;
        createDialog(context);
    }

    public void setPayClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    private void createDialog(Context context) {
        mDialog = new Dialog(context, R.style.CustomDialog);

        initView(context);
        initListener();
        initStyle();
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.dialog_pocket, null);
        ButterKnife.bind(this, view);

        FreshView freshView1 = view.findViewById(R.id.mFreshView1);
        FreshView freshView2 = view.findViewById(R.id.mFreshView2);
        FreshView freshView3 = view.findViewById(R.id.mFreshView3);

        freshView1.refresh(DataUtil.getFresherData().get(0));
//        freshView2.refresh(DataUtil.getFresherData().get(1));
//        freshView3.refresh(DataUtil.getFresherData().get(2));
        mDialog.setContentView(view);
    }

    private void initListener() {
    }

    private void initStyle() {
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = (int) UIUtil.getDimen(R.dimen.x620);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.AnimInOut);
    }

    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }
}
