package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.ReVisitResultDao;

import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

public class ReVisitRepository {
    public static String TAG= ReVisitRepository.class.getName();
    private static ReVisitRepository repository;
    private NetworkUtils networkUtils ;
    private ReVisitResultDao dao ;

    private ReVisitRepository(Application application){
        networkUtils= NetworkUtils.getInstance(true , application);
        dao= DataBase.getInstance(application).reVisitResultDao();
    }//end constructor

    public static ReVisitRepository getInstance(Application application){
        if(repository==null) repository =new ReVisitRepository(application);
        return repository ;
    }// end getInstance
}//end class
