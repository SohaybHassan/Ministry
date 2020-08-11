package com.sh.wm.ministry.featuers.userfile.addressAndContact.view;

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
import com.sh.wm.ministry.databinding.FragmentAddressAndContactBinding;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContact;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.viewmodel.AddressAndContactViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;


public class AddressAndContactFragment extends Fragment {

    private final String TAG = AddressAndContactFragment.class.getName();
    private AddressAndContactViewModel mViewModel;
    private FragmentAddressAndContactBinding binding;

    public static AddressAndContactFragment newInstance() {
        return new AddressAndContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddressAndContactBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddressAndContactViewModel.class);
        mViewModel.userWorkContactLiveData(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), userWorkContactModel -> {

            if (userWorkContactModel != null) {
                UserWorkContact contactModel = userWorkContactModel.getUserWorkContact();
                String state = contactModel.getUSERADDRESSDESC();
                String city = contactModel.getUSERCITYDESC();
                String distinct = contactModel.getUSERREGIONDESC();
                String street = contactModel.getUSERSTREETDESC();
                Object nearestPlace = contactModel.getUSERADDRESSDETAILS();
                Object building = contactModel.getUSERBUILDINGDESC();
                String telephone = contactModel.getUSERTELEPHONE();
                String mobile = contactModel.getUSERMOBILE1();
                Object mobile2 = contactModel.getUSERMOBILE2();
                String email = contactModel.getUSEREMAIL();
                Object facebook = contactModel.getUSERFACEBOOKURL();

                if (nearestPlace == null) nearestPlace = "-";
                if (building == null) building = "-";
                if (mobile2 == null) mobile2 = "-";
                if (facebook == null) facebook = "-";

                binding.etStateAddressContact.setText(state);
                binding.etCityAddressContact.setText(city);
                binding.etDistrictAddressContact.setText(distinct);
                binding.etStreetAddressContact.setText(street);
                binding.etNearestPlaceAddressContact.setText(String.valueOf(nearestPlace));
                binding.etBuildingAddressContact.setText(String.valueOf(building));
                binding.etPhoneAddressContact.setText(telephone);
                binding.etFirstGradeMobileAddressContact.setText(String.valueOf(mobile2));
                binding.etMobileAddressContact.setText(mobile);
                binding.etEmailAddressContact.setText(email);
                binding.etFacebookAddressContact.setText(String.valueOf(facebook));

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

}