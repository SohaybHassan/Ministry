package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInspectionVisitingMenuBinding;
import com.sh.wm.ministry.featuers.home.HomeFragment;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;


public class VisitingMenuFragment extends Fragment implements View.OnClickListener {
    private FragmentInspectionVisitingMenuBinding binding;
    private OnFragmentInteractionListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInspectionVisitingMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }//end onCreateView(..)

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.inspectionMngCard.setOnClickListener(this);
        binding.inspectionMngNo.setOnClickListener(this);
        binding.inspectionMngTxt.setOnClickListener(this);
        binding.inspectionDecBtn.setOnClickListener(this);
        binding.inspectionDecNo.setOnClickListener(this);
        binding.inspectionDecTxt.setOnClickListener(this);
        binding.inspectionPlaneMngCard.setOnClickListener(this);
        binding.inspectionPlaneMngNo.setOnClickListener(this);
        binding.inspectionPlaneMngTxt.setOnClickListener(this);
        binding.inspectionVisitBtn.setOnClickListener(this);
        binding.inspectionVisitNo.setOnClickListener(this);
        binding.inspectionVisitTxt.setOnClickListener(this);
        binding.inspectionPlanePrpBtn.setOnClickListener(this);
        binding.inspectionPlanePrpNo.setOnClickListener(this);
        binding.inspectionPlanePrpTxt.setOnClickListener(this);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof HomeFragment.OnHomeFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inspection_mng_card:
            case R.id.inspection_mng_no:
            case R.id.inspection_mng_txt:
                listener.onFragmentInteraction(R.id.inspection_mng_card);
                break;
            case R.id.inspection_dec_btn:
            case R.id.inspection_dec_no:
            case R.id.inspection_dec_txt:
                listener.onFragmentInteraction(R.id.inspection_dec_btn);
                break;
            case R.id.inspection_plane_mng_card:
            case R.id.inspection_plane_mng_no:
            case R.id.inspection_plane_mng_txt:
                listener.onFragmentInteraction(R.id.inspection_plane_mng_card);
                break;
            case R.id.inspection_plane_prp_btn:
            case R.id.inspection_plane_prp_no:
            case R.id.inspection_plane_prp_txt:
                listener.onFragmentInteraction(R.id.inspection_plane_prp_btn);
                break;
            case R.id.inspection_visit_btn:
            case R.id.inspection_visit_no:
            case R.id.inspection_visit_txt:
                listener.onFragmentInteraction(R.id.inspection_visit_btn);
                break;
        }

    }
}//end Class