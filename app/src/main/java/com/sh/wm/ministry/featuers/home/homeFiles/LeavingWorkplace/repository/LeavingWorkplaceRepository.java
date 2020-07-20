package com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.repository;

import android.app.Application;
import android.media.AsyncPlayer;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeavingWorkplaceRepository {

    private MutableLiveData<Construction> constructionMutableLiveData;
    private NetworkUtils networkUtils;
    private Application application;
    private static LeavingWorkplaceRepository mInstance;
    public static final String TAG = LeavingWorkplaceRepository.class.getSimpleName();

    public LeavingWorkplaceRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData = new MutableLiveData<>();


    }

    public static LeavingWorkplaceRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new LeavingWorkplaceRepository(application);
        }
        return mInstance;
    }

    public LiveData<Construction> getConstructiondata(String num_construction) {
        Call<ConstructionGroup> call = networkUtils.getApiInterface().getDataConstruction(num_construction);
        call.enqueue(new Callback<ConstructionGroup>() {
            @Override
            public void onResponse(@NotNull Call<ConstructionGroup> call, @NotNull Response<ConstructionGroup> response) {

                if (response.body().getStatus() != 1) {
                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<Construction>() {
                        }.getType();
                        // assert response.body() != null;
                        Construction construction = gson.fromJson(gson.toJson(response.body().getConstruction()), type);
                        Log.d(TAG, "onResponse: hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh " + construction.getCONSTRUCTNUM());
                        Log.d(TAG, "onResponse: hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh " + response.body().toString());

                        constructionMutableLiveData.setValue(response.body().getConstruction());
                    } else {
                        Log.d(TAG, "onResponse: no data her");
                        constructionMutableLiveData.setValue(null);
                    }
                } else {
                    Log.d(TAG, "onResponse: null data her");
                    constructionMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ConstructionGroup> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructionMutableLiveData.setValue(null);
            }
        });
        return constructionMutableLiveData;

    }


}
