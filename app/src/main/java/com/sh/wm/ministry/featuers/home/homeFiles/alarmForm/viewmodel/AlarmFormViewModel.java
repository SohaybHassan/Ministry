package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.repository.AlarmFormRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

public class AlarmFormViewModel extends AndroidViewModel {

    public static final String TAG = AlarmFormViewModel.class.getSimpleName();
    AlarmFormRepository alarmFormRepository;

    public AlarmFormViewModel(@NonNull Application application) {
        super(application);
        alarmFormRepository = AlarmFormRepository.getInstance(application);
    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return alarmFormRepository.getConstructiondata(num_construction);

    }

    public LiveData<PalLaw> getPalLaw(String num_law) {

        return alarmFormRepository.getPalLawByNum(num_law);

    }
}
