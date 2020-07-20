package com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationalStatusRepository {
    private static final String TAG = EducationalStatusRepository.class.getName();
    private static EducationalStatusRepository sInstance;
    private Application application;
    private MutableLiveData<EducationalStatusModel> educationlStatusModelMutableLiveData;
    private NetworkUtils networkUtils;

    private EducationalStatusRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);

    }

    public static EducationalStatusRepository getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new EducationalStatusRepository(application);
        }
        return sInstance;
    }

    public LiveData<EducationalStatusModel> getEducationlStatusModelLiveData() {
        educationlStatusModelMutableLiveData = new MutableLiveData<>();

        //for test 831504
        networkUtils.getApiInterface().getEducationlStatus(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<EducationalStatusModel>() {
            @Override
            public void onResponse(Call<EducationalStatusModel> call, Response<EducationalStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        educationlStatusModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    educationlStatusModelMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<EducationalStatusModel> call, Throwable t) {
                educationlStatusModelMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return educationlStatusModelMutableLiveData;
    }

    public LiveData<Object> postNewEducation() {
        return null;
    }
}
