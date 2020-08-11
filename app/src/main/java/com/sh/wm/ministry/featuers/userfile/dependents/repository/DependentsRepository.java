package com.sh.wm.ministry.featuers.userfile.dependents.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DependentsRepository {


    private static final String TAG = DependentsRepository.class.getName();
    private static DependentsRepository sInstance;
    private Application application;
    private MutableLiveData<UserDependentsModel> userDependentsModelMutableLiveData;
    private MutableLiveData<UserWorkerInsertModel> userWorkerInsertModelMutableLiveData;
    private NetworkUtils networkUtils;

    private DependentsRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);

    }

    public static DependentsRepository getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new DependentsRepository(application);
        }
        return sInstance;
    }


    public LiveData<UserDependentsModel> getUserDependentsModel() {
        userDependentsModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().getUserDependents(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserDependentsModel>() {
            @Override
            public void onResponse(Call<UserDependentsModel> call, Response<UserDependentsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userDependentsModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userDependentsModelMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserDependentsModel> call, Throwable t) {
                userDependentsModelMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userDependentsModelMutableLiveData;
    }

    public LiveData<UserWorkerInsertModel> postUserWorker(String userSn, String dependentSn) {
        userWorkerInsertModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().setNewDependents(userSn, dependentSn).enqueue(new Callback<UserWorkerInsertModel>() {
            @Override
            public void onResponse(Call<UserWorkerInsertModel> call, Response<UserWorkerInsertModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkerInsertModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkerInsertModelMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserWorkerInsertModel> call, Throwable t) {
                userWorkerInsertModelMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userWorkerInsertModelMutableLiveData;
    }
}
