package com.sh.wm.ministry.featuers.userfile.majorservices.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.custem.datepicker.DateAdder;
import com.sh.wm.ministry.custem.datepicker.TimeUtil;
import com.sh.wm.ministry.databinding.FragmentMajorServicesBinding;
import com.sh.wm.ministry.featuers.sso.model.userrole.UserWorkInfo;
import com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel.MajorServicesViewModel;

import java.util.TimeZone;

import static android.content.Context.MODE_PRIVATE;

public class MajorServicesFragment extends Fragment implements DateAdder.Listener {

    private final String TAG = MajorServicesFragment.class.getName();
    private FragmentMajorServicesBinding binding;
    private DateAdder dateAdder;
    private TimeZone timeZone;
    private long chosenTime;

    public static MajorServicesFragment newInstance() {
        return new MajorServicesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMajorServicesBinding.inflate(inflater, container, false);
        timeZone = TimeZone.getDefault();
        chosenTime = System.currentTimeMillis();
        dateAdder = new DateAdder(getActivity().getSupportFragmentManager(), this);
        binding.tvBirthDateMajorServices.setOnClickListener(view -> dateAdder.show());
        binding.tvDeathDateMajorServices.setOnClickListener(view -> {
            dateAdder.show();
        });
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MajorServicesViewModel mViewModel = new ViewModelProvider(this).get(MajorServicesViewModel.class);

        mViewModel.getUserWorkInfoLiveData().observe(getViewLifecycleOwner(), userWorkInfo -> {

            if (userWorkInfo != null) {

                //Save UserId
                SharedPreferences.Editor tokenEditor = getActivity().getSharedPreferences(getString(R.string.key_userId), MODE_PRIVATE).edit();
                tokenEditor.putString(getString(R.string.key_userId), userWorkInfo.getUserWorkInfo().getUSERID());
                tokenEditor.apply();
                tokenEditor.commit();

                UserWorkInfo info = userWorkInfo.getUserWorkInfo();
                String userId = info.getUSERSN();
                String firstName = info.getUSERFNAMEAR();
                String fatherName = info.getUSERSNAMEAR();
                String grandName = info.getUSERTNAMEAR();
                String familyName = info.getUSERLNAMEAR();
                String gender = info.getUSERSEX();
                String birthPlace = info.getBIRTHPLACE();
                String birthDate = info.getBRITHDATE();
                String motherName = info.getUSERMOTHERNAME();
                String childNumber = info.getUSERCHIDEDNUM();
                String socialStatus = info.getSOCIALSTATUS();
                String nationalId = info.getUSERNATIONALITYID();
                String otherNationalId = info.getUSERNATIONALITYOTHERID();


                binding.etUserIdMajorServices.setText(userId);
                binding.etFirstNameMajorServices.setText(firstName);
                binding.etFatherName.setText(fatherName);
                binding.etGrandNameMajorServices.setText(grandName);
                binding.etFamilyName.setText(familyName);
                binding.etGenderMajorServices.setText(gender);
                binding.etBirthPlaceMajorServices.setText(birthPlace);
                binding.tvBirthDateMajorServices.setText(birthDate);
                binding.etMotherNameMajorServices.setText(motherName);
                binding.etChildNumberMajorServices.setText(childNumber);

                if (birthPlace == null) {
                    binding.etBirthPlaceMajorServices.setText("-");
                }

                if (info.getUSERDEATHDATE() == null) {
                    binding.tvDeathDateMajorServices.setText("-");
                } else {
                    String deathDate = String.valueOf(info.getUSERDEATHDATE());
                    binding.tvDeathDateMajorServices.setText(deathDate);
                }

                binding.etSocialStatusMajorServices.setText(socialStatus);
                binding.etNationalityMajorServices.setText(nationalId);
                binding.etOtherNationalityIdMajorServices.setText(otherNationalId);
            } else {
                new ToastMsg(getContext()).toastIconError(getString(R.string.proccess_failed));
            }

        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDateTimeChosen(long timeChosen) {
        chosenTime = timeChosen;
        binding.tvBirthDateMajorServices.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
        binding.tvDeathDateMajorServices.setText(TimeUtil.getDefaultDateText(chosenTime, timeZone));
    }




}