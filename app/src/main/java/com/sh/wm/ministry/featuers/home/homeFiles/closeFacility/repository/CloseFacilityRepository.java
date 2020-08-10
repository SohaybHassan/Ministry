package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CloseFacilityRepository {
    private static final String TAG = CloseFacilityRepository.class.getSimpleName();
    private NetworkUtils networkUtils;
    MutableLiveData<Construction> constructionMutableLiveData;
    MutableLiveData<PalLaw> palLawMutableLiveData;
    MutableLiveData<CloseFacilityModel> closeFacilityModelMutableLiveData;
    static CloseFacilityRepository mInstance;
    private Application application;

    public CloseFacilityRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData = new MutableLiveData<>();
        palLawMutableLiveData = new MutableLiveData<>();
        closeFacilityModelMutableLiveData = new MutableLiveData<>();
    }

    public static CloseFacilityRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new CloseFacilityRepository(application);
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
                        Log.d(TAG, "onResponse: sh " + construction.getCONSTRUCTNUM());
                        Log.d(TAG, "onResponse: sh " + response.body().toString());

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

    public LiveData<PalLaw> getPalLaw(String number) {
        networkUtils.getApiInterface().getPalLaw(number).enqueue(new Callback<PalLaw>() {
            @Override
            public void onResponse(@NotNull Call<PalLaw> call, @NotNull Response<PalLaw> response) {
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response.body().getPalLawDesc());
                    palLawMutableLiveData.setValue(response.body());
                } else {
                    Log.e(TAG, "onResponse:  no data");
                    palLawMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<PalLaw> call, @NotNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                palLawMutableLiveData.setValue(null);

            }
        });
        return palLawMutableLiveData;
    }

    public LiveData<CloseFacilityModel> postAllData(String Constraction_ID, String CloseDate, String close_reason, String insert_userid) {
        networkUtils.getApiInterface().postCloseFacility(Constraction_ID, CloseDate, close_reason, insert_userid).enqueue(new Callback<CloseFacilityModel>() {
            @Override
            public void onResponse(Call<CloseFacilityModel> call, Response<CloseFacilityModel> response) {
                Log.d(TAG, "onResponse token: " + SharedPreferneceHelper.getToken(application));
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body().getMessageText());
                    closeFacilityModelMutableLiveData.setValue(response.body());
                } else {
                    closeFacilityModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<CloseFacilityModel> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage());
                closeFacilityModelMutableLiveData.setValue(null);
            }
        });
        return closeFacilityModelMutableLiveData;
    }
}
