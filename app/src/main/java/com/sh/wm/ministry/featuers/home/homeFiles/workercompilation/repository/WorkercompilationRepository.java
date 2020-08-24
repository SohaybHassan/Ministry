package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkercompilationRepository {

    private NetworkUtils networkUtils;
    private static final String TAG = WorkercompilationRepository.class.getSimpleName();
    MutableLiveData<ConstructByName> constructByNameMutableLiveData;
    private static WorkercompilationRepository mInstance;


    public WorkercompilationRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        constructByNameMutableLiveData = new MutableLiveData<>();
    }

    public static WorkercompilationRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new WorkercompilationRepository(application);
        }
        return mInstance;
    }


    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body());
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse: " + " no data");
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }
}
