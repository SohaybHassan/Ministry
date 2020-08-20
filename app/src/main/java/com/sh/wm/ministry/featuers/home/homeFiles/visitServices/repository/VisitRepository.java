package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitPlanData;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitRepository {
    private static String TAG= VisitRepository.class.toString();
    private static   VisitRepository repository ;
    private NetworkUtils networkUtils ;
    MutableLiveData<VisitPlanData> data;
    private VisitRepository(@NonNull Application application){
        networkUtils= NetworkUtils.getInstance(true,application);
        data= new MutableLiveData<>();
    }//end Constructor

    public static VisitRepository getInstance(@NonNull Application application){
       if(repository==null) repository= new VisitRepository(application);
       return repository;
    }//end getInstance;

    public MutableLiveData<VisitPlanData> getVisitPlanData(String constructId) {
        Call<VisitPlanData> call= networkUtils.getApiInterface().getVisitPlanData(constructId);

        call.enqueue(new Callback<VisitPlanData>() {
            @Override
            public void onResponse(Call<VisitPlanData> call, Response<VisitPlanData> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success");
                    data.setValue(response.body());
                }else{
                    Log.d(TAG, "onResponse: Failed");
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<VisitPlanData> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                data.setValue(null);
            }
        });
        return data ;
    }
}//end class
