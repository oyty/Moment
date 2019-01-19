package com.xelement.moment.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.xelement.moment.base.App;


/**
 * 屏幕工具类
 */
public class ScreenUtil {

    /**
     * 屏幕宽度
     */
    private static int deviceWidth = -1;

    /**
     * 屏幕高度
     */
    private static int deviceHeight = -1;

    public static void init(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        wm.getDefaultDisplay().getMetrics(dm);

        deviceWidth = dm.widthPixels;
        deviceHeight = dm.heightPixels;
    }

    /**
     * 获取屏幕宽
     */
    public static int getDeviceWidth() {
        init(App.getContext());
        return deviceWidth;
    }

    /**
     * 获取屏幕高
     */
    public static int getDeviceHeight() {
        init(App.getContext());
        return deviceHeight;
    }

    /**
     * 竖屏下屏幕宽，保证宽<高
     */
    public static int getDeviceWidthPortrait() {
        return deviceWidth > deviceHeight ? deviceHeight : deviceWidth;
    }

    /**
     * 竖屏下屏幕高，保证宽<高
     */
    public static int getDeviceHeightPortrait() {
        return deviceWidth > deviceHeight ? deviceWidth : deviceHeight;
    }
}