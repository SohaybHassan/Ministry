package com.sh.wm.ministry.featuers.userfile.trainingskills.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.featuers.userfile.trainingskills.repository.TrainingSkillsRepository;

public class TrainingSkillsViewModel extends AndroidViewModel {
    private TrainingSkillsRepository repository;

    public TrainingSkillsViewModel(@NonNull Application application) {
        super(application);
        repository = TrainingSkillsRepository.getInstance(application);
    }

    public LiveData<TrainingSkillsModel> getTrainingSkills() {
        return repository.getTrainingSkills();
    }
}