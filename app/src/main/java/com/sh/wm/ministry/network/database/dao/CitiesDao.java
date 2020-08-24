package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.cities.City;

import java.util.List;

@Dao
public interface CitiesDao {
    @Query("SELECT * FROM cities_table")
    LiveData<List<City>> getAllCities();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCity(City city);

    @Query("SELECT COUNT(*) FROM cities_table")
    int getDataCount();
}
