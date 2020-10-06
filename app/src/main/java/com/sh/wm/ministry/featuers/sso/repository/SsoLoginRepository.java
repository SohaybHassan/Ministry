package com.sh.wm.ministry.featuers.sso.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.sh.wm.ministry.featuers.sso.model.SsoTokenModel;
import com.sh.wm.ministry.featuers.sso.model.UserInfoSsoModel;
import com.sh.wm.ministry.featuers.sso.model.loginmodel.LoginModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SsoLoginRepository {

    private static final String TAG = SsoLoginRepository.class.getName();
    private static SsoLoginRepository mInstance;
    private NetworkUtils networkUtils;
    private MutableLiveData<SsoTokenModel> tokenBodyMutableLiveData;
    private MutableLiveData<UserInfoSsoModel> verifyTokenMutabliveData;
    private MutableLiveData<LoginModel> LogInMutabliveData;

    private SsoLoginRepository(Context context) {
        networkUtils = NetworkUtils.getInstance(true, context);
        tokenBodyMutableLiveData = new MutableLiveData<>();
    }

    public static SsoLoginRepository getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SsoLoginRepository(context);
        }
        return mInstance;
    }

    public LiveData<SsoTokenModel> getTokenBodyLiveData(Map<String, String> params) {
        String id = params.get("client_id");
        String secret = params.get("client_secret");
        String code = params.get("code");

        networkUtils.getSsoApiInterface().getSsoAccessToken(id, secret, code).enqueue(new Callback<SsoTokenModel>() {
            @Override
            public void onResponse(Call<SsoTokenModel> call, Response<SsoTokenModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        tokenBodyMutableLiveData.setValue(response.body());
                        Log.e(TAG, "onResponse: ok");
                    }
                } else {
                    tokenBodyMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<SsoTokenModel> call, Throwable t) {
                tokenBodyMutableLiveData.setValue(null);
                t.printStackTrace();
            }
        });

        return tokenBodyMutableLiveData;
    }


    public LiveData<UserInfoSsoModel> verifyToken(String token) {

        verifyTokenMutabliveData = new MutableLiveData<>();

        networkUtils.getSsoApiInterface().verifyToken(token).enqueue(new Callback<UserInfoSsoModel>() {
            @Override
            public void onResponse(Call<UserInfoSsoModel> call, Response<UserInfoSsoModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        verifyTokenMutabliveData.setValue(response.body());
                        Log.e(TAG, "onResponse: ok");
                    }
                } else {
                    verifyTokenMutabliveData.setValue(null);
                    Log.e(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<UserInfoSsoModel> call, Throwable t) {
                verifyTokenMutabliveData.setValue(null);
                t.printStackTrace();
            }
        });

        return verifyTokenMutabliveData;
    }

    public LiveData<LoginModel> LogIn(String userId) {
        LogInMutabliveData = new MutableLiveData<>();
        networkUtils.getApiInterface().LogIn(userId).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        LogInMutabliveData.setValue(response.body());
                        Log.e(TAG, "onResponse: ok");
                        Log.d(TAG, "onResponse: Token = " + response.body().getAuthToken());
                    }
                } else {
                    LogInMutabliveData.setValue(null);
                    Log.e(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                LogInMutabliveData.setValue(null);
                t.printStackTrace();
            }
        });
        return LogInMutabliveData;
    }
}
