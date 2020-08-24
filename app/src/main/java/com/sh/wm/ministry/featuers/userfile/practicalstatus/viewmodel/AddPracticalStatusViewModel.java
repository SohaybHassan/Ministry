package com.sh.wm.ministry.featuers.userfile.practicalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.practicalstatus.repository.PracticalStatusRepository;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class AddPracticalStatusViewModel extends AndroidViewModel {
    private DBRepository repository;

    public AddPracticalStatusViewModel(@NonNull Application application) {
        super(application);
        repository = DBRepository.getInstance(application);
    }

    public LiveData<List<WorkStatus>> getAllWorkStatuses() {
        return repository.getAllWorkStatuses();
    }
}