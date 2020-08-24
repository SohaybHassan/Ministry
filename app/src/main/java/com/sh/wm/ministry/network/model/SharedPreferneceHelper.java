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
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.key_token), Context.MODE_PRIVATE);
        return preferences.getString(context.getString(R.string.key_token), "Empty");
    }

    public static String getUserId(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.key_userId), Context.MODE_PRIVATE);
        return preferences.getString(context.getString(R.string.key_userId), "Empty");
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
}
