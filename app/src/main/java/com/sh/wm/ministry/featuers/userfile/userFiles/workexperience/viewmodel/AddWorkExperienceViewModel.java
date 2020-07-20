package com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.repository.WorkExperienceRepository;

public class AddWorkExperienceViewModel extends AndroidViewModel {

    private WorkExperienceRepository repository;

    public AddWorkExperienceViewModel(@NonNull Application application) {
        super(application);
        repository = WorkExperienceRepository.getInstance(application);
    }

    //TODO: add methods
}
