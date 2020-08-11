package com.sh.wm.ministry.featuers.userfile.dependents.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.repository.DependentsRepository;


public class DependentsViewModel extends AndroidViewModel {

    private DependentsRepository dependentsRepository;

    public DependentsViewModel(@NonNull Application application) {
        super(application);
        dependentsRepository = DependentsRepository.getInstance(application);
    }

    public LiveData<UserDependentsModel> getUserDependents() {
        return dependentsRepository.getUserDependentsModel();
    }
}