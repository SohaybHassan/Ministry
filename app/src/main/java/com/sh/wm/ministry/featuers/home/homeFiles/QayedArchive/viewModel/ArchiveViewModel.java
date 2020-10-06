package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.Repository.ArchiveRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;

public class ArchiveViewModel extends AndroidViewModel {
    private ArchiveRepository repository;

    public ArchiveViewModel(@NonNull Application application) {
        super(application);
        repository=ArchiveRepository.getInstance(application);

    }//end constructor



    public LiveData<ArchiveModel> archiveRequest(String user_id){
        return repository.archiveRequest(user_id);
    }//end archiveRequest
}//END CLASS