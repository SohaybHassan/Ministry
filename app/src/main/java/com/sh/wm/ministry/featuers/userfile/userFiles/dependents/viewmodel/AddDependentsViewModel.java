package com.sh.wm.ministry.featuers.userfile.userFiles.dependents.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.dependents.repository.DependentsRepository;


public class AddDependentsViewModel extends AndroidViewModel {
    private DependentsRepository dependentsRepository;

    public AddDependentsViewModel(@NonNull Application application) {
        super(application);
        dependentsRepository = DependentsRepository.getInstance(application);
    }

    public LiveData<UserWorkerInsertModel> postUserWorker(String userSn, String dependentSn) {
        return dependentsRepository.postUserWorker(userSn, dependentSn);
    }
}
