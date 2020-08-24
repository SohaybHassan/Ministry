package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;

import java.util.List;

@Dao
public interface MunicipalitiesDao {
    @Query("SELECT * FROM municipalities_table")
    LiveData<List<Municipality>> getAllMunicipalities();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMunicipality(Municipality municipality);

    @Query("SELECT COUNT(*) FROM municipalities_table")
    int getDataCount();
}
