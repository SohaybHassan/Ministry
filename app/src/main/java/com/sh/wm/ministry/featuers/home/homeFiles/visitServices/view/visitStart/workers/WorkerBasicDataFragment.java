package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart.workers;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentWorkerBasicDataBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;


public class WorkerBasicDataFragment extends Fragment {
private FragmentWorkerBasicDataBinding binding ;
public static final String TAG=WorkerBasicDataFragment.class.getCanonicalName();
private OnFragmentInteractionListener listener ;
    public WorkerBasicDataFragment() {
        // Required empty public constructor
    }


    public static WorkerBasicDataFragment newInstance(String param1, String param2) {
        WorkerBasicDataFragment fragment = new WorkerBasicDataFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkerBasicDataBinding.inflate(inflater,container,false);
        binding.wrNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragmentInteraction(view.getId());
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentInteractionListener) context;
    }
}