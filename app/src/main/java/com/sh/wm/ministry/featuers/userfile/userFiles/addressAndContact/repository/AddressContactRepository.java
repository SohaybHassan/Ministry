package com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressContactRepository {

    private static AddressContactRepository mInstance;
    private final String TAG = AddressContactRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserWorkContactModel> userWorkContactMutableLiveData;

    private AddressContactRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkContactMutableLiveData = new MutableLiveData<>();
    }

    public static AddressContactRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new AddressContactRepository(application);
        }
        return mInstance;
    }

    public LiveData<UserWorkContactModel> getUserWorkContact(String userId) {
        networkUtils.getApiInterface().getUserWorkContact(userId).enqueue(new Callback<UserWorkContactModel>() {
            @Override
            public void onResponse(Call<UserWorkContactModel> call, Response<UserWorkContactModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkContactMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkContactMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserWorkContactModel> call, Throwable t) {
                userWorkContactMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return userWorkContactMutableLiveData;
    }
}
