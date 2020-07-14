package com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.databinding.FragmentWorkExperienceBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.adapter.UserWorkExperienceAdapter;
import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.model.UserWorkExperience;
import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.viewmodel.WorkExperienceViewModel;

import java.util.List;

public class UserWorkExperiencesFragment extends Fragment implements UserWorkExperienceAdapter.OnEditClickListener {

    private FragmentWorkExperienceBinding binding;
    private WorkExperienceViewModel mViewModel;
    private RecyclerView myRecyclerView;
    private OnFragmentInteractionListener mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWorkExperienceBinding.inflate(inflater, container, false);
        binding.LLLayoutWorkExperience.setVisibility(View.INVISIBLE);
        binding.fabAddExperienceWorkExperience.setVisibility(View.INVISIBLE);
        myRecyclerView = binding.rvExperiencesWorkExperiences;
        binding.fabAddExperienceWorkExperience.setOnClickListener(view -> {
            mListener.onFragmentInteraction(71);
        });
        binding.btnAddExperienceWorkExperience.setOnClickListener(view -> {
            mListener.onFragmentInteraction(71);
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(WorkExperienceViewModel.class);
        mViewModel.getUserWorkExperiences().observe(getViewLifecycleOwner(), userWorkExperienceModel -> {
            if (userWorkExperienceModel != null) {
                if (userWorkExperienceModel.getUserWorkExperience() != null) {
                    List<UserWorkExperience> userWorkExperiences = userWorkExperienceModel.getUserWorkExperience();
                    UserWorkExperienceAdapter adapter = new UserWorkExperienceAdapter(getContext(), userWorkExperiences, this);
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    myRecyclerView.setAdapter(adapter);
                    binding.LLLayoutWorkExperience.setVisibility(View.GONE);
                    binding.fabAddExperienceWorkExperience.setVisibility(View.VISIBLE);
                } else {
                    binding.LLLayoutWorkExperience.setVisibility(View.VISIBLE);
                    binding.fabAddExperienceWorkExperience.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onEditClick(UserWorkExperience workExperience) {
        new ToastMsg(getContext()).toastIconSuccess(workExperience.getJOBTITL());
        Bundle bundle = new Bundle();
        bundle.putString("expert_type", workExperience.getEXPTYPE());
        bundle.putString("work_place", workExperience.getEXPTYPE());
        bundle.putString("job_title", workExperience.getJOBTITL());
        bundle.putString("enterprise_name", workExperience.getEXPINSTIT());
        bundle.putString("start_work", workExperience.getUSERWORKEXPSTARTWORK());
        bundle.putString("end_work", workExperience.getUSERWORKEXPENDWORK());
        mListener.onFragmentInteraction(72, bundle);
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
