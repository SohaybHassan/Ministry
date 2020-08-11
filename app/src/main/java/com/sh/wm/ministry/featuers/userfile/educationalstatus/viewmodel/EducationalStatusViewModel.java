package com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.repository.EducationalStatusRepository;


public class EducationalStatusViewModel extends AndroidViewModel {

    private EducationalStatusRepository repository;

    public EducationalStatusViewModel(@NonNull Application application) {
        super(application);
        repository = EducationalStatusRepository.getInstance(application);
    }

    public LiveData<EducationalStatusModel> getUserDependents() {
        return repository.getEducationlStatusModelLiveData();
    }
}