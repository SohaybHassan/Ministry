package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart.FaciltyUpdate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.databinding.FragmentLegalBinding;


public class LegalFragment extends Fragment {
private FragmentLegalBinding binding ;


    public LegalFragment() {
        // Required empty public constructor
    }


    public static LegalFragment newInstance(String param1, String param2) {
        LegalFragment fragment = new LegalFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLegalBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}