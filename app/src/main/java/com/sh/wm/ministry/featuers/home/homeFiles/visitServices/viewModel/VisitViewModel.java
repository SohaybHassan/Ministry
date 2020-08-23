package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository.VisitRepository;

import java.util.List;

public class VisitViewModel extends AndroidViewModel {
      private VisitRepository repository;

      public VisitViewModel(@NonNull Application application){
          super(application);
          repository= VisitRepository.getInstance(application);
      }//end constructor


    public LiveData<List<Visit>> getAllVisits(String constructId){
          return  repository.getAllVisits(constructId);
    }
}//end class
