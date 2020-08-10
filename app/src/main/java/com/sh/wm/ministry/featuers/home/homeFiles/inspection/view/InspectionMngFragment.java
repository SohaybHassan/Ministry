package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentInspectionMngBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InspectionMngFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InspectionMngFragment extends Fragment {

   private FragmentInspectionMngBinding binding ;

    public InspectionMngFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InspectionMngFragment.
     */
    // TODO: Rename and change types and number of parameters
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