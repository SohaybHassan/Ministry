package com.sh.wm.ministry.featuers.home.homeFiles.inspection.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;


public class InspectionVisitingMenuFragment extends Fragment implements View.OnClickListener {

    CardView[] cards = new CardView[5];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCreate(..)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inspection_visiting_menu, container, false);
        cards[0]= view.findViewById(R.id.inspection_mng_btn);
        cards[1]= view.findViewById(R.id.inspection_dec_btn);
        cards[2]= view.findViewById(R.id.inspection_plane_mng_btn);
        cards[3]= view.findViewById(R.id.inspection_plane_prp_btn);
        cards[4]= view.findViewById(R.id.inspection_visit_btn);

        for(CardView cr : cards){
            cr.setOnClickListener(this);
        }//end for


        return view ;
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