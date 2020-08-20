package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitPlanData;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository.VisitRepository;

public class VisitViewModel extends AndroidViewModel {
      private VisitRepository repository;

      public VisitViewModel(@NonNull Application application){
          super(application);
          repository= VisitRepository.getInstance(application);
      }//end constructor


    public MutableLiveData<VisitPlanData> getVisitPlanData( String constructId){
          return  repository.getVisitPlanData(constructId);
    }
}//end class
