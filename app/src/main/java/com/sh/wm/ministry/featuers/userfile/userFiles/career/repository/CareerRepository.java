package com.sh.wm.ministry.featuers.userfile.userFiles.career.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.userFiles.career.model.UserCareerModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CareerRepository {


    private static CareerRepository mInstance;
    private final String TAG = CareerRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserCareerModel> userCareerModelMutableLiveData;

    private CareerRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userCareerModelMutableLiveData = new MutableLiveData<>();
    }

    public static CareerRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new CareerRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserCareerModel> getUserCareers(String userId) {
        networkUtils.getApiInterface().getUserCareers(userId).enqueue(new Callback<UserCareerModel>() {
            @Override
            public void onResponse(Call<UserCareerModel> call, Response<UserCareerModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userCareerModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userCareerModelMutableLiveData.setValue(null);
                    Log.d(TAG, "User Careers Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserCareerModel> call, Throwable t) {
                userCareerModelMutableLiveData.setValue(null);
                Log.e(TAG, "User Careers Empty Response!");
            }
        });
        return userCareerModelMutableLiveData;
    }
}
