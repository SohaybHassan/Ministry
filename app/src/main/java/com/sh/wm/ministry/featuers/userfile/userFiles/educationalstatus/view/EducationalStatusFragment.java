package com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sh.wm.ministry.databinding.FragmentEducationalStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.adapter.EducationalStatusAdapter;
import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.model.UserEducationalStatus;
import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.viewmodel.EducationalStatusViewModel;

import java.util.List;

public class EducationalStatusFragment extends Fragment {

    private EducationalStatusViewModel mViewModel;
    private FragmentEducationalStatusBinding binding;
    private MaterialButton addButton;
    private TextView title;
    private FloatingActionButton fab;
    private RecyclerView recycler;
    private List<UserEducationalStatus> userEducationalStatus;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEducationalStatusBinding.inflate(inflater, container, false);

        addButton = binding.btnAddEductionalstatus;
        title = binding.tvNoEductionalstatus;
        fab = binding.fabAddNewEductionalstatus;
        recycler = binding.rvEductionalstatus;

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EducationalStatusViewModel.class);
        mViewModel.getUserDependents().observe(getViewLifecycleOwner(), educationalStatusModel -> {
            if (educationalStatusModel.getStatus() == 0) {
                recycler.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                addButton.setVisibility(View.GONE);
                userEducationalStatus = educationalStatusModel.getUserEducationalStatus();
                EducationalStatusAdapter adapter = new EducationalStatusAdapter(userEducationalStatus);
                recycler.setAdapter(adapter);
            }
            addButton.setOnClickListener(view -> {
                mListener.onFragmentInteraction(51);
            });
            fab.setOnClickListener(view -> {
                mListener.onFragmentInteraction(51);
            });
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}