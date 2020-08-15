package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentInspectionMngBinding;


public class InspectionMngFragment extends Fragment implements View.OnClickListener {

   private FragmentInspectionMngBinding binding ;
    private BottomSheetSearsh bottomSheetSearch;
    private BottomSheetDialog bottomSheetDialog;



    public InspectionMngFragment() {
        // Required empty public constructor
    }//end Constructor

    public static InspectionMngFragment newInstance(String param1, String param2) {
        InspectionMngFragment fragment = new InspectionMngFragment();


        return fragment;
    }//end newInstance()

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInspectionMngBinding.inflate(inflater, container, false);
        bottomSheetDialog = new BottomSheetDialog(getContext());
       //add onClickListener
        binding.insCompanyName.setOnClickListener(this);

        binding.insInspectorName.setOnClickListener(this);

        binding.btnSaveAddInspection.setOnClickListener(this);

        return binding.getRoot();
    }//end onCreateView()

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save_add_inspection:
                break;
            case  R.id.ins_inspector_name:
                break;
            case R.id.ins_company_name:
                searchCompany();
                break;
        }//end switch
    }//end onClick()
    private void searchCompany(){
        bottomSheetSearch = new BottomSheetSearsh(getActivity(), bottomSheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
            @Override
            public void searchByNumber(String num_facility) {

                bottomSheetDialog.dismiss();
            }//searchByNumber()
        });
        bottomSheetSearch.openDialog(getString(R.string.company), getString(R.string.insert_three_letters));
    }//end search


}//end class