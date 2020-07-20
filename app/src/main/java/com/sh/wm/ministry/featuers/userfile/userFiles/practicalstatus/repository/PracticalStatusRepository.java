package com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.database.WorkStatusDao;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.WorkStatus;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.WorkStatusModel;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PracticalStatusRepository {
    private static PracticalStatusRepository mInstance;
    private final String TAG = PracticalStatusRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<PracticalStatusModel> practicalStatusModellMutableLiveData;
    private WorkStatusDao workStatusDao;

    public PracticalStatusRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        practicalStatusModellMutableLiveData = new MutableLiveData<>();
        workStatusDao = DataBase.getInstance(application).workStatusDao();
    }

    public static PracticalStatusRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new PracticalStatusRepository(application);
        }
        return mInstance;
    }

    public LiveData<List<WorkStatus>> getAllWorkStatuses() {
        updateWorkStatus();
        return workStatusDao.getAllWorkStatuses();
    }

    //get all languages available for user
    public void updateWorkStatus() {
        networkUtils.getApiInterface().getWorkStatus().enqueue(new Callback<WorkStatusModel>() {
            @Override
            public void onResponse(Call<WorkStatusModel> call, Response<WorkStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "All Work Statuses Response Received!");
                        Log.d(TAG, "response size" + response.body().getWorkStatus().size() + " db size " + workStatusDao.getDataCount());
                        if (response.body().getWorkStatus().size() != workStatusDao.getDataCount()) {

                            List<WorkStatus> workStatuses = response.body().getWorkStatus();
                            for (WorkStatus workStatus : workStatuses) {
                                workStatusDao.addWorkStatus(workStatus);
                                Log.d(TAG, workStatus.getWORKSTATUSNAME() + "");
                                Log.d(TAG, workStatusDao.getDataCount() + "");

                            }
                        }
                    }
                } else {
                    Log.d(TAG, "All Work Statuses Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<WorkStatusModel> call, Throwable t) {
                Log.e(TAG, "All Work Statuses request has failed!");
            }
        });
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
