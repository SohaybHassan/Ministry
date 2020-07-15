package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.repository.LeavingWorkplaceRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.view.LeavingAWorkplaceFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

public class LeavingWorkPlaceViewModel extends AndroidViewModel {

    private LeavingWorkplaceRepository leavingWorkplaceRepository;
    public LeavingWorkPlaceViewModel(@NonNull Application application) {
        super(application);
        leavingWorkplaceRepository=LeavingWorkplaceRepository.getInstance(application);
    }



    public LiveData<Construction> getConstructionData(String num_construction) {
        return leavingWorkplaceRepository.getConstructiondata(num_construction);
    }
}
