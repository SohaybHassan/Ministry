package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentInspectionPlaneManagmentBinding;

import java.util.TimeZone;

public class InspectionPlaneManagementFragment extends Fragment implements View.OnClickListener, DateAdder.Listener{
    private FragmentInspectionPlaneManagmentBinding binding;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long selectedTime;
    private boolean dateFlag = true ;

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
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        selectedTime = System.currentTimeMillis();
        binding.insInspectorName.setOnClickListener(this) ;
        binding.visitFrom.setOnClickListener(this) ;
        binding.visitTo.setOnClickListener(this) ;
        binding.visitSearchBtn.setOnClickListener(this) ;

        return binding.getRoot();
        // Inflate the layout for this fragment
    }//end onCREATEView(..)

    @Override
    public void onDateTimeChosen(long timeChosen) {
        selectedTime = timeChosen;
       if(dateFlag){
           binding.visitFrom.setText(TimeUtil.getDefaultDateText(selectedTime, timeZone));
          return;
       }//end if
        binding.visitTo.setText(TimeUtil.getDefaultDateText(selectedTime, timeZone));

    }//end onDateTime Chosen

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.ins_inspector_name :
              break;
          case R.id.visit_from:
              dateFlag=true;
              dateAdder.show();
              break;
          case R.id.visit_to:
              dateFlag=false;
              dateAdder.show();
              break;
          case R.id.visit_search_btn:
              search();
              break;
      }//end switch
    }//end onClick(..)

    private void search(){
        Toast.makeText(getActivity(),"SEARCH",Toast.LENGTH_SHORT).show();
    }//end search
}//end Class