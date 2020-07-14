package com.sh.wm.ministry.custem.datepicker;

import java.util.Calendar;

public class DateFormater {
    private int year, month, day;

    public DateFormater(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String formatDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return TimeUtil.getDefaultDateText(calendar.getTimeInMillis(), calendar.getTimeZone());
    }
}