package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;

import java.util.List;

@Dao
public interface CountriesDao {
    @Query("SELECT * FROM countries_table")
    LiveData<List<Country>> getAllCountries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCountry(Country country);

    @Query("SELECT COUNT(*) FROM countries_table")
    int getDataCount();

    @Query("SELECT * FROM countries_table WHERE cDCDNEW = :countryID")
    Country getUserCountry(String countryID);
}
