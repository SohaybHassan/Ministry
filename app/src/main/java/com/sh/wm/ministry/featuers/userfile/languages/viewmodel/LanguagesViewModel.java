package com.sh.wm.ministry.featuers.userfile.languages.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.languages.model.Language;
import com.sh.wm.ministry.featuers.userfile.languages.repository.LanguagesRepository;

import java.util.List;

public class LanguagesViewModel extends AndroidViewModel {
    private LanguagesRepository repository;

    public LanguagesViewModel(@NonNull Application application) {
        super(application);
        repository = LanguagesRepository.getInstance(application);
    }

    public LiveData<List<Language>> getAllLanguages() {
        return repository.getAllLanguages();
    }
}