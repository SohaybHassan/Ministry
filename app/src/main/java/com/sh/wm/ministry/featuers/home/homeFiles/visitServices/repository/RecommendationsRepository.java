package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.RecommendationsDao;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

public class RecommendationsRepository {
    public static String TAG= RecommendationsRepository.class.getName();
    private static RecommendationsRepository repository;
    private NetworkUtils networkUtils ;
    private RecommendationsDao dao ;

    private RecommendationsRepository(Application application){
        networkUtils= NetworkUtils.getInstance(true , application);
        dao= DataBase.getInstance(application).recommendationsDao();
    }//end constructor

    public static RecommendationsRepository getInstance(Application application){
        if(repository==null) repository =new RecommendationsRepository(application);
        return repository ;
    }// end getInstance

}//end class
