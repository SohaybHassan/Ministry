package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.view.AlarmFormFragment;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlarmFormRepository {

    private NetworkUtils networkUtils;
    private static AlarmFormRepository mInstance;
    private MutableLiveData<Construction> constructionMutableLiveData;
    private MutableLiveData<PalLaw> palLawMutableLiveData;
    private static final String TAG = AlarmFormRepository.class.getSimpleName();

    public AlarmFormRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData = new MutableLiveData<>();
        palLawMutableLiveData = new MutableLiveData<>();

    }

    public static AlarmFormRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new AlarmFormRepository(application);
        }
        return mInstance;
    }


    public LiveData<PalLaw> getPalLawByNum(String numberLaw) {
        networkUtils.getApiInterface().getPalLaw(numberLaw).enqueue(new Callback<PalLaw>() {
            @Override
            public void onResponse(Call<PalLaw> call, Response<PalLaw> response) {


                    if (response.isSuccessful()) {
                        Log.e(TAG, "onResponse: data is  " + response.body().getPalLawDesc());

                        palLawMutableLiveData.setValue(response.body());
                    } else {
                        Log.e(TAG, "onResponse:  null data heir");
                        palLawMutableLiveData.setValue(null);
                    }
            }
            @Override
            public void onFailure(Call<PalLaw> call, Throwable t) {
                Log.d(TAG, "onResponse:  "+t.getMessage());
                palLawMutableLiveData.setValue(null);
            }
        });
        return palLawMutableLiveData;
    }

    public LiveData<Construction> getConstructiondata(String num_construction) {
        Call<ConstructionGroup> call = networkUtils.getApiInterface().getDataConstruction(num_construction);
        call.enqueue(new Callback<ConstructionGroup>() {
            @Override
            public void onResponse(@NotNull Call<ConstructionGroup> call, @NotNull Response<ConstructionGroup> response) {
             //   if (response.body().getStatus() == 0) {
                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<Construction>() {
                        }.getType();
                        // assert response.body() != null;
                        Construction construction = gson.fromJson(gson.toJson(response.body().getConstruction()), type);
                        //  Log.d(TAG, "onResponse: sh " + construction.getCONSTRUCTNUM());
                        Log.d(TAG, "onResponse: sh " + response.body().toString());

                        constructionMutableLiveData.setValue(response.body().getConstruction());
                    } else {
                        Log.d(TAG, "onResponse: no data her");
                        constructionMutableLiveData.setValue(null);
                    }
//                } else {
//                    Log.d(TAG, "onResponse: null data her");
//                    constructionMutableLiveData.setValue(null);
//                }
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
