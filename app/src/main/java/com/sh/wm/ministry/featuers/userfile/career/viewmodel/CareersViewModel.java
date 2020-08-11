package com.sh.wm.ministry.featuers.userfile.career.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.career.repository.CareerRepository;


public class CareersViewModel extends AndroidViewModel {

    private CareerRepository repository;

    public CareersViewModel(@NonNull Application application) {
        super(application);
        repository = CareerRepository.getInstance(application);
    }

    public LiveData<UserCareerModel> getUserCareers(String userId) {
        return repository.getUserCareers(userId);
    }
}
