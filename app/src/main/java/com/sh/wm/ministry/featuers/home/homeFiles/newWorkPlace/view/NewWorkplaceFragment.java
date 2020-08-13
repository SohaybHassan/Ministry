package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.view;

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
import com.sh.wm.ministry.databinding.FragmentNewWorkplaceBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.viewmodel.NewWorkPlaceViewModel;

import java.util.TimeZone;


public class NewWorkplaceFragment extends Fragment implements DateAdder.Listener {

    private FragmentNewWorkplaceBinding binding;
    private ShMyDialog dialog;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;
    private BottomSheetSearsh bottomSheetSearsh;
    private BottomSheetDialog sheetDialog;
    private NewWorkPlaceViewModel newWorkPlaceViewModel;
    private Observer<Construction>constructionObserver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constructionObserver=new Observer<Construction>() {
            @Override
            public void onChanged(Construction construction) {
                if (construction != null) {

                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                    binding.cardViewSearshNewWorkPlace.tvOwnerName.setText("اسم المالك : " + name);
                    binding.cardViewSearshNewWorkPlace.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                    binding.cardViewSearshNewWorkPlace.tvOwnerId.setText("رقم هوية المالك : "+user_cn);

                    binding.edNuFacilityNewWorkPlace.setVisibility(View.GONE);
                    binding.tvNuFacility.setVisibility(View.GONE);
                    binding.cardViewSearshNewWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    binding.progressbar.setVisibility(View.GONE);
                    ensbel(true);


                } else {
                    Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                    binding.tvNuFacility.setVisibility(View.VISIBLE);
                    binding.cardViewSearshNewWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                    binding.edNuFacilityNewWorkPlace.setVisibility(View.VISIBLE);
                    binding.progressbar.setVisibility(View.GONE);
                    ensbel(true);
                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentNewWorkplaceBinding.inflate(inflater, container, false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        sheetDialog = new BottomSheetDialog(getActivity());

        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newWorkPlaceViewModel= new ViewModelProvider(this).get(NewWorkPlaceViewModel.class);

        binding.btnSaveNewWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void save(View view) {
                        Toast.makeText(getContext(), "تم الحفظ بنجاح", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void edit(View view) {
                        dialog.dismiss();
                    }
                }, getString(R.string.new_work_place),getString(R.string.save),getString(R.string.edit));
                dialog.show(getParentFragmentManager(), "");
            }
        });


        binding.edDateEndWorkNewWorke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateAdder.show();
            }
        });


        binding.edNuFacilityNewWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetSearsh = new BottomSheetSearsh(getActivity(), sheetDialog, new BottomSheetSearsh.bottomSheetSearsh() {
                    @Override
                    public void searchByNumber(String num_facility) {
                        binding.progressbar.setVisibility(View.VISIBLE);
                        ensbel(false);
                        newWorkPlaceViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), constructionObserver);
                        sheetDialog.dismiss();
                    }
                });

                bottomSheetSearsh.openDialog(getString(R.string.numberfacility),getString(R.string.searsh_for_nu_facilty));
            }
        });
        binding.cardViewSearshNewWorkPlace.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacilityNewWorkPlace.setVisibility(View.VISIBLE);
            binding.tvNuFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearshNewWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            ensbel(true);
            bottomSheetSearsh.openDialog(getString(R.string.numberfacility),getString(R.string.searsh_for_nu_facilty));
        });


    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.edDateEndWorkNewWorke.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
    public void ensbel(boolean states){
        binding.edNuFacilityNewWorkPlace.setEnabled(states);
        binding.edDateEndWorkNewWorke.setEnabled(states);
    }

}