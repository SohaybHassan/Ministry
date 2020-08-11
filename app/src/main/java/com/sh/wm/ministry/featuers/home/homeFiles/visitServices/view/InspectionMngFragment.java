package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentInspectionMngBinding;


public class InspectionMngFragment extends Fragment {

   private FragmentInspectionMngBinding binding ;

    public InspectionMngFragment() {
        // Required empty public constructor
    }

    public static InspectionMngFragment newInstance(String param1, String param2) {
        InspectionMngFragment fragment = new InspectionMngFragment();


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
        binding = FragmentInspectionMngBinding.inflate(inflater, container, false);

        binding.insCompanyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =InspectionMngFragment.this.getContext();
                BottomSheetDialog dialog = new BottomSheetDialog(context);
                new BottomSheetSearsh(context, dialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searshByNumber(String num_facility) {

                    }
                }) ;
            }
        });

        binding.insInspectorName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =InspectionMngFragment.this.getContext();
                BottomSheetDialog dialog = new BottomSheetDialog(context);
                new BottomSheetSearsh(context, dialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searshByNumber(String num_facility) {

                    }
                }) ;

            }
        });

        binding.btnSaveAddInspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return binding.getRoot();
    }
}