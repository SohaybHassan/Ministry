package com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.repository.AddressContactRepository;


public class AddressAndContactViewModel extends AndroidViewModel {

    private AddressContactRepository repository;

    public AddressAndContactViewModel(@NonNull Application application) {
        super(application);
        repository = AddressContactRepository.getInstance(application);
    }


    public LiveData<UserWorkContactModel> userWorkContactLiveData(String userId) {
        return repository.getUserWorkContact(userId);
    }
}