package com.xelement.moment.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {
    private static Toast sToast;

    public static void show(Context mContext, CharSequence content) {
        //showMiddle(mContext, content.toString());
        if (null == sToast) {
            synchronized (ToastUtil.class) {
                if (null == sToast) {
                    sToast = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_SHORT);
                    sToast.setGravity(Gravity.CENTER, 0, 0);
                }
            }
        }
        sToast.setText(content);
        sToast.show();
    }

    public static void show(Context mContext, int contentId) {
        //showMiddle(mContext, UIUtil.getString(contentId));
        if (null == sToast) {
            synchronized (ToastUtil.class) {
                if (null == sToast) {
                    sToast = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_SHORT);
                    sToast.setGravity(Gravity.CENTER, 0, 0);
                }
            }
        }
        sToast.setText(contentId);
        sToast.show();
    }

    /*public static void showMiddle(Context context, String content) {
        Toast sMiddToast = createToast(context, content);
        sMiddToast.setDuration(Toast.LENGTH_SHORT);
        sMiddToast.show();
    }

    private static Toast createToast(Context context, String content) {
        Toast tempToast;
        View layout = View.inflate(context, R.layout.view_toast, null);
        TextView tv_title = (TextView) layout.findViewById(R.id.mMsgLabel);
        if (!TextUtils.isEmpty(content)) {
            tv_title.setText(content);
            tv_title.setVisibility(View.VISIBLE);
        }

        tempToast = new Toast(context.getApplicationContext());
        tempToast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 528);
        tempToast.setDuration(Toast.LENGTH_LONG);
        tempToast.setView(layout);
        return tempToast;
    }*/


}
