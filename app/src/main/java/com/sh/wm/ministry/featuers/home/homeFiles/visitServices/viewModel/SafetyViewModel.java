package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.SaftyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.repository.SafetyRepository;

import java.util.List;


public class SafetyViewModel extends AndroidViewModel {
    private SafetyRepository repository ;
    public SafetyViewModel(@NonNull Application application) {
        super(application);
        repository = SafetyRepository.getInstance(application);
    }

   public LiveData<List<SaftyQuestion>> getAllQuestions(){
       return repository.getAllQuestions();
    }

    public LiveData<List<SaftyQuestion>> getQuestionsByLawId(int id){
      return repository.getQuestionsByLawId(id);
    }
}
