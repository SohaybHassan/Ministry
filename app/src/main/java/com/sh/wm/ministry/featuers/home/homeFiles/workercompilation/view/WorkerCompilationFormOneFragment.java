package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sh.wm.ministry.databinding.FragmentFileComplaintForm1Binding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;


public class WorkerCompilationFormOneFragment extends Fragment {

    private FragmentFileComplaintForm1Binding binding;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFileComplaintForm1Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.btnComplaintNext.setOnClickListener(view1 -> {
            mListener.onFragmentInteraction(21);
        });
        return view;
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