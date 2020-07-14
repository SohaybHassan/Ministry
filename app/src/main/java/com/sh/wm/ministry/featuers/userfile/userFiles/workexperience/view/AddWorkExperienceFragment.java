package com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sh.wm.ministry.databinding.FragmentAddWorkExperienceBinding;


public class AddWorkExperienceFragment extends Fragment {

    private FragmentAddWorkExperienceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddWorkExperienceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            binding.tvExperienceTypeAddWorkExperience.setText(bundle.getString("expert_type"));
            binding.tvWorkPlaceAddWorkExperience.setText(bundle.getString("work_place"));
            binding.tvJobTitleAddWorkExperience.setText(bundle.getString("job_title"));
            binding.tvInstitutionNameAddWorkExperience.setText(bundle.getString("enterprise_name"));
            binding.tvWorkBeginningDateAddWorkExperience.setText(bundle.getString("start_work"));
            binding.tvWorkEndingDateAddWorkExperience.setText(bundle.getString("end_work"));
        }
    }
}
