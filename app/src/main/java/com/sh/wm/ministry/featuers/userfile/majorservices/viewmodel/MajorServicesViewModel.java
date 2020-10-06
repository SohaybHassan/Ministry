package com.sh.wm.ministry.featuers.userfile.majorservices.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.repository.MajorServicesRepository;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;


public class MajorServicesViewModel extends AndroidViewModel {

    private MajorServicesRepository repository;
    private DBRepository dbRepository;

    public MajorServicesViewModel(@NonNull Application application) {
        super(application);
        repository = MajorServicesRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }

    public LiveData<UserInfoModel> getUserInfo() {
        return repository.getUserInfo();
    }

    public LiveData<List<Country>> getAllCountries() {
        return dbRepository.getAllCountries();
    }

    public Country getUserCountry(String countryID) {
        return dbRepository.getUserCountry(countryID);
    }
}