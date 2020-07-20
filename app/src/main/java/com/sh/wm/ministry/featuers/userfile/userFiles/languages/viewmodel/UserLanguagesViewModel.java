package com.sh.wm.ministry.featuers.userfile.userFiles.languages.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.repository.LanguagesRepository;

public class UserLanguagesViewModel extends AndroidViewModel {
    private LanguagesRepository repository;

    public UserLanguagesViewModel(@NonNull Application application) {
        super(application);
        repository = LanguagesRepository.getInstance(application);
    }

    public LiveData<UserLanguagesModel> getUserLanguages() {
        return repository.getUserLanguages();
    }
}