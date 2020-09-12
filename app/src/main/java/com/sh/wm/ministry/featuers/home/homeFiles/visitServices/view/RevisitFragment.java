package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentRevisitBinding;

import java.util.TimeZone;

public class RevisitFragment extends Fragment implements DateAdder.Listener {
private FragmentRevisitBinding binding ;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;


    public RevisitFragment() {
        // Required empty public constructor
    }

    public static RevisitFragment newInstance(String param1, String param2) {
        RevisitFragment fragment = new RevisitFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRevisitBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        binding.bestActions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.machine_stop_act)
                    binding.stopResLayout.setVisibility(View.VISIBLE);
                else
                    binding.stopResLayout.setVisibility(View.INVISIBLE);

            }
        });
        binding.actionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.actionDate.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
}