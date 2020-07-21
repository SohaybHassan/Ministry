package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.view;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentAdjustmentReportBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.viewmodel.AdjustmentReportViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;


public class AdjustmentReportFragment extends Fragment {

    private FragmentAdjustmentReportBinding binding;
    BottomSheetDialog sheetDialog;
    BottomSheetSearsh bottomSheetSearsh;
    AdjustmentReportViewModel adjustmentReportViewModel;
    private Observer<Construction> constructionObserver;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constructionObserver = new Observer<Construction>() {
            @Override
            public void onChanged(Construction construction) {
                if (construction != null) {

                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();
                    binding.cardViewSearshShAdjustmentReport.tvOwnerName.setText("اسم المالك : " + name);
                    binding.cardViewSearshShAdjustmentReport.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                    binding.cardViewSearshShAdjustmentReport.tvOwnerId.setText("رقم هوية المالك : " + user_cn);

                    binding.edNuFacilityAdjustmentReport.setVisibility(View.GONE);
                    binding.tvNuFacilityAdjustmentReport.setVisibility(View.GONE);
                    binding.cardViewSearshShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                    setmargein(165);
                    enapel(true);

                } else {
                    Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                    binding.progress.setVisibility(View.GONE);
                    enapel(true);
                    setmargein(0);
                    binding.edNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
                    binding.tvNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
                    binding.cardViewSearshShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdjustmentReportBinding.inflate(inflater, container, false);
        sheetDialog = new BottomSheetDialog(getContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adjustmentReportViewModel = new ViewModelProvider(this).get(AdjustmentReportViewModel.class);
        binding.edNuFacilityAdjustmentReport.setOnClickListener(view1 -> {
            bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                @Override
                public void searshByNumber(String num_facility) {
                    binding.progress.setVisibility(View.VISIBLE);
                    adjustmentReportViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), constructionObserver);
                    sheetDialog.dismiss();
                }
            });

            bottomSheetSearsh.openDialog();
        });


        binding.cardViewSearshShAdjustmentReport.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
            binding.tvNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
            binding.cardViewSearshShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enapel(true);
            setmargein(0);
            bottomSheetSearsh.openDialog();
        });
    }

    public void enapel(boolean states) {

        binding.edNuFacilityAdjustmentReport.setEnabled(states);
        binding.edArticleNumberAdjustmentReport.setEnabled(states);
        binding.edStartTime.setEnabled(states);
        binding.tvEndTime.setEnabled(states);
        binding.edMember1.setEnabled(states);
        binding.edMember2.setEnabled(states);
        binding.edMember3.setEnabled(states);
        binding.btnAddAdjustmentReport.setEnabled(states);
        binding.btnSaveAlarmFormFragment.setEnabled(states);

    }


    public void setmargein(int margine) {
        int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) binding.tvEndTime.getLayoutParams();
        layoutParams.setMargins(0, dp, 0, 0);
        binding.tvEndTime.setLayoutParams(layoutParams);
        int dp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) binding.tvTimeSatrt.getLayoutParams();
        layoutParams2.setMargins(0, dp2, 0, 0);
        binding.tvTimeSatrt.setLayoutParams(layoutParams2);

    }
}