package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.MunicipalityGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PoastDataMoveFacility;
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

    public LiveData<PoastDataMoveFacility> poastData(String cnstruction_id, String address_id, String municipapiity_id, String region_id,
                                                     String street_id, String bulding_no, String address_desc, String x_direction, String y_direction,
                                                     String construction_tele, String construction_mobile, String construction_fax, String construction_box,
                                                     String construction_url){

        return moveFacilityRepository.postdata(cnstruction_id, address_id, municipapiity_id, region_id,
                street_id, bulding_no, address_desc, x_direction, y_direction,
                construction_tele, construction_mobile, construction_fax, construction_box, construction_url);
    }
}
