package com.sh.wm.ministry.featuers.userfile.languages.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class LanguagesViewModel extends AndroidViewModel {
    private DBRepository repository;

    public LanguagesViewModel(@NonNull Application application) {
        super(application);
        repository = DBRepository.getInstance(application);
    }

    public LiveData<List<Language>> getAllLanguages() {
        return repository.getAllLanguages();
    }

    // only to test the constants

    public LiveData<List<Constants>> getAllConstants(String constantId) {
        return repository.getAllConstants(constantId);
    }
//
//    public LiveData<List<JobTitle>> getMyConstants() {
//        return repository.getAllJobTitles();
//    }
}