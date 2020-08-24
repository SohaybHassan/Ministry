package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.VisitDao;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitPlanData;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitRepository {
    private static String TAG= VisitRepository.class.toString();
    private static   VisitRepository repository ;
    private NetworkUtils networkUtils ;
    private VisitDao visitDao;
    private VisitRepository(@NonNull Application application){
        networkUtils= NetworkUtils.getInstance(true,application);
        visitDao= DataBase.getInstance(application).visitDao();
    }//end Constructor

    public static VisitRepository getInstance(@NonNull Application application){
       if(repository==null) repository= new VisitRepository(application);
       return repository;
    }//end getInstance;


    public LiveData<List<Visit>> getAllVisits(String constructId) {
        //adding dummy card
//        for (int i =0 ; i<=5 ; i++){
//            Visit visitCard = new Visit("117"+i);
//            visitCard.setArea("غزة");
//            visitCard.setCompanyName("ماف");
//            visitCard.setStartDate("22/8/2020");
//            visitDao.insertVisit(visitCard);
//        }

       // visitDao.deleteAllVisits();
      updateVisitPlanData(constructId);
        return visitDao.getAllVisits();
    }

    public void updateVisitPlanData(String constructId) {
        Call<VisitPlanData> call= networkUtils.getApiInterface().getVisitPlanData(constructId,0,10);

        call.enqueue(new Callback<VisitPlanData>() {
            @Override
            public void onResponse(Call<VisitPlanData> call, Response<VisitPlanData> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: Success" +response.body().getInspectionVisit().size());
                      if( response.body().getInspectionVisit()!=null){
                          int status ;
                          for(InspectionVisit visit: response.body().getInspectionVisit()){
                            Visit visitCard = new Visit(visit.getINSPECTVID());
                            visitCard.setArea(visit.getDIRECTORATENAME());
                            visitCard.setCompanyName(visit.getCONSTRUCTNAMEUSING());
                            visitCard.setStartDate(visit.getVISITDATE());
                            status= Integer.parseInt(visit.getINSPETVISITSTATUS());
                            visitCard.setStatus(status);
                            visitDao.insertVisit(visitCard);
                        }//end foreach
                          System.out.println(visitDao.count());
                    }//end if

                }else{
                    Log.d(TAG, "onResponse: Failed");
                }
            }

            @Override
            public void onFailure(Call<VisitPlanData> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}//end class
