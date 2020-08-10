package com.sh.wm.ministry.featuers.home.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.home.repository.HomeRepository;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository repository;
    private MutableLiveData<String> userRole;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        userRole = new MutableLiveData<>();
        repository=HomeRepository.getInstance(application);

    }

    public LiveData<String> getText() {
        return userRole;
    }


    public LiveData<CertificateRequest> requestCertificate(String user_id){
        return repository.requestCertificate(user_id);
    }
}