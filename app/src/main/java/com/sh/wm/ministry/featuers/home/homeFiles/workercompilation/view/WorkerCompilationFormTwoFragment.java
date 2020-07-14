package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.sh.wm.ministry.databinding.FragmentFileComplaintForm2Binding;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel.WorkerCompilationFormTwoViewModel;


public class WorkerCompilationFormTwoFragment extends Fragment {

    private WorkerCompilationFormTwoViewModel mViewModel;
    private FragmentFileComplaintForm2Binding binding;

    public static WorkerCompilationFormTwoFragment newInstance() {
        return new WorkerCompilationFormTwoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFileComplaintForm2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WorkerCompilationFormTwoViewModel.class);
        // TODO: Use the ViewModel
    }

}