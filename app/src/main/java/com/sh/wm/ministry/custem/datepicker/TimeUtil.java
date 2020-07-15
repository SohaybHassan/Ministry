package com.sh.wm.ministry.custem.datepicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {

    private static final String DATE_TIME_FORMAT = "EEEE, MM d, yyyy - h:mm a";
    private static final String DATE_FORMAT = "yyyy/MM/d";
    private static final String FEED_DATE_FORMAT = "MM/d/yy";

    public static String getDefaultDateText(long unixTime, TimeZone timeZone) {
        Date date = new Date(unixTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public static String getDefaultdDateTimeText(long unixTime, TimeZone timeZone) {
        Date date = new Date(unixTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    public static String getFeedTimeText(long unixTime, TimeZone timeZone) {
        Date date = new Date(unixTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FEED_DATE_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }
}