package com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.sso.model.userrole.UserRoleModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.repository.MajorServicesRepository;


public class MajorServicesViewModel extends AndroidViewModel {

    private MajorServicesRepository majorServicesRepository;

    public MajorServicesViewModel(@NonNull Application application) {
        super(application);
        majorServicesRepository = MajorServicesRepository.getInstance(application);
    }

    public LiveData<UserRoleModel> getUserWorkInfoLiveData() {
        return majorServicesRepository.getUserWorkInfoLiveData();
    }
}