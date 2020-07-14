package com.sh.wm.ministry.featuers.userfile.userFiles.trainingprograms.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentTrainingProgramsBinding;
import com.sh.wm.ministry.featuers.userfile.userFiles.trainingprograms.viewmodel.TrainingProgramsViewModel;

import java.util.TimeZone;

public class TrainingProgramsFragment extends Fragment implements DateAdder.Listener {

    private TrainingProgramsViewModel mViewModel;
    private FragmentTrainingProgramsBinding binding;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;

    public static TrainingProgramsFragment newInstance() {
        return new TrainingProgramsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTrainingProgramsBinding.inflate(inflater, container, false);

        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();

        binding.tvCourseStartDateTrainingPrograms.setOnClickListener(view -> {
            dateAdder.show();
        });

        binding.tvCourseEndDateTrainingPrograms.setOnClickListener(view -> {
            dateAdder.show();
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TrainingProgramsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.tvCourseStartDateTrainingPrograms.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
        binding.tvCourseEndDateTrainingPrograms.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
}