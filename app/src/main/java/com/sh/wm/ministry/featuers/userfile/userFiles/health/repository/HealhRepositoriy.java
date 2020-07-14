package com.sh.wm.ministry.featuers.userfile.userFiles.health.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.userFiles.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealhRepositoriy {
    private static final String TAG = HealhRepositoriy.class.getName();
    private static HealhRepositoriy mInstance;
    private NetworkUtils networkUtils;
    private Application application;
    private MutableLiveData<UserHealthStatusModel> userWorkInfoMutableLiveData;

    private HealhRepositoriy(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkInfoMutableLiveData = new MutableLiveData<>();
    }

    public static HealhRepositoriy getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new HealhRepositoriy(application);
        }
        return mInstance;
    }

    public LiveData<UserHealthStatusModel> getUserHealthStatus() {
        networkUtils.getApiInterface().getUserHealthStauts(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserHealthStatusModel>() {
            @Override
            public void onResponse(Call<UserHealthStatusModel> call, Response<UserHealthStatusModel> response) {
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
            public void onFailure(Call<UserHealthStatusModel> call, Throwable t) {
                userWorkInfoMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userWorkInfoMutableLiveData;
    }
}
