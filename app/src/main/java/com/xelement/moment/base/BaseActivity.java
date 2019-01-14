package com.xelement.moment.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.xelement.moment.R;
import com.xelement.moment.util.AndroidBugUtil;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.PublicTitleView;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by oyty on 2018/8/15.
 */
public abstract class BaseActivity extends SwipeBackActivity {

    protected Context mContext;
    private PublicTitleView mTitleView;
    private QMUITipDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initBeforeSetView();
        setContentView(initViewID());
        AndroidBugUtil.assistActivity(findViewById(android.R.id.content));
        ButterKnife.bind(this);
        AppManager.getAppManager().addActivity(this);
        if (registerEventBus()) {
            EventBus.getDefault().register(this);
        }
        setSwipeBackEnable(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT && enableSwipeBack());
        initView();
        initViewListener();
        process();
        initTitleView();
        initTitleBar(mTitleView);
    }

    protected void initBeforeSetView() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        } else {
        StatusBarUtil.setTranslucent(this);
//        }
    }

    private void initTitleView() {
        mTitleView = (PublicTitleView) findViewById(R.id.mTitleView);
    }


    public void initTitleBar(PublicTitleView titleView) {
        if (titleView != null) {
            titleView.setLeftIcon(R.mipmap.back, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BaseActivity) mContext).finish();
                }
            });
        }
    }

    public abstract int initViewID();

    public void initView() {

    }

    protected void initViewListener() {

    }

    protected abstract void process();


    @Override
    protected void onDestroy() {
        CommonUtil.fixInputMethodManagerLeak(this);
        AppManager.getAppManager().finishActivity(this);
        //经测试发现，在高版本机型上，调用finish之后大概率onDestroy方法并不会立即执行(延迟可能在1~10s)
        //此时如果在新的页面正在请求网络，而旧页面刚好触发onDestroy，取消所有网络请求，就会发生问题
        //**************volley太老了，抽时间换一个网络库**************
        //RequestQueueHelper.newInstance().cancelPendingAllRequest();
        if (registerEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public void showProgressDialog() {
        try {
            View currentFocus = getCurrentFocus();
            QMUIKeyboardHelper.hideKeyboard(currentFocus);
        } catch (Exception ignored) {
        }
        if (mLoadingDialog == null) {
            mLoadingDialog = new QMUITipDialog.Builder(mContext)
                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                    .setTipWord(UIUtil.getString(R.string.loading))
                    .create();
        }
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing() && !isFinishing()) {
            mLoadingDialog.dismiss();
        }
    }

    public boolean enableSwipeBack() {
        return true;
    }

    public boolean registerEventBus() {
        return false;
    }

    public PublicTitleView getTitleView() {
        return mTitleView;
    }
}
