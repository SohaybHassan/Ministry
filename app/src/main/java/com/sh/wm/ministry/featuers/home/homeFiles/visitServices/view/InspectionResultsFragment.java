package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInspectionResultsBinding;
import com.sh.wm.ministry.databinding.FragmentInspectionVisitingMenuBinding;

public class InspectionResultsFragment extends Fragment {
private FragmentInspectionResultsBinding binding;


    public InspectionResultsFragment() {
        // Required empty public constructor
    }


    public static InspectionResultsFragment newInstance(String param1, String param2) {
        InspectionResultsFragment fragment = new InspectionResultsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inspection_results, container, false);
    }
}