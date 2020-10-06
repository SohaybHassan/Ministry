package com.sh.wm.ministry.featuers.sso.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.sh.wm.ministry.featuers.sso.model.SsoTokenModel;
import com.sh.wm.ministry.featuers.sso.model.UserInfoSsoModel;
import com.sh.wm.ministry.featuers.sso.model.loginmodel.LoginModel;
import com.sh.wm.ministry.featuers.sso.repository.SsoLoginRepository;

import java.util.Map;


public class SsoLoginViewModel extends AndroidViewModel {

    private SsoLoginRepository ssoLoginRepository;

    public SsoLoginViewModel(Application application) {
        super(application);
        ssoLoginRepository = SsoLoginRepository.getInstance(application);
    }

    public LiveData<SsoTokenModel> getTokenBodyLiveData(Map<String, String> params) {
        return ssoLoginRepository.getTokenBodyLiveData(params);
    }


    public LiveData<UserInfoSsoModel> verifyToken(String accessToken) {
        return ssoLoginRepository.verifyToken(accessToken);

    }

    public LiveData<LoginModel> LogIn(String userId) {
        return ssoLoginRepository.LogIn(userId);
    }

}
