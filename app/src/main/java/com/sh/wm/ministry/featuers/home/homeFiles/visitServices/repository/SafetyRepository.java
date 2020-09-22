package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.SafetyDao;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Safety;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.SaftyQuestion;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SafetyRepository {
    public static String TAG = SafetyRepository.class.getName();
    private static SafetyRepository repository;
    private NetworkUtils networkUtils;
    private SafetyDao dao;

    private SafetyRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        dao = DataBase.getInstance(application).safetyDao();
    }//end constructor

    public static SafetyRepository getInstance(Application application) {
        if (repository == null) repository = new SafetyRepository(application);
        return repository;
    }// end getInstance

    public LiveData<List<SaftyQuestion>> getAllQuestions() {
        return dao.getAllQuestions();
    }//getAllQuestions

    public LiveData<List<SaftyQuestion>> getQuestionsByLawId(int id) {
        update(id);
        return dao.getQuestionsBySubId(id);
    }//getQuestionsByLawId

    private void update(int id) {
        String idSt = id+"";
        Call<Safety> call = networkUtils.getApiInterface().getSaftyQuestionsBySubjectId(idSt);
        call.enqueue(new Callback<Safety>() {
            @Override
            public void onResponse(Call<Safety> call, Response<Safety> response) {
                if (response.body() != null) {
                    Log.d(TAG, "onResponse: NOT_NULL");
                    if(response.body().getSaftyQuestions()!= null)
                        for (SaftyQuestion card : response.body().getSaftyQuestions()) {
                        SaftyQuestion add = new SaftyQuestion();
                        add.setPalLawArticalCode(card.getPalLawArticalCode());
                        add.setPalLawArticalDesc(card.getPalLawArticalDesc());
                        add.setPalLawArticalNum(card.getPalLawArticalNum());
                        add.setPalLawSubjectID(id);
                        dao.insertSaftyQuestion(add);
                    }//end for
                }//end if
                Log.d(TAG, "onResponse: NULL");

            }

            @Override
            public void onFailure(Call<Safety> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
    }//update
}//class
