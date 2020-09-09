package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentVisitStartBinding;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;


public class VisitStartFragment extends Fragment implements View.OnClickListener {
    private FragmentVisitStartBinding binding;
    private OnFragmentInteractionListener listener ;
    public VisitStartFragment() {
        // Required empty public constructor
    }


    public static VisitStartFragment newInstance() {
        VisitStartFragment fragment = new VisitStartFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVisitStartBinding.inflate(inflater, container, false);
        binding.update.setOnClickListener(this);
        binding.workers.setOnClickListener(this);
        binding.safe.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentInteractionListener)context;
    }

    @Override
    public void onClick(View view) {
              switch(view.getId()){
                  case R.id.update:
                      listener.onFragmentInteraction(R.id.update);
                      break;
                  case R.id.safe :
                      listener.onFragmentInteraction(R.id.safe);
                      break ;
                  case R.id.workers:
                      listener.onFragmentInteraction(R.id.workers);
                      break ;
              }//end switch
    }//end onClick
}