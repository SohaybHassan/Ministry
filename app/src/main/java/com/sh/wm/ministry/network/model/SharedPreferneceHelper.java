package com.sh.wm.ministry.network.model;

import android.content.Context;
import android.content.SharedPreferences;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.network.utiels.ApiConstent;

public class SharedPreferneceHelper {
    public static boolean isLoggedIn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_LOGIN_STATUS, Context.MODE_PRIVATE);
        return preferences.getBoolean(ApiConstent.USER_LOGIN_STATUS, false);
    }

    public static String getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.AUTH_TOKEN, Context.MODE_PRIVATE);
        return preferences.getString(ApiConstent.AUTH_TOKEN, "Empty");
    }

    public static String getUserId(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_ID, Context.MODE_PRIVATE);
        return preferences.getString(ApiConstent.USER_ID, "Empty");
    }

    public static String getUserName(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_NAME, Context.MODE_PRIVATE);
        return preferences.getString(ApiConstent.USER_NAME, "Empty");
    }

    public static String getUserSn(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_SN, Context.MODE_PRIVATE);
        return preferences.getString(ApiConstent.USER_SN, "Empty");
    }

    public static String getUserImg(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_IMG, Context.MODE_PRIVATE);
        return preferences.getString(ApiConstent.USER_IMG, "Empty");
    }

    public static int getUserRole(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(ApiConstent.USER_ROLE, Context.MODE_PRIVATE);
        return preferences.getInt(ApiConstent.USER_ROLE, 0);
    }
}
