package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentAlarmFormBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter.AlarmAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.ItemAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.viewmodel.AlarmFormViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class AlarmFormFragment extends Fragment implements DateAdder.Listener {
    private BottomSheetDialog sheetDialog;
    private BottomSheetSearsh bottomSheetSearsh;
    private FragmentAlarmFormBinding binding;
    private AlarmFormViewModel alarmFormViewModel;

    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;
    private int mYear, mMonth, mDay;

    private int thisPosition;

    private AlarmAdapter alarmAdapter;
    private Observer<PalLaw> palLawObserver;
    private Observer<Construction> constructionObserver;
    // new Observer<Construction>()
    private ArrayList<ItemAdapter> lawList;

    public static final String TAG = AlarmFormFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lawList = new ArrayList<>();
        palLawObserver = new Observer<PalLaw>() {
            @Override
            public void onChanged(PalLaw palLaw) {

                if (palLaw != null) {
                    lawList.remove(thisPosition);
                    lawList.add(thisPosition,new ItemAdapter(palLaw.getPalLawDesc()));
                    Log.e(TAG, "onCreate: 111");
                    Log.e(TAG, "onCreate: " + palLaw.getPalLawDesc());
                    alarmAdapter.notifyDataSetChanged();
                }
            }
        };

        constructionObserver=new Observer<Construction>() {
            @Override
            public void onChanged(Construction construction) {
                if (construction != null) {

                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                    binding.cardViewSearshAlarmForm.tvOwnerName.setText("اسم المالك : " + name);
                    binding.cardViewSearshAlarmForm.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                    binding.cardViewSearshAlarmForm.tvOwnerId.setText("رقم هوية المالك : " + user_cn);


                    binding.edNuFacilityAlarmFormFragment.setVisibility(View.GONE);
                    binding.tvNuFacilityAlarmFormFragment.setVisibility(View.GONE);
                    binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    setmargein(165);
                    desapel(true);
                    binding.progressbar.setVisibility(View.GONE);

                } else {

                    binding.edNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
                    binding.tvNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
                    binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                    binding.progressbar.setVisibility(View.GONE);
                    setmargein(0);
                    desapel(true);
                    Toast.makeText(getContext(), "رقم منشأة خاطاْ", Toast.LENGTH_SHORT).show();

                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAlarmFormBinding.inflate(inflater, container, false);
        sheetDialog = new BottomSheetDialog(getContext());
        //getDate from ed_visite
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        //get time zone
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alarmFormViewModel = new ViewModelProvider(this).get(AlarmFormViewModel.class);
        binding.edNuFacilityAlarmFormFragment.setOnClickListener(view12 -> {
            bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, num_facility -> {
                binding.progressbar.setVisibility(View.VISIBLE);
                desapel(false);
                alarmFormViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), constructionObserver);
                sheetDialog.dismiss();
            });
            bottomSheetSearsh.openDialog();
        });
        binding.edDateVisit.setOnClickListener(view15 -> {
            dateAdder.show();
        });
        binding.edDateAlarm.setOnClickListener(view16 -> {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            binding.edDateAlarm.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });
        binding.cardViewSearshAlarmForm.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.tvNuFacilityAlarmFormFragment.setVisibility(View.VISIBLE);
            binding.cardViewSearshAlarmForm.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            setmargein(0);
            desapel(true);
            bottomSheetSearsh.openDialog();

        });


        lawList.add(null);
        alarmAdapter = new AlarmAdapter(lawList, position -> {
            thisPosition = position;
            bottomSheetSearsh = new BottomSheetSearsh(getContext(), sheetDialog, num_facility -> alarmFormViewModel.getPalLaw(num_facility).observe(getViewLifecycleOwner(), palLawObserver));
            sheetDialog.dismiss();
            bottomSheetSearsh.openDialog();
        });

        binding.edArticleNumberAlarmFormFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.edArticleNumberAlarmFormFragment.setAdapter(alarmAdapter);


        binding.btnAdd.setOnClickListener(view1 -> {
            if (lawList.size() - 1 > 3 ) {
                Toast.makeText(getContext(), "بيكفي يا وحش لعند 5 وبس وشكرا من وجدان", Toast.LENGTH_SHORT).show();
                return;
            }
            if (lawList.get(lawList.size()-1)==null){
                Toast.makeText(getContext(), "أرجو منك تعبأت الحقل الذي سبق قبل إضافة حقل جديد", Toast.LENGTH_SHORT).show();
                return;
            }
            lawList.add(null);
            alarmAdapter.notifyDataSetChanged();
        });
    }


    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.edDateVisit.setText(TimeUtil.getDefaultDateText(timeChosen, timeZone));
    }


    public void setmargein(int margine) {
        int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) binding.tvDateVisit.getLayoutParams();
        layoutParams.setMargins(0, dp, 0, 0);
        binding.tvDateVisit.setLayoutParams(layoutParams);
        int dp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margine, getResources().getDisplayMetrics());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) binding.tvDateAlarm.getLayoutParams();
        layoutParams2.setMargins(0, dp2, 0, 0);
        binding.tvDateAlarm.setLayoutParams(layoutParams2);

    }


    public void desapel(boolean desabel) {

        binding.edNuFacilityAlarmFormFragment.setEnabled(desabel);
        binding.edDateAlarm.setEnabled(desabel);
        binding.edDateVisit.setEnabled(desabel);
        binding.edArticleNumberAlarmFormFragment.setEnabled(desabel);
        binding.edMember1.setEnabled(desabel);
        binding.edMember2.setEnabled(desabel);
        binding.edMember3.setEnabled(desabel);


    }



}