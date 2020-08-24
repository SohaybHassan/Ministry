package com.sh.wm.ministry.featuers.userfile.majorservices.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.sh.wm.ministry.network.utiels.ApiConstent;

import java.util.TimeZone;

import static android.content.Context.MODE_PRIVATE;

public class MajorServicesFragment extends Fragment {

    private final String TAG = MajorServicesFragment.class.getName();
    private FragmentMajorServicesBinding binding;

    public static MajorServicesFragment newInstance() {
        return new MajorServicesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMajorServicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.progress.setVisibility(View.VISIBLE);
        binding.btSaveMajorServices.setEnabled(false);

        MajorServicesViewModel mViewModel = new ViewModelProvider(this).get(MajorServicesViewModel.class);
        mViewModel.getUserWorkInfoLiveData().observe(getViewLifecycleOwner(), userWorkInfo -> {

            if (userWorkInfo != null) {

                //Save UserId
                SharedPreferences.Editor tokenEditor = getActivity().getSharedPreferences(getString(R.string.key_userId), MODE_PRIVATE).edit();
                tokenEditor.putString(getString(R.string.key_userId), userWorkInfo.getUserWorkInfo().getUSERID());
                tokenEditor.apply();
                tokenEditor.commit();

                binding.progress.setVisibility(View.INVISIBLE);
                binding.btSaveMajorServices.setEnabled(true);

                UserWorkInfo info = userWorkInfo.getUserWorkInfo();

                binding.etUserIdMajorServices.setText(info.getUSERSN());
                binding.etFirstNameMajorServices.setText(info.getUSERFNAMEAR());
                binding.etFatherName.setText(info.getUSERSNAMEAR());
                binding.etGrandNameMajorServices.setText(info.getUSERTNAMEAR());
                binding.etFamilyName.setText(info.getUSERLNAMEAR());
//                binding.etDocumentType.setText(info.get);
                binding.etGenderMajorServices.setText(info.getUSERSEX());
                if (info.getBIRTHPLACE() == null)
                    binding.etBirthPlaceMajorServices.setText("-");
                else
                    binding.etBirthPlaceMajorServices.setText(info.getBIRTHPLACE());
                binding.tvBirthDateMajorServices.setText(info.getBRITHDATE());
                binding.etMotherNameMajorServices.setText(info.getUSERMOTHERNAME());
                binding.etChildNumberMajorServices.setText(info.getUSERCHIDEDNUM());
                if (info.getUSERDEATHDATE() == null)
                    binding.tvDeathDateMajorServices.setText("-");
                else
                    binding.tvDeathDateMajorServices.setText(String.valueOf(info.getUSERDEATHDATE()));
                binding.etSocialStatusMajorServices.setText(info.getSOCIALSTATUS());
                binding.etNationalityMajorServices.setText(info.getUSERNATIONALITYID());
                binding.etOtherNationalityIdMajorServices.setText(info.getUSERNATIONALITYOTHERID());
                binding.etDirectorateBelongs.setText(info.getUSERDIRECTORATE());

                // Save img in SharedPreference
                SharedPreferences.Editor userEditor = getActivity().getSharedPreferences(ApiConstent.USER_IMG, MODE_PRIVATE).edit();
                userEditor.putString(ApiConstent.USER_IMG, info.getUSERIMG());
                userEditor.apply();
                userEditor.commit();

            } else {
                new ToastMsg(getContext()).toastIconError(getString(R.string.proccess_failed));
                binding.progress.setVisibility(View.INVISIBLE);
                binding.btSaveMajorServices.setEnabled(true);
            }

        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}