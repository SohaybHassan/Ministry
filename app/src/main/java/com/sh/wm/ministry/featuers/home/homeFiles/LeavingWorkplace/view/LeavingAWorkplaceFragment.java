package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentLeavingAWorkplaceBinding;

import java.util.TimeZone;


public class LeavingAWorkplaceFragment extends Fragment implements DateAdder.Listener {

    private FragmentLeavingAWorkplaceBinding binding;
    private DateAdder dateAdder;
    private ShMyDialog dialog;
    private TimeZone timeZone;
    private long chosenTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLeavingAWorkplaceBinding.inflate(inflater, container, false);
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSaveLeavingWorkPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        Toast.makeText(getContext(), "تم الحفظ بنجاح", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        dialog.dismiss();
                    }
                }, getString(R.string.leaving_work_place));
                dialog.show(getParentFragmentManager(),"");
            }
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
                binding.edNuFacilityLeavingWorkPlace.setVisibility(View.GONE);
                binding.tvNuFacility.setVisibility(View.GONE);
                binding.cardViewSearshLeavingWorkPlace.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.edDateEndWork.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }
}