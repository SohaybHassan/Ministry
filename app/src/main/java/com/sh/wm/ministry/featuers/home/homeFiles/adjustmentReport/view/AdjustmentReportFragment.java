package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.view;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.databinding.FragmentAdjustmentReportBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.viewmodel.AdjustmentReportViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.SubjectNumberAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.ItemAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

import java.util.ArrayList;
import java.util.Calendar;


public class AdjustmentReportFragment extends Fragment {

    private FragmentAdjustmentReportBinding binding;
    private BottomSheetDialog sheetDialog;
    private BottomSheetSearsh bottomSheetSearsh;
    private AdjustmentReportViewModel adjustmentReportViewModel;
    private Observer<Construction> constructionObserver;
    private Observer<PalLaw> palLawObserver;
    private SubjectNumberAdapter subjectNumberAdapter;
    private ArrayList<ItemAdapter> list;
    private int thisPosition;
    public static final String TAG = AdjustmentReportFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
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

        palLawObserver = new Observer<PalLaw>() {
            @Override
            public void onChanged(PalLaw palLaw) {

                if (palLaw != null) {
                    list.remove(thisPosition);
                    list.add(thisPosition, new ItemAdapter(palLaw.getPalLawDesc()));
                    Log.e(TAG, "onCreate: 111");
                    Log.e(TAG, "onCreate: " + palLaw.getPalLawDesc());
                    subjectNumberAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
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
                public void searchByNumber(String num_facility) {
                    binding.progress.setVisibility(View.VISIBLE);
                    adjustmentReportViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), constructionObserver);
                    sheetDialog.dismiss();
                }
            });

            bottomSheetSearsh.openDialog(getString(R.string.numberfacility), getString(R.string.searsh_for_nu_facilty));
        });


        binding.cardViewSearshShAdjustmentReport.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
            binding.tvNuFacilityAdjustmentReport.setVisibility(View.VISIBLE);
            binding.cardViewSearshShAdjustmentReport.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            enapel(true);
            setmargein(0);
            bottomSheetSearsh.openDialog(getString(R.string.numberfacility), getString(R.string.searsh_for_nu_facilty));
        });

        list.add(null);
        subjectNumberAdapter = new SubjectNumberAdapter(list, position -> {
            bottomSheetSearsh = new BottomSheetSearsh(getContext(), sheetDialog, num_facility -> {
                thisPosition = position;
                adjustmentReportViewModel.getPalLaw(num_facility).observe(getViewLifecycleOwner(), palLawObserver);
            });
            sheetDialog.dismiss();
            bottomSheetSearsh.openDialog(getString(R.string.numSubject), getString(R.string.searsh_for_nu_subject));
        });
        binding.edArticleNumberAdjustmentReport.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberAdjustmentReport.setAdapter(subjectNumberAdapter);

        binding.btnAddAdjustmentReport.setOnClickListener(view12 -> {
            if (list.size() - 1 > 3) {
                Toast.makeText(getContext(), "بيكفي يا وحش لعند 5 وبس وشكرا من وجدان", Toast.LENGTH_SHORT).show();
                return;
            }
            if (list.get(list.size() - 1) == null) {
                Toast.makeText(getContext(), "أرجو منك تعبأت الحقل الذي سبق قبل إضافة حقل جديد", Toast.LENGTH_SHORT).show();
                return;
            }

            list.add(null);
            subjectNumberAdapter.notifyDataSetChanged();
        });


        binding.edStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar startTime = Calendar.getInstance();
                int hour = startTime.get(Calendar.HOUR_OF_DAY);
                int minute = startTime.get(Calendar.MINUTE);
                TimePickerDialog startTimePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        binding.edStartTime.setText(i + ":" + i1);
                    }
                }, hour, minute, true);
                startTimePickerDialog.setTitle("Select Start Time");
                startTimePickerDialog.show();
            }
        });

        binding.edEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar endTime = Calendar.getInstance();
                int hour = endTime.get(Calendar.HOUR_OF_DAY);
                int minute = endTime.get(Calendar.MINUTE);
                TimePickerDialog endtimePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        binding.edEndTime.setText(i + ":" + i1);
                    }
                }, hour, minute, true);
                endtimePickerDialog.setTitle("Select  End Time");
                endtimePickerDialog.show();
            }
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