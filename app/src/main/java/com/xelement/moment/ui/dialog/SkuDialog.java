package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.xelement.moment.R;
import com.xelement.moment.util.UIUtil;

import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/15.
 */
public class SkuDialog {
    private CustomBottomSheet bottomSheetDialog;

    public SkuDialog(Context context) {
        bottomSheetDialog = new CustomBottomSheet(context);
        View view = View.inflate(context, R.layout.dialog_sku, null);
        ButterKnife.bind(this, view);

//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (UIUtil.getDimen(R.dimen.x420) * 2f));
        bottomSheetDialog.setContentView(view);
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
