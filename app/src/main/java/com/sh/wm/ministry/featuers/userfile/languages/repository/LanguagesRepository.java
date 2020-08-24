package com.sh.wm.ministry.featuers.userfile.languages.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LanguagesRepository {

    private static LanguagesRepository mInstance;
    private final String TAG = LanguagesRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserLanguagesModel> userLanguagesModelMutableLiveData;

    private LanguagesRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userLanguagesModelMutableLiveData = new MutableLiveData<>();
    }

    public static LanguagesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new LanguagesRepository(application);
        }
        return mInstance;
    }

    //get user languages
    public LiveData<UserLanguagesModel> getUserLanguages() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserLanguages("831504").enqueue(new Callback<UserLanguagesModel>() {
            @Override
            public void onResponse(Call<UserLanguagesModel> call, Response<UserLanguagesModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userLanguagesModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userLanguagesModelMutableLiveData.setValue(null);
                    Log.d(TAG, "User Languages Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserLanguagesModel> call, Throwable t) {
                userLanguagesModelMutableLiveData.setValue(null);
                Log.e(TAG, "User Languages request has failed!");
            }
        });
        return userLanguagesModelMutableLiveData;
    }
}
