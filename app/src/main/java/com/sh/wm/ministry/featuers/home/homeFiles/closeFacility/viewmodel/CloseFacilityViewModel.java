package com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.repository.CloseFacilityRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

public class CloseFacilityViewModel extends AndroidViewModel {
    CloseFacilityRepository closeFacilityRepository;

    public CloseFacilityViewModel(@NonNull Application application) {
        super(application);
        closeFacilityRepository = CloseFacilityRepository.getInstance(application);
    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return closeFacilityRepository.getConstructiondata(num_construction);
    }

    public LiveData<PalLaw> getPaleLaw(String numberLaw) {
        return closeFacilityRepository.getPalLaw(numberLaw);
    }

    public LiveData<CloseFacilityModel> postDataClose(String Constraction_ID, String CloseDate, String close_reason, String insert_userid) {
        return closeFacilityRepository.postAllData(Constraction_ID,CloseDate,close_reason,insert_userid);
    }

}
