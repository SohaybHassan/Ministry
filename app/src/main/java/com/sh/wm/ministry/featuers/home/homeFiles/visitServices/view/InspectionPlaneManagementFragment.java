package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentInspectionPlaneManagmentBinding;

public class InspectionPlaneManagementFragment extends Fragment {
    private FragmentInspectionPlaneManagmentBinding binding;


    public InspectionPlaneManagementFragment() {
        // Required empty public constructor
    }//end constructor



    public static InspectionPlaneManagementFragment newInstance(String param1, String param2) {
        InspectionPlaneManagementFragment fragment = new InspectionPlaneManagementFragment();

        return fragment;
    }//end newInstance(..)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCREATE(..)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInspectionPlaneManagmentBinding.inflate(inflater, container, false);
        binding.insInspectorName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =InspectionPlaneManagementFragment.this.getContext();
                BottomSheetDialog dialog = new BottomSheetDialog(context);
                 new BottomSheetSearsh(context, dialog, new BottomSheetSearsh.bottomSheetSearsh() {
                     @Override
                     public void searchByNumber(String num_facility) {

                     }
                 }) ;
            }
        });
        return binding.getRoot();
        // Inflate the layout for this fragment
    }//end onCREATEView(..)
}//end Class