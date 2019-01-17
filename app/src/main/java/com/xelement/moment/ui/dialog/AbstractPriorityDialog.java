package com.xelement.moment.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;


import com.xelement.moment.util.CommonUtil;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

/**
 * Datetime: 2018/10/13 11:52
 * Author: zcj
 */
public abstract class AbstractPriorityDialog implements IPriorityDialog {

    protected Dialog mDialog;
    protected WeakReference<Context> mContextReference;

    private @Priority
    int mPriority;

    public AbstractPriorityDialog(Context context, @Priority int priority) {
        this.mContextReference = new WeakReference<>(context);
        this.mPriority = priority;
    }

    @Override
    public void show() {
        Context context = mContextReference.get();
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!CommonUtil.isActivityDestroyed(activity)) {
                mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                    }
                });
                mDialog.show();
            }
        }
    }

    @Override
    public void dismiss() {
        Context context = mContextReference.get();
        if (context == null
                || (context instanceof Activity
                && CommonUtil.isActivityDestroyed((Activity) context))) {
            return;
        }
        if (context instanceof Activity) {
            if (mDialog.isShowing()) {
                //mDialog.dismiss();
                mDialog.cancel();
            }
        }
    }

    @Override
    public boolean isShowing() {
        return mDialog.isShowing();
    }

    @Override
    public int getPriority() {
        return mPriority;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        if (o instanceof AbstractPriorityDialog) {
            return this.mPriority - ((AbstractPriorityDialog) o).mPriority;
        } else {
            return 1;
        }
    }
}
