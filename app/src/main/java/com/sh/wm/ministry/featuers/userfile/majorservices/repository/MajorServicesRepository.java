package com.sh.wm.ministry.featuers.userfile.majorservices.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MajorServicesRepository {

    private static final String TAG = MajorServicesRepository.class.getName();
    private static MajorServicesRepository mInstance;
    private NetworkUtils networkUtils;
    private MutableLiveData<UserInfoModel> userInfoMutableLiveData;

    private MajorServicesRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userInfoMutableLiveData = new MutableLiveData<>();
    }

    public static MajorServicesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new MajorServicesRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserInfoModel> getUserInfo() {
        networkUtils.getApiInterface().getUserInfo().enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userInfoMutableLiveData.setValue(response.body());
                    }
                } else {
                    userInfoMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {
                userInfoMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userInfoMutableLiveData;
    }
}
