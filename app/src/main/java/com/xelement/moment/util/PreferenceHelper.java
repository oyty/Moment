package com.xelement.moment.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.xelement.moment.base.App;

public class PreferenceHelper {

    public static final String PREFERENCE_NAME_CIRCLE = "sharepreference_nesecond";
    public static final String SHOW_LOCK__NOTIFICATION = "show_lock_notification";

    private static SharedPreferences getSharedPreference() {
        Context context = App.getContext().getApplicationContext();
        return context.getSharedPreferences(PREFERENCE_NAME_CIRCLE, Context.MODE_PRIVATE);
    }

    public static boolean putString(String tag, String value) {
        SharedPreferences prefs = getSharedPreference();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(tag, value);
        return editor.commit();
    }

    public static String getString(String tag) {
        return getString(tag, "");
    }

    public static String getString(String tag, String defaultValue) {
        SharedPreferences prefs = getSharedPreference();
        return prefs.getString(tag, defaultValue);
    }

    public static boolean putBoolean(String tag, boolean value) {
        SharedPreferences prefs = getSharedPreference();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(tag, value);
        return editor.commit();
    }

    public static boolean getBoolean(String tag) {
        return getBoolean(tag, false);
    }

    public static boolean getBoolean(String tag, boolean defaultValue) {
        SharedPreferences prefs = getSharedPreference();
        return prefs.getBoolean(tag, defaultValue);
    }

    public static int getInt(String tag, int defaultValue) {
        SharedPreferences prefs = getSharedPreference();
        return prefs.getInt(tag, defaultValue);
    }


    //
//    public static String getLoginMethod() {
//        return getString(Constants.LOGIN_METHOD);
//    }
//
    public static boolean putInt(String tag, int value) {
        SharedPreferences prefs = getSharedPreference();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(tag, value);
        return editor.commit();
    }

    //
//    public static boolean isLockNotificationDisabled(){
//        return getBoolean(SHOW_LOCK__NOTIFICATION,false);
//    }
//    public static void disableLockNotification(boolean flag){
//        putBoolean(SHOW_LOCK__NOTIFICATION,flag);
//    }
//

    public static void setHasUpdate(boolean hasUpdate) {
//        putBoolean(Constants.HAS_UPDATE, hasUpdate);
    }

    //    public static boolean getHasUpdate(boolean hasUpdate){
//        return  getBoolean(Constants.HASUPDATE,hasUpdate);
//    }
    public static void setNewestVersion(String name) {
//        putString(Constants.NEWEST_VERSION, name);
    }

//
//    public static boolean isInner() {
//        return PreferenceHelper.getBoolean(Constants.Cache.PROMOTIONS_CONFIG);
//    }
}
