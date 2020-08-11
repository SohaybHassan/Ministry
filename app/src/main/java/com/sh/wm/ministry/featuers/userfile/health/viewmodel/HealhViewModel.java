package com.sh.wm.ministry.featuers.userfile.health.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.featuers.userfile.health.repository.HealhRepositoriy;


public class HealhViewModel extends AndroidViewModel {

    private HealhRepositoriy repositoriy;

    public HealhViewModel(@NonNull Application application) {
        super(application);
        repositoriy = HealhRepositoriy.getInstance(application);
    }

    public LiveData<UserHealthStatusModel> getUserWorkInfoLiveData() {
        return repositoriy.getUserHealthStatus();
    }
}