package com.sh.wm.ministry.featuers.userfile.userFiles.dependents.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.button.MaterialButton;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ConfirmDialog;
import com.sh.wm.ministry.databinding.FragmentAddDependentsBinding;
import com.sh.wm.ministry.featuers.userfile.userFiles.dependents.viewmodel.AddDependentsViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

public class AddDependentsFragment extends Fragment implements ConfirmDialog.Listener {
    private FragmentAddDependentsBinding binding;
    private AddDependentsViewModel mViewModel;
    private ConfirmDialog confirmDialog;
    private MaterialButton saveButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddDependentsBinding.inflate(inflater, container, false);
        saveButton = binding.btnSaveNewDependents;
        confirmDialog = new ConfirmDialog(this, getContext(), "");
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddDependentsViewModel.class);
        mViewModel.postUserWorker(SharedPreferneceHelper.getUserSn(getContext()), "").observe(getViewLifecycleOwner(), userWorkerInsertModel -> {

        });
        saveButton.setOnClickListener(view -> {
            confirmDialog.presentForList(getString(R.string.do_want_to_add_new_dependents));
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onOk() {

    }

    @Override
    public void onCancel() {

    }
}
