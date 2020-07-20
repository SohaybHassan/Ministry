package com.sh.wm.ministry.featuers.home.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> userRole;

    public HomeViewModel() {
        userRole = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return userRole;
    }
}