package com.sh.wm.ministry.featuers.home.repositiory;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private static String TAG = HomeRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<CertificateRequest> certificateRequestMutableLiveData;
    private static HomeRepository homeRepository;

    private HomeRepository(Application applicatio) {
        networkUtils = NetworkUtils.getInstance(true, applicatio);
        certificateRequestMutableLiveData = new MutableLiveData<>();
    }

    public static HomeRepository getInstance(Application application) {
        if (homeRepository == null) homeRepository = new HomeRepository(application);
        return homeRepository;
    }

    public LiveData<CertificateRequest> requestCertificate(String user_id) {


        Call<CertificateRequest> call = networkUtils.getApiInterface().requestCertificate(user_id);
        call.enqueue(new Callback<CertificateRequest>() {
            @Override
            public void onResponse(@NotNull Call<CertificateRequest> call, @NotNull Response<CertificateRequest> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: "+"jkhkjshgvdkvgaskldhglasdkhljkasdhcjkasdh");
                    certificateRequestMutableLiveData.setValue(response.body());
                } else {
                    certificateRequestMutableLiveData.setValue(null);
                    Log.d(TAG, "onResponse: "+"null data");
                }

            }

            @Override
            public void onFailure(@NotNull Call<CertificateRequest> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure:  sh my my" + t.getMessage());
                Log.d(TAG, "onResponse: "+"jkhkjshgvdkvgaskldhglasdkhljkasdhcjkasdh");
                certificateRequestMutableLiveData.setValue(null);
            }
        });
        return certificateRequestMutableLiveData;
    }
}
