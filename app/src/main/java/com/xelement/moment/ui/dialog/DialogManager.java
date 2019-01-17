package com.xelement.moment.ui.dialog;

import java.util.PriorityQueue;

/**
 * Datetime: 2018/10/16 16:09
 * Author: zcj
 */
public class DialogManager {
    //数值越低，代表优先级越高，越先弹出来
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final int LEVEL_4 = 4;
    public static final int LEVEL_LOWEST = Integer.MAX_VALUE;
    public static final int LEVEL_HIGHEST = Integer.MIN_VALUE;

    private boolean isBlock = false;
    private AbstractPriorityDialog mCurrentShowDialog;
    private PriorityQueue<AbstractPriorityDialog> mDialogQueue;

    public DialogManager() {
        mDialogQueue = new PriorityQueue<>();
    }

    public void pause() {
        isBlock = true;
    }

    public void resume() {
        isBlock = false;
    }

    public void enqueue(AbstractPriorityDialog dialog) {
        mDialogQueue.add(dialog);
    }

    public void showNext() {
        if (isBlock) {
            return;
        }
        if (mCurrentShowDialog != null && mCurrentShowDialog.isShowing()) {
            return;
        }
        mCurrentShowDialog = mDialogQueue.poll();
        if (mCurrentShowDialog != null) {
            mCurrentShowDialog.show();
        }
    }

    public void release() {
        if (mCurrentShowDialog != null) {
            mCurrentShowDialog.dismiss();
        }
        mCurrentShowDialog = null;
        mDialogQueue.clear();
    }

    public AbstractPriorityDialog getCurrentShowDialog() {
        return mCurrentShowDialog;
    }
}