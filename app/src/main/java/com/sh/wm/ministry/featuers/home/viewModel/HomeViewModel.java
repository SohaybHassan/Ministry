package com.sh.wm.ministry.featuers.home.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.home.repository.HomeRepository;

public class HomeViewModel extends ViewModel {
    private HomeRepository repository;
    private MutableLiveData<String> userRole;

    public HomeViewModel() {
        userRole = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return userRole;
    }


    public LiveData<CertificateRequest> requestCertificate(String user_id){
        return repository.requestCertificate(user_id);
    }
}