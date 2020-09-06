package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentBlankInfoBinding;


public class BlankInfoFragment extends Fragment {
private FragmentBlankInfoBinding binding ;

    public BlankInfoFragment() {
        // Required empty public constructor
    }


    public static BlankInfoFragment newInstance(String param1, String param2) {
        BlankInfoFragment fragment = new BlankInfoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding = FragmentBlankInfoBinding.inflate(inflater , container , false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}