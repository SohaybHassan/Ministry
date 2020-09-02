package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.VisitResultDao;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

public class VisitResultRepository {
    public static String TAG= VisitResultRepository.class.getName();
    private static VisitResultRepository repository;
    private NetworkUtils networkUtils ;
    private VisitResultDao dao ;

    private VisitResultRepository(Application application){
        networkUtils= NetworkUtils.getInstance(true , application);
        dao= DataBase.getInstance(application).visitResultDao();
    }//end constructor

    public static VisitResultRepository getInstance(Application application){
        if(repository==null) repository =new VisitResultRepository(application);
        return repository ;
    }// end getInstance

}//end Class
