package com.sh.wm.ministry.featuers.userfile.dependents.view;

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
import com.sh.wm.ministry.databinding.FragmentDependentsBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.userfile.dependents.adapter.DependentsAdapter;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependent;
import com.sh.wm.ministry.featuers.userfile.dependents.viewmodel.DependentsViewModel;

import java.util.List;

public class DependentsFragment extends Fragment {

    private DependentsViewModel mViewModel;
    private FragmentDependentsBinding binding;
    private List<UserDependent> userDependentsList;
    private OnFragmentInteractionListener mListener;
    private MaterialButton addButton;
    private TextView title;
    private FloatingActionButton fab;
    private RecyclerView recycler;

    public static DependentsFragment newInstance() {
        return new DependentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDependentsBinding.inflate(inflater, container, false);
        addButton = binding.btnAddDependents;
        title = binding.tvNoDependents;
        fab = binding.fabAddNewDependents;
        recycler = binding.rvDependents;
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DependentsViewModel.class);
        mViewModel.getUserDependents().observe(getViewLifecycleOwner(), userDependentsModel -> {
            if (userDependentsModel.getStatus() == 0) {
                recycler.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                addButton.setVisibility(View.GONE);
                userDependentsList = userDependentsModel.getUserDependents();
                DependentsAdapter dependentsAdapter = new DependentsAdapter(userDependentsList);
                recycler.setAdapter(dependentsAdapter);
            }
            addButton.setOnClickListener(view -> {
                mListener.onFragmentInteraction(41);
            });
            fab.setOnClickListener(view -> {
                mListener.onFragmentInteraction(41);
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