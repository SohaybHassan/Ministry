package com.sh.wm.ministry.featuers.userfile.userFiles.trainingskills.view;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.featuers.userfile.userFiles.trainingskills.viewmodel.AddTrainingSkillsViewModel;
import com.sh.wm.ministry.R;

public class AddTrainingSkillsFragment extends Fragment {

    private AddTrainingSkillsViewModel mViewModel;

    public static AddTrainingSkillsFragment newInstance() {
        return new AddTrainingSkillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_training_skills, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddTrainingSkillsViewModel.class);
        // TODO: Use the ViewModel
    }

}