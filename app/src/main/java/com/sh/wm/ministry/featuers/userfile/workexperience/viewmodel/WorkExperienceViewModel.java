package com.sh.wm.ministry.featuers.userfile.workexperience.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperienceModel;
import com.sh.wm.ministry.featuers.userfile.workexperience.repository.WorkExperienceRepository;

public class WorkExperienceViewModel extends AndroidViewModel {
    private WorkExperienceRepository repository;

    public WorkExperienceViewModel(@NonNull Application application) {
        super(application);
        repository = WorkExperienceRepository.getInstance(application);
    }

    public LiveData<UserWorkExperienceModel> getUserWorkExperiences(String userId) {
        return repository.getUserWorkExperiences(userId);
    }
}
