package com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.model.UserWorkExperienceModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkExperienceRepository {

    private static WorkExperienceRepository mInstance;
    private final String TAG = WorkExperienceRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserWorkExperienceModel> userWorkExperienceModelMutableLiveData;

    private WorkExperienceRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkExperienceModelMutableLiveData = new MutableLiveData<>();
    }

    public static WorkExperienceRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new WorkExperienceRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserWorkExperienceModel> getUserWorkExperiences(String userId) {
        networkUtils.getApiInterface().getUserWorkExperiences(userId).enqueue(new Callback<UserWorkExperienceModel>() {
            @Override
            public void onResponse(Call<UserWorkExperienceModel> call, Response<UserWorkExperienceModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkExperienceModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkExperienceModelMutableLiveData.setValue(null);
                    Log.d(TAG, "User Work Experience Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserWorkExperienceModel> call, Throwable t) {
                userWorkExperienceModelMutableLiveData.setValue(null);
                Log.e(TAG, "User Work Experience Empty Response!");
            }
        });
        return userWorkExperienceModelMutableLiveData;
    }
}
