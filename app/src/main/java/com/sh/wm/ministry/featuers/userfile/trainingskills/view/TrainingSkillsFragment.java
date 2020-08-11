package com.sh.wm.ministry.featuers.userfile.trainingskills.view;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.databinding.FragmentTrainingSkillsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.trainingskills.adapter.TrainingSkillAdapter;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkills;
import com.sh.wm.ministry.featuers.userfile.trainingskills.viewmodel.TrainingSkillsViewModel;

import java.util.List;

public class TrainingSkillsFragment extends Fragment implements TrainingSkillAdapter.OnEditClickListener {

    private TrainingSkillsViewModel mViewModel;
    private FragmentTrainingSkillsBinding binding;
    private OnFragmentInteractionListener mListener;

    public static TrainingSkillsFragment newInstance() {
        return new TrainingSkillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTrainingSkillsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.LLLayoutTrainingSkills.setVisibility(View.INVISIBLE);
        binding.fabAddTrainingSkills.setVisibility(View.INVISIBLE);
        binding.fabAddTrainingSkills.setOnClickListener(view -> {
            mListener.onFragmentInteraction(12);
        });
        binding.btnAddTrainingSkills.setOnClickListener(view -> {
            mListener.onFragmentInteraction(12);
        });

        mViewModel = new ViewModelProvider(this).get(TrainingSkillsViewModel.class);
        mViewModel.getTrainingSkills().observe(getViewLifecycleOwner(), trainingSkillsModel -> {
            if (trainingSkillsModel != null) {
                if (trainingSkillsModel.getTrainingSkillsWorkStatuses() != null) {
                    List<TrainingSkills> skills = trainingSkillsModel.getTrainingSkillsWorkStatuses();
                    TrainingSkillAdapter adapter = new TrainingSkillAdapter(skills, this);
                    binding.rvTrainingSkills.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    binding.rvTrainingSkills.setAdapter(adapter);
                    binding.LLLayoutTrainingSkills.setVisibility(View.GONE);
                    binding.fabAddTrainingSkills.setVisibility(View.VISIBLE);
                } else {
                    binding.LLLayoutTrainingSkills.setVisibility(View.VISIBLE);
                    binding.fabAddTrainingSkills.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onEditClick(TrainingSkills trainingSkills) {
        Bundle bundle = new Bundle();
//        bundle.putString("work_status",workStatus.getWORKSTATUS());
//        bundle.putString("work_status_desc",workStatus.getWORKSTATUSDESC());
//        bundle.putString("work_status_desc_desc",workStatus.getWORKSTATUSDESCDESC());
        mListener.onFragmentInteraction(12,bundle);
    }
}