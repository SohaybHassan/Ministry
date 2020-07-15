package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentLeavingAWorkplaceBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.viewmodel.LeavingWorkPlaceViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

import java.util.TimeZone;


public class LeavingAWorkplaceFragment extends Fragment implements DateAdder.Listener {

    private FragmentLeavingAWorkplaceBinding binding;
    private DateAdder dateAdder;
    private ShMyDialog dialog;
    private TimeZone timeZone;
    private long chosenTime;
    private BottomSheetSearsh bottomSheetSearsh;
    private BottomSheetDialog sheetDialog;
    private LeavingWorkPlaceViewModel leavingWorkPlaceViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLeavingAWorkplaceBinding.inflate(inflater, container, false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        sheetDialog = new BottomSheetDialog(getContext());
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        leavingWorkPlaceViewModel = new ViewModelProvider(this).get(LeavingWorkPlaceViewModel.class);

        binding.btnSaveLeavingWorkPlace.setOnClickListener(view1 -> {
            dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                @Override
                public void sase(View view1) {
                    Toast.makeText(getContext(), "تم الحفظ بنجاح", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

                @Override
                public void edite(View view1) {
                    dialog.dismiss();
                }
            }, getString(R.string.leaving_work_place));
            dialog.show(getParentFragmentManager(), "");
        });


        binding.edDateEndWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });
        binding.edNuFacilityLeavingWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searshByNumber(String num_facility) {
                       binding.progressbar.setVisibility(View.VISIBLE);
                        enabel(false);
                        leavingWorkPlaceViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), new Observer<Construction>() {
                            @Override
                            public void onChanged(Construction construction) {
                                if (construction != null) {

                                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                                    binding.cardViewSearshLeavingWorkPlace.tvOwnerName.setText("اسم المالك : " + name);
                                    binding.cardViewSearshLeavingWorkPlace.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                                    binding.cardViewSearshLeavingWorkPlace.tvOwnerId.setText("رقم هوية المالك : " + user_cn);

                                    binding.edNuFacilityLeavingWorkPlace.setVisibility(View.GONE);
                                    binding.tvNuFacility.setVisibility(View.GONE);
                                    binding.cardViewSearshLeavingWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                                    binding.progressbar.setVisibility(View.GONE);
                                    enabel(true);

                                } else {
                                    Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                                    enabel(true);
                                    binding.edNuFacilityLeavingWorkPlace.setVisibility(View.VISIBLE);
                                    binding.tvNuFacility.setVisibility(View.VISIBLE);
                                    binding.cardViewSearshLeavingWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                                    binding.progressbar.setVisibility(View.GONE);
                                }

                            }
                        });
                        sheetDialog.dismiss();
                    }
                });

                bottomSheetSearsh.openDialog();
            }
        });
        binding.cardViewSearshLeavingWorkPlace.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityLeavingWorkPlace.setVisibility(View.VISIBLE);
            binding.tvNuFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearshLeavingWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enabel(true);
            bottomSheetSearsh.openDialog();
        });

    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.edDateEndWork.setText(TimeUtil.getDefaultDateText(chosenTime,timeZone));
    }

    public void enabel(boolean states){

        binding.edNuFacilityLeavingWorkPlace.setEnabled(states);
        binding.edDateEndWork.setEnabled(states);
        binding.edEmpName.setEnabled(states);
        binding.edReusonLiving.setEnabled(states);
    }

}