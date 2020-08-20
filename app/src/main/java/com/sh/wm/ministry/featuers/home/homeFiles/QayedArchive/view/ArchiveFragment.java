package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentArchiveBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.Adapters.CardAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveCard;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.UserQayedArchive;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.viewModel.ArchiveViewModel;
import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.home.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArchiveFragment extends Fragment {
   private FragmentArchiveBinding binding ;
   private List<ArchiveCard> cards;
   private ArchiveViewModel viewModel;
    Observer<ArchiveModel> observer;
    CardAdapter adapter ;


    public ArchiveFragment() {
        // Required empty public constructor
    }

    public static ArchiveFragment newInstance(String param1, String param2) {
        ArchiveFragment fragment = new ArchiveFragment();

        return fragment;
    }//end newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cards=new ArrayList<>();
        adapter= new CardAdapter();
        observer = new Observer<ArchiveModel>() {
               @Override
               public void onChanged(ArchiveModel archiveModel) {
                 if(archiveModel!=null){
                     List<UserQayedArchive> archive= archiveModel.getUserQayedArchive();
                     for(UserQayedArchive request : archive){
                         ArchiveCard card = new ArchiveCard();
                         card.setQayedDate(request.getQAYEDDATE());
                         card.setWorkStatusDesc(request.getWORKSTATUSDESC());
                         card.setWorkStatusDescDesc(request.getWORKSTATUSDESCDESC());
                         card.setStatus(request.getSTATUS());
                         cards.add(card);
                     }//end for each
                     adapter.setCards(cards);
                     adapter.notifyDataSetChanged();
                 }//end if
                   toggleEmptyCards();
               }//end onChanged
           };

    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentArchiveBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(ArchiveViewModel.class);
                viewModel.archiveRequest("831504").observe(getViewLifecycleOwner(),observer);

        return binding.getRoot();
    }//end onCreateView

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.qayedArchive.setAdapter(adapter);

    }//END onViewCreated

    private void toggleEmptyCards(){
        if(cards.isEmpty()){
            binding.arcNoCards.setVisibility(View.VISIBLE);
            binding.qayedArchive.setVisibility(View.GONE);

        }//end if
        else{
            binding.qayedArchive.setVisibility(View.VISIBLE);
            binding.arcNoCards.setVisibility(View.GONE);

        }//end else
    }// end toggleEmptyCards
}//end class