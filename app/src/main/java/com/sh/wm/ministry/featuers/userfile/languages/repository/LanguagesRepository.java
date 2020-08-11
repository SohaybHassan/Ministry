package com.sh.wm.ministry.featuers.userfile.languages.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.userfile.languages.model.AllLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.Language;
import com.sh.wm.ministry.featuers.userfile.languages.database.LanguagesDao;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LanguagesRepository {

    private static LanguagesRepository mInstance;
    private final String TAG = LanguagesRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserLanguagesModel> userLanguagesModelMutableLiveData;
    private LanguagesDao languagesDao;

    private LanguagesRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userLanguagesModelMutableLiveData = new MutableLiveData<>();
        languagesDao = DataBase.getInstance(application).languagesDao();
    }

    public static LanguagesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new LanguagesRepository(application);
        }
        return mInstance;
    }

    public LiveData<List<Language>> getAllLanguages() {
        updateLanguages();
        return languagesDao.getAllLanguages();
    }

    //get all languages available for user
    public void updateLanguages() {
        networkUtils.getApiInterface().getAllLanguages().enqueue(new Callback<AllLanguagesModel>() {
            @Override
            public void onResponse(Call<AllLanguagesModel> call, Response<AllLanguagesModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "All Languages Response Received!");
                        Log.d(TAG, "response size" + response.body().getLanguages().size() + " db size " + languagesDao.getDataCount());
                        if (response.body().getLanguages().size() != languagesDao.getDataCount()) {

                            List<Language> languages = response.body().getLanguages();
                            for (Language language : languages) {
                                languagesDao.addLanguage(language);
                                Log.d(TAG, language.getLANGUAGEARNAME() + "");
                                Log.d(TAG, languagesDao.getDataCount() + "");

                            }
                        }
                    }
                } else {
                    Log.d(TAG, "All Languages Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<AllLanguagesModel> call, Throwable t) {
                Log.e(TAG, "All Languages request has failed!");
            }
        });
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
