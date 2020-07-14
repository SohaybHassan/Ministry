package com.sh.wm.ministry.custem.datepicker;

import androidx.fragment.app.FragmentManager;

import java.util.Calendar;

public class DateAdder {

    private FragmentManager fragmentManager;
    private Calendar calendar;
    private Listener listener;
    private DatePickerFragment datePickerFragment;
    private final DatePickerFragment.Listener dateListener = new DatePickerFragment.Listener() {
        @Override
        public void onDateChosen(int year, int month, int day) {
            datePickerFragment.setListener(null);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            listener.onDateTimeChosen(calendar.getTimeInMillis());
        }
    };

    public DateAdder(FragmentManager fragmentManager, Listener listener) {
        this.fragmentManager = fragmentManager;
        calendar = Calendar.getInstance();
        this.listener = listener;
        datePickerFragment = new DatePickerFragment();
    }

    public void show() {
        if (datePickerFragment.isAdded()) {
            return;
        }
        datePickerFragment.setListener(dateListener);
        datePickerFragment.show(fragmentManager, null);
    }

    public void cleanUp() {
        datePickerFragment = null;
    }

    public interface Listener {
        void onDateTimeChosen(long timeChosen);
    }
}