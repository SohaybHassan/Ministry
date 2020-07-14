package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.MunicipalityGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.RegionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.repository.MoveFacilityRepository;


public class MoveFacilityViewModel extends AndroidViewModel {


    private MoveFacilityRepository moveFacilityRepository;

    public MoveFacilityViewModel(@NonNull Application application) {
        super(application);
        moveFacilityRepository = MoveFacilityRepository.getInstance(application);
    }

    public LiveData<MunicipalityGroup> getmunicipality() {
        return moveFacilityRepository.getAllMunicipality();
    }

    public LiveData<RegionGroup> getregion() {
        return moveFacilityRepository.getAllRegion();
    }

    public LiveData<StreetGroup> getStreet() {
        return moveFacilityRepository.getAllStreet();
    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return moveFacilityRepository.getConstructiondata(num_construction);
    }
}
