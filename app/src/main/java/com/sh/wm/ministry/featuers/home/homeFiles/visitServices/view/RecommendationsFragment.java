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
import com.sh.wm.ministry.databinding.FragmentRecommendationsBinding;

import java.util.TimeZone;

public class RecommendationsFragment extends Fragment implements DateAdder.Listener{
private FragmentRecommendationsBinding binding ;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;

    public RecommendationsFragment() {
        // Required empty public constructor
    }


    public static RecommendationsFragment newInstance(String param1, String param2) {
        RecommendationsFragment fragment = new RecommendationsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentRecommendationsBinding.inflate(inflater,container,false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        //control visiblity of machine_stop_layout
        binding.insProcedureGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.ins_proc_op3)
                    binding.recStopMachineLayout.setVisibility(View.VISIBLE);
                else
                    binding.recStopMachineLayout.setVisibility(View.INVISIBLE);

            }
        });
        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.date.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
}