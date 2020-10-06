package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PoastDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.repository.MoveFacilityRepository;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;


public class MoveFacilityViewModel extends AndroidViewModel {


    private MoveFacilityRepository moveFacilityRepository;
    private DBRepository repository;

    public MoveFacilityViewModel(@NonNull Application application) {
        super(application);
        moveFacilityRepository = MoveFacilityRepository.getInstance(application);
        repository = DBRepository.getInstance(application);
    }

    public LiveData<List<Municipality>> getAllMunicipalities() {
        return repository.getAllMunicipalities();
    }

    public LiveData<List<Region>> getAllRegions() {
        return repository.getAllRegions();
    }

    public LiveData<StreetGroup> getStreet() {
        return moveFacilityRepository.getAllStreet();
    }

    public LiveData<ConstructByName> getConstruct(String number) {
        return moveFacilityRepository.getConstruct(number);
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
