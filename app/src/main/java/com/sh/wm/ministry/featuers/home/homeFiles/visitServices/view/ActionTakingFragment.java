package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentActionTakingBinding;


public class ActionTakingFragment extends Fragment {
private FragmentActionTakingBinding binding ;


    public ActionTakingFragment() {
        // Required empty public constructor
    }


    public static ActionTakingFragment newInstance(String param1, String param2) {
        ActionTakingFragment fragment = new ActionTakingFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentActionTakingBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}