package com.sh.wm.ministry.featuers.userfile.userFiles.trainingskills.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingSkillsRepository {

    private static TrainingSkillsRepository mInstance;
    private final String TAG = TrainingSkillsRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<TrainingSkillsModel> mutableLiveData;

    public TrainingSkillsRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        mutableLiveData = new MutableLiveData<>();
    }

    public static TrainingSkillsRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new TrainingSkillsRepository(application);
        }
        return mInstance;
    }
    public LiveData<TrainingSkillsModel> getTrainingSkills() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getTrainingSkills("831504").enqueue(new Callback<TrainingSkillsModel>() {
            @Override
            public void onResponse(Call<TrainingSkillsModel> call, Response<TrainingSkillsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        mutableLiveData.setValue(response.body());
                    }
                } else {
                    mutableLiveData.setValue(null);
                    Log.d(TAG, "Training Programs Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<TrainingSkillsModel> call, Throwable t) {
                mutableLiveData.setValue(null);
                Log.e(TAG, "Training Programs request has failed!");
            }
        });
        return mutableLiveData;
    }
}
