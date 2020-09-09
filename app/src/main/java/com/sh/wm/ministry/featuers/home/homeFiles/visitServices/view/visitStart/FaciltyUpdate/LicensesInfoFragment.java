package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart.FaciltyUpdate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.databinding.FragmentLicensesInfoBinding;


public class LicensesInfoFragment extends Fragment {
    private FragmentLicensesInfoBinding binding;


    public LicensesInfoFragment() {
        // Required empty public constructor
    }


    public static LicensesInfoFragment newInstance(String param1, String param2) {
        LicensesInfoFragment fragment = new LicensesInfoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLicensesInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}