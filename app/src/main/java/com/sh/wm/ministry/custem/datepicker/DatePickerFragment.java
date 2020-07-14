package com.sh.wm.ministry.custem.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private final Listener DUMMY_LISTENER = new Listener() {
        @Override
        public void onDateChosen(int year, int month, int day) {
        }
    };
    private Listener mListener = DUMMY_LISTENER;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void setListener(Listener listener) {
        mListener = (listener == null) ? DUMMY_LISTENER : listener;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        mListener.onDateChosen(year, month, day);
    }

    public interface Listener {
        void onDateChosen(int year, int month, int day);
    }
}