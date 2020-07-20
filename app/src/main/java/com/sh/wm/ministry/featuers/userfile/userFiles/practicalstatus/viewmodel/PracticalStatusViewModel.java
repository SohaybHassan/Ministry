package com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.repository.PracticalStatusRepository;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.PracticalStatusModel;

public class PracticalStatusViewModel extends AndroidViewModel {
    private PracticalStatusRepository repository;

    public PracticalStatusViewModel(@NonNull Application application) {
        super(application);
        repository=PracticalStatusRepository.getInstance(application);
    }

    public LiveData<PracticalStatusModel> getUserPracticalStatus() {
        return repository.getUserPracticalStatus();
    }
}