package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentInspectionResultsBinding;

import java.util.TimeZone;

public class InspectionResultsFragment extends Fragment implements DateAdder.Listener {
private FragmentInspectionResultsBinding binding;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;

    public InspectionResultsFragment() {
        // Required empty public constructor
    }//end contructor


    public static InspectionResultsFragment newInstance(String param1, String param2) {
        InspectionResultsFragment fragment = new InspectionResultsFragment();

        return fragment;
    }//end newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInspectionResultsBinding.inflate(inflater,container, false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();

        return binding.getRoot();
    }//end onCreateView

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //control visiblity of machine_stop_layout
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

    }// end onViewCreated

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.actionDate.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
}//end class