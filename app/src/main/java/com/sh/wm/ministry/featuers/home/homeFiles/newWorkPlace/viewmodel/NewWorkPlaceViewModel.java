package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.repository.NewWorkPlaceRepository;

public class NewWorkPlaceViewModel extends AndroidViewModel {

    NewWorkPlaceRepository newWorkPlaceRepository;

    public NewWorkPlaceViewModel(@NonNull Application application) {
        super(application);
        newWorkPlaceRepository=NewWorkPlaceRepository.getmInstance(application);
    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return newWorkPlaceRepository.getConstructiondata(num_construction);
    }
}
