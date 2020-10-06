package com.sh.wm.ministry.featuers.userfile.majorservices.view;

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
import com.sh.wm.ministry.databinding.FragmentMajorServicesBinding;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserWorkInfo;
import com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel.MajorServicesViewModel;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

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

        mViewModel.getUserInfo().observe(getViewLifecycleOwner(), userWorkInfo -> {
            if (userWorkInfo != null) {
                binding.progress.setVisibility(View.INVISIBLE);
                binding.btSaveMajorServices.setEnabled(true);

                UserWorkInfo info = userWorkInfo.getUserWorkInfo();

                binding.etUserIdMajorServices.setText(info.getUSERSN());
                binding.etFirstNameMajorServices.setText(info.getUSERFNAMEAR());
                binding.etFatherName.setText(info.getUSERSNAMEAR());
                binding.etGrandNameMajorServices.setText(info.getUSERTNAMEAR());
                binding.etFamilyName.setText(info.getUSERLNAMEAR());
                binding.etDocumentType.setText(info.getUSERDOCSTYPE());
                binding.etDocumentNo.setText(info.getUSERSN());
                binding.etGenderMajorServices.setText(info.getUSERSEX());
                binding.etBirthPlaceMajorServices.setText(info.getBIRTHPLACE());
                binding.tvBirthDateMajorServices.setText(info.getBRITHDATE());
                binding.etMotherNameMajorServices.setText(info.getUSERMOTHERNAME());
                binding.etSocialStatusMajorServices.setText(info.getSOCIALSTATUS());
                binding.etChildNumberMajorServices.setText(info.getUSERCHIDEDNUM());
                if (info.getUSERDEATHDATE() == null)
                    binding.tvDeathDateMajorServices.setText("-");
                else
                    binding.tvDeathDateMajorServices.setText(String.valueOf(info.getUSERDEATHDATE()));
                //from constant api
                Country country=mViewModel.getUserCountry(info.getUSERNATIONALITYID());
                if (country != null)
                    binding.etNationalityMajorServices.setText(country.getCDARBTR());
                else
                    binding.etNationalityMajorServices.setText("-");
                Country otherCountry=mViewModel.getUserCountry(info.getUSERNATIONALITYOTHERID());
                if (otherCountry != null)
                    binding.etOtherNationalityIdMajorServices.setText(otherCountry.getCDARBTR());
                else
                    binding.etOtherNationalityIdMajorServices.setText("-");
                //////////////////
                if (!info.getUSERDIRECTORATE().equals("null")) {
                    binding.etDirectorateBelongs.setText(info.getUSERDIRECTORATE());
                    binding.etDirectorateBelongs.setEnabled(false);
                } else {
                    binding.etDirectorateBelongs.setEnabled(true);
                }
                binding.etAgeMajorServices.setText(info.getUSERAGE());
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