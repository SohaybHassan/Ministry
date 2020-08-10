package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHomeBinding;
import com.sh.wm.ministry.databinding.FragmentInspectionVisitingMenuBinding;


public class InspectionVisitingMenuFragment extends Fragment implements View.OnClickListener {
   private FragmentInspectionVisitingMenuBinding binding ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCreate(..)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentInspectionVisitingMenuBinding.inflate(inflater, container, false);
        binding.inspectionMngBtn.setOnClickListener(this);



        return binding.getRoot() ;
    }//end onCreateView(..)

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch(v.getId()){
            case R.id.inspection_mng_btn :

                 intent = new Intent(this.getContext(),InspectionMngFragment.class);
                startActivity(intent);
                break;
            case  R.id.inspection_dec_btn :
//                 intent = new Intent(this.getContext(),.class);
//                startActivity(intent);
                break;
            case R.id.inspection_plane_mng_btn :
                intent = new Intent(this.getContext(), InspectionPlaneManagementFragment.class);
                startActivity(intent);
                break;
            case R.id.inspection_plane_prp_btn :
//                intent = new Intent(this.getContext(),.class);
//                startActivity(intent);
                break;
            case R.id.inspection_visit_btn :
                intent = new Intent(this.getContext(),InspVisitOutOfPlaneFragment.class);
                startActivity(intent);
                break;

        }//end switch

    }//end onClick()
 }//end Class