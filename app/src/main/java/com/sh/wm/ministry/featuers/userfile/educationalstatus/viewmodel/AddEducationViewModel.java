package com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.educationalstatus.repository.EducationalStatusRepository;


public class AddEducationViewModel extends AndroidViewModel {

    private EducationalStatusRepository repository;

    public AddEducationViewModel(@NonNull Application application) {
        super(application);
        repository = EducationalStatusRepository.getInstance(application);
    }

    public LiveData<Object> postNewEducation() {
        return repository.postNewEducation();
    }
}
