package com.sh.wm.ministry.featuers.userfile.practicalstatus.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PracticalStatusRepository {
    private static PracticalStatusRepository mInstance;
    private final String TAG = PracticalStatusRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<PracticalStatusModel> practicalStatusModellMutableLiveData;

    public PracticalStatusRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        practicalStatusModellMutableLiveData = new MutableLiveData<>();
    }

    public static PracticalStatusRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new PracticalStatusRepository(application);
        }
        return mInstance;
    }


    public LiveData<PracticalStatusModel> getUserPracticalStatus() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserPracticalStatus("831504").enqueue(new Callback<PracticalStatusModel>() {
            @Override
            public void onResponse(Call<PracticalStatusModel> call, Response<PracticalStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        practicalStatusModellMutableLiveData.setValue(response.body());
                    }
                } else {
                    practicalStatusModellMutableLiveData.setValue(null);
                    Log.d(TAG, "User Practical Status Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<PracticalStatusModel> call, Throwable t) {
                practicalStatusModellMutableLiveData.setValue(null);
                Log.e(TAG, "User Practical Status request has failed!");
            }
        });
        return practicalStatusModellMutableLiveData;
    }
}
