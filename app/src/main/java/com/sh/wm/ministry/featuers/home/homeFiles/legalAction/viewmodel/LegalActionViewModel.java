package com.sh.wm.ministry.featuers.home.homeFiles.legalAction.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.legalAction.repository.LegalActionRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

public class LegalActionViewModel extends AndroidViewModel {

    LegalActionRepository legalActionRepository;

    public LegalActionViewModel(@NonNull Application application) {
        super(application);
        legalActionRepository = LegalActionRepository.getInstance(application);
    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return legalActionRepository.getConstructiondata(num_construction);
    }
}
