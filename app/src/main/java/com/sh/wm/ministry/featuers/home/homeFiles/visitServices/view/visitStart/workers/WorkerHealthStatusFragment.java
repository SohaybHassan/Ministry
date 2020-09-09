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
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentWorkerHealthStatusBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;


public class WorkerHealthStatusFragment extends Fragment {
FragmentWorkerHealthStatusBinding binding;
public static final String TAG = WorkerHealthStatusFragment.class.getCanonicalName();
private OnFragmentInteractionListener listener;

    public WorkerHealthStatusFragment() {
        // Required empty public constructor
    }


    public static WorkerHealthStatusFragment newInstance(String param1, String param2) {
        WorkerHealthStatusFragment fragment = new WorkerHealthStatusFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkerHealthStatusBinding.inflate(inflater,container,false);
        binding.saveHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Horaaaaaaaay", Toast.LENGTH_SHORT).show();
                binding.headerFinish.setVisibility(View.VISIBLE);
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