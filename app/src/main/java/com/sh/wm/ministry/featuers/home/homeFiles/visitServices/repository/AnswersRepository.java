package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository;

import android.app.Application;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database.AnswersDao;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

public class AnswersRepository {
    public static String TAG= AnswersRepository.class.getName();
    private static AnswersRepository repository;
    private NetworkUtils networkUtils ;
    private AnswersDao dao ;

    private AnswersRepository(Application application){
        networkUtils= NetworkUtils.getInstance(true , application);
        dao= DataBase.getInstance(application).answersDao();
    }//end constructor

    public static AnswersRepository getInstance(Application application){
        if(repository==null) repository =new AnswersRepository(application);
        return repository ;
    }// end getInstance




}//end class
