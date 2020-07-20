package com.sh.wm.ministry.featuers.home.homeFiles.newWorkPlace.repository;

import android.app.Application;
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

public class NewWorkPlaceRepository {
    private static NewWorkPlaceRepository mInstance;
    private NetworkUtils networkUtils;
    private Application application;
    private MutableLiveData<Construction> constructionMutableLiveData;
    public static final String TAG = NewWorkPlaceRepository.class.getSimpleName();



    public NewWorkPlaceRepository(Application application) {

        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData=new MutableLiveData<>();
    }

    public static NewWorkPlaceRepository getmInstance(Application application){
        if (mInstance==null){
            mInstance=new NewWorkPlaceRepository(application);
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
                        //           Log.d(TAG, "onResponse: sh " + construction.getCONSTRUCTNUM());
                        Log.d(TAG, "onResponse: sh " + response.body().toString());

                        constructionMutableLiveData.setValue(response.body().getConstruction());
                    } else {
                        Log.d(TAG, "onResponse: no data her");
                        constructionMutableLiveData.setValue(null);
                    }
                }else{
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
