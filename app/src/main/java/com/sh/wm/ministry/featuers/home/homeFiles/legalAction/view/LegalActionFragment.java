package com.sh.wm.ministry.featuers.home.homeFiles.legalAction.view;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentLegalActionBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.legalAction.viewmodel.LegalActionViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;


public class LegalActionFragment extends Fragment {
    private FragmentLegalActionBinding binding;
    private BottomSheetSearsh bottomSheetSearsh;
    private BottomSheetDialog sheetDialog;
    private LegalActionViewModel legalActionViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLegalActionBinding.inflate(inflater, container, false);
        sheetDialog = new BottomSheetDialog(getContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        legalActionViewModel = new ViewModelProvider(this).get(LegalActionViewModel.class);
        binding.edNuFacilityLegalAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searshByNumber(String num_facility) {
                        binding.progress.setVisibility(View.VISIBLE);
                        enabel(false);
                        legalActionViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), new Observer<Construction>() {
                            @Override
                            public void onChanged(Construction construction) {
                                if (construction != null) {

                                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                                    binding.cardViewSearshShLegalAction.tvOwnerName.setText("اسم المالك : " + name);
                                    binding.cardViewSearshShLegalAction.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                                    binding.cardViewSearshShLegalAction.tvOwnerId.setText("رقم هوية المالك : " + user_cn);

                                    binding.edNuFacilityLegalAction.setVisibility(View.GONE);
                                    binding.tvNuFacilityLegalAction.setVisibility(View.GONE);
                                    binding.cardViewSearshShLegalAction.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                                    binding.progress.setVisibility(View.GONE);
                                    enabel(true);
                                    setmargein(165);
                                } else {
                                    enabel(true);
                                    binding.edNuFacilityLegalAction.setVisibility(View.VISIBLE);
                                    binding.tvNuFacilityLegalAction.setVisibility(View.VISIBLE);
                                    binding.cardViewSearshShLegalAction.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                                    binding.progress.setVisibility(View.GONE);
                                    setmargein(0);
                                }

                            }
                        });
                        sheetDialog.dismiss();

                    }
                });
                bottomSheetSearsh.openDialog();
            }
        });

        binding.cardViewSearshShLegalAction.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityLegalAction.setVisibility(View.VISIBLE);
            binding.tvNuFacilityLegalAction.setVisibility(View.VISIBLE);
            binding.cardViewSearshShLegalAction.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enabel(true);
            setmargein(0);
            bottomSheetSearsh.openDialog();
        });
    }

    public void enabel(boolean states) {
        binding.edNuFacilityLegalAction.setEnabled(states);
        binding.edArticleNumberLegalAction.setEnabled(states);
        binding.edMember1.setEnabled(states);
        binding.edMember2.setEnabled(states);
        binding.edMember3.setEnabled(states);
        binding.btnAddLegalAction.setEnabled(states);
        binding.btnSaveLegalAction.setEnabled(states);

    }

    public void setmargein(int margine) {
        int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) binding.tvText.getLayoutParams();
        layoutParams.setMargins(0, dp, 0, 0);
        binding.tvText.setLayoutParams(layoutParams);

    }
}