package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInspVisitOutOfPlaneBinding;
import com.sh.wm.ministry.databinding.FragmentInspectionPlaneManagmentBinding;


public class InspVisitOutOfPlaneFragment extends Fragment {
private FragmentInspVisitOutOfPlaneBinding binding ;

    public InspVisitOutOfPlaneFragment() {
        // Required empty public constructor
    }

     static InspVisitOutOfPlaneFragment newInstance(String param1, String param2) {
        InspVisitOutOfPlaneFragment fragment = new InspVisitOutOfPlaneFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInspVisitOutOfPlaneBinding.inflate(inflater, container, false);
        binding.llVisit.setScrollContainer(true);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}