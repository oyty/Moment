package com.xelement.moment.ui.dialog;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_1;
import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_2;
import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_3;
import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_4;
import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_HIGHEST;
import static com.xelement.moment.ui.dialog.DialogManager.LEVEL_LOWEST;


/**
 * Datetime: 2018/10/16 16:24
 * Author: zcj
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4, LEVEL_LOWEST, LEVEL_HIGHEST})
public @interface Priority {
}