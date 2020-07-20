package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.view;

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
import com.sh.wm.ministry.databinding.FragmentCloseFacilityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.viewmodel.CloseFacilityViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;


public class CloseFacilityFragment extends Fragment {

    private CloseFacilityViewModel closeFacilityViewModel;
    private BottomSheetDialog sheetDialog;
    private BottomSheetSearsh bottomSheetSearsh;
    FragmentCloseFacilityBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCloseFacilityBinding.inflate(inflater, container, false);
        sheetDialog = new BottomSheetDialog(getContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        closeFacilityViewModel = new ViewModelProvider(this).get(CloseFacilityViewModel.class);


        binding.edNuFacilityCloseFacility.setOnClickListener(view1 -> {
            bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                @Override
                public void searshByNumber(String num_facility) {
                    binding.progress.setVisibility(View.VISIBLE);
                    enapel(false);
                    closeFacilityViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), new Observer<Construction>() {
                        @Override
                        public void onChanged(Construction construction) {
                            if (construction != null) {

                                String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                                String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                                String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();
                                binding.cardViewSearshShCloseFacility.tvOwnerName.setText("اسم المالك : " + name);
                                binding.cardViewSearshShCloseFacility.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                                binding.cardViewSearshShCloseFacility.tvOwnerId.setText("رقم هوية المالك : " + user_cn);

                                binding.edNuFacilityCloseFacility.setVisibility(View.GONE);
                                binding.tvNuFacilityCloseFacility.setVisibility(View.GONE);
                                binding.cardViewSearshShCloseFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                                binding.progress.setVisibility(View.GONE);
                                setmargein(165);
                                enapel(true);

                            } else {
                                Toast.makeText(getContext(), "رقم منشأة خطاء", Toast.LENGTH_SHORT).show();
                                binding.progress.setVisibility(View.GONE);
                                enapel(true);
                                binding.edNuFacilityCloseFacility.setVisibility(View.VISIBLE);
                                binding.tvNuFacilityCloseFacility.setVisibility(View.VISIBLE);
                                setmargein(8);
                                binding.cardViewSearshShCloseFacility.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                            }

                        }
                    });
                    sheetDialog.dismiss();
                }
            });
            bottomSheetSearsh.openDialog();
        });


        binding.cardViewSearshShCloseFacility.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityCloseFacility.setVisibility(View.VISIBLE);
            binding.tvNuFacilityCloseFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearshShCloseFacility.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enapel(true);
            setmargein(0);
            bottomSheetSearsh.openDialog();
        });

    }

    public void enapel(boolean states){
        binding.edNuFacilityCloseFacility.setEnabled(states);
        binding.edArticleNumberCloseFacility.setEnabled(states);
        binding.btnAddCloseFacility.setEnabled(states);
        binding.btnSaveLegalAction.setEnabled(states);
        binding.radioGroup.setEnabled(states);


    }
    public void setmargein(int margine) {
        int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) binding.tvText.getLayoutParams();
        layoutParams.setMargins(0, dp, 0, 0);
        binding.tvText.setLayoutParams(layoutParams);

    }

}