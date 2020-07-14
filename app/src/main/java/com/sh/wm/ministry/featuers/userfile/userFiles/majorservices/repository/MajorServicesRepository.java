package com.sh.wm.ministry.featuers.userfile.userFiles.majorservices.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.sso.model.userrole.UserRoleModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MajorServicesRepository {

    private static final String TAG = MajorServicesRepository.class.getName();
    private static MajorServicesRepository mInstance;
    private NetworkUtils networkUtils;
    private MutableLiveData<UserRoleModel> userWorkInfoMutableLiveData;

    private MajorServicesRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkInfoMutableLiveData = new MutableLiveData<>();
    }

    public static MajorServicesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new MajorServicesRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserRoleModel> getUserWorkInfoLiveData() {
        networkUtils.getApiInterface().getUserWorkInfo().enqueue(new Callback<UserRoleModel>() {
            @Override
            public void onResponse(Call<UserRoleModel> call, Response<UserRoleModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkInfoMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkInfoMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserRoleModel> call, Throwable t) {
                userWorkInfoMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userWorkInfoMutableLiveData;
    }
}
