package com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.view;

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


import com.sh.wm.ministry.databinding.FragmentPracticalStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.adapter.PracticalStatusAdapter;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.UserWorkStatus;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.viewmodel.PracticalStatusViewModel;

import java.util.List;

public class PracticalStatusFragment extends Fragment implements PracticalStatusAdapter.OnEditClickListener {

    private PracticalStatusViewModel mViewModel;
    private FragmentPracticalStatusBinding binding;
    private OnFragmentInteractionListener mListener;


    public static PracticalStatusFragment newInstance() {
        return new PracticalStatusFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPracticalStatusBinding.inflate(inflater, container, false);
        binding.LLLayoutPracticalStatus.setVisibility(View.INVISIBLE);
        binding.fabAddPracticalStatus.setVisibility(View.INVISIBLE);
        binding.fabAddPracticalStatus.setOnClickListener(view -> {
            mListener.onFragmentInteraction(10);
        });
        binding.btnAddPracticalStatus.setOnClickListener(view -> {
            mListener.onFragmentInteraction(10);
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PracticalStatusViewModel.class);
        mViewModel.getUserPracticalStatus().observe(getViewLifecycleOwner(), practicalStatusModel -> {
            if (practicalStatusModel != null) {
                if (practicalStatusModel.getUserWorkStatus() != null) {
                    List<UserWorkStatus> workStatus = practicalStatusModel.getUserWorkStatus();
                    PracticalStatusAdapter adapter = new PracticalStatusAdapter(workStatus, this);
                    binding.rvPracticalStatus.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    binding.rvPracticalStatus.setAdapter(adapter);
                    binding.LLLayoutPracticalStatus.setVisibility(View.GONE);
                    binding.fabAddPracticalStatus.setVisibility(View.VISIBLE);
                } else {
                    binding.LLLayoutPracticalStatus.setVisibility(View.VISIBLE);
                    binding.fabAddPracticalStatus.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onEditClick(UserWorkStatus workStatus) {
        Bundle bundle = new Bundle();
        bundle.putString("work_status",workStatus.getWORKSTATUS());
        bundle.putString("work_status_desc",workStatus.getWORKSTATUSDESC());
        bundle.putString("work_status_desc_desc",workStatus.getWORKSTATUSDESCDESC());
//        bundle.putString("work_place",workExperience.getEXPTYPE());
//        bundle.putString("job_title",workExperience.getJOBTITL());
//        bundle.putString("enterprise_name",workExperience.getEXPINSTIT());
//        bundle.putString("start_work",workExperience.getUSERWORKEXPSTARTWORK());
//        bundle.putString("end_work",workExperience.getUSERWORKEXPENDWORK());
        mListener.onFragmentInteraction(10,bundle);
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

}