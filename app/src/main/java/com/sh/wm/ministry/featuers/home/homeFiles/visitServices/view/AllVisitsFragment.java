package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentAllVisitsBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter.VisitsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitCard;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitPlanData;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel.VisitViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class AllVisitsFragment extends Fragment {
 private FragmentAllVisitsBinding binding ;
 private VisitsAdapter adapter ;
 private VisitViewModel viewModel ;
 private List<VisitCard> cards ;
 private Observer<VisitPlanData> observer ;
    public AllVisitsFragment() {
        // Required empty public constructor
    }//end constructor


    @NotNull
    public static AllVisitsFragment newInstance(String param1, String param2) {
        AllVisitsFragment fragment = new AllVisitsFragment();

        return fragment;
    }//end newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         adapter= new VisitsAdapter();
         cards= new ArrayList<>();

         observer= new Observer<VisitPlanData>() {
             @Override
             public void onChanged(VisitPlanData visitPlanData) {
                 List<InspectionVisit> visits ;
                 int status ;
                 if(visitPlanData!=null){
                   visits= visitPlanData.getInspectionVisit() ;
                    for(InspectionVisit visit: visits){
                        VisitCard visitCard = new VisitCard();
                        visitCard.setVisitId(visit.getINSPECTVID());
                        visitCard.setArea(visit.getDIRECTORATENAME());
                        visitCard.setCompanyName(visit.getCONSTRUCTNAMEUSING());
                        visitCard.setStartDate(visit.getVISITDATE());
                        status= Integer.parseInt(visit.getINSPETVISITSTATUS());
                        visitCard.setStatus(status);
                    }//end foreach
                 }   //end if
                 adapter.setCards(cards);
                 toggleEmptyCards();
             }//end onChanged
         };

    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllVisitsBinding.inflate(inflater,container ,false);
        viewModel= new ViewModelProvider(this).get(VisitViewModel.class);
        viewModel.getVisitPlanData(//"831504");
                null);
        return binding.getRoot();
    }//end onCreateView


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.visitRecyclerView.setAdapter(adapter);
    }//end onViewCreated

    private void toggleEmptyCards(){
        if(cards.isEmpty()){
            binding.noVisits.setVisibility(View.VISIBLE);
            binding.visitRecyclerView.setVisibility(View.GONE);

        }//end if
        else{
            binding.visitRecyclerView.setVisibility(View.VISIBLE);
            binding.noVisits.setVisibility(View.GONE);

        }//end else
    }// end toggleEmptyCards
}//end Class