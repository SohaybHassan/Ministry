package com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.repository.EducationalStatusRepository;


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