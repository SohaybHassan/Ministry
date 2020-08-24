package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.repository.WorkercompilationRepository;

public class WorkerCompilationFormTwoViewModel extends AndroidViewModel {

    WorkercompilationRepository workercompilationRepository;


    public WorkerCompilationFormTwoViewModel(@NonNull Application application) {
        super(application);
        workercompilationRepository = WorkercompilationRepository.getInstance(application);

    }

    public LiveData<ConstructByName> getConstruct(String number) {
        return workercompilationRepository.getConstruct(number);
    }

}