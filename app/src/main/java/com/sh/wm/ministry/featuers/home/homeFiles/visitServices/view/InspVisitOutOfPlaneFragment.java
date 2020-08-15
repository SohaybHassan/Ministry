package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentInspVisitOutOfPlaneBinding;

import java.util.TimeZone;


public class InspVisitOutOfPlaneFragment extends Fragment implements View.OnClickListener,DateAdder.Listener {
private FragmentInspVisitOutOfPlaneBinding binding ;
private ShMyDialog dialog;
private DateAdder dateAdder;
private TimeZone timeZone;
private long selectedTime;
    private BottomSheetSearsh bottomSheetSearch;
    private BottomSheetDialog bottomSheetDialog;
    public InspVisitOutOfPlaneFragment() {
        // Required empty public constructor
    }//end Constructor

     static InspVisitOutOfPlaneFragment newInstance(String param1, String param2) {
        InspVisitOutOfPlaneFragment fragment = new InspVisitOutOfPlaneFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }//end newInstance()

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }//end onCreate()

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInspVisitOutOfPlaneBinding.inflate(inflater, container, false);
        bottomSheetDialog = new BottomSheetDialog(getContext());
        //add scroller
        binding.llVisit.setScrollContainer(true);
       //add clickListener
        binding.btnSaveVisit.setOnClickListener(this);
        binding.insCmpName.setOnClickListener(this);
        binding.inspectorOne.setOnClickListener(this);
        binding.inspectorTwo.setOnClickListener(this);
        binding.inspectorThree.setOnClickListener(this);
        binding.visitDate.setOnClickListener(this);
        // add date picker
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        selectedTime = System.currentTimeMillis();
        return binding.getRoot();
    }//end onCreateView

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_save_visit : generateDialog();
                break;
            case R.id.ins_cmp_name:
                searchCompany();
                break;
            case R.id.inspector_one:
                break;
            case R.id.inspector_two:
                break;
            case R.id.inspector_three:
                break;
            case R.id.visit_date:
                dateAdder.show();
                break;

        }//end switch
    }//end onClick()

    private void generateDialog(){
        dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
            @Override
            public void save(View view) {
                Toast.makeText(getContext(), "save", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void edit(View view) {
                Toast.makeText(getContext(), "edit", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }, getString(R.string.add_visit_confirmation),getString(R.string.save),getString(R.string.edit));
        dialog.show(getParentFragmentManager(), "Visit Out oF PLANE Fragment");
    }//end generateDialog()

    @Override
    public void onDateTimeChosen(long timeChosen) {
        selectedTime = timeChosen;
        binding.visitDate.setText(TimeUtil.getDefaultDateText(selectedTime, timeZone));
    }//end onDateTime Chosen
    private void searchCompany(){
        if(binding.insCmpName.getText().toString().isEmpty()){
            bottomSheetSearch = new BottomSheetSearsh(getActivity(), bottomSheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                @Override
                public void searchByNumber(String num_facility) {

                    bottomSheetDialog.dismiss();
                }//searchByNumber()
            });
            bottomSheetSearch.openDialog(getString(R.string.company), getString(R.string.insert_three_letters));
        }else{

        }//end else

    }//end search

}//end class