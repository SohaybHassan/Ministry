package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.sh.wm.ministry.network.database.dbModels.regions.Region;

import java.util.List;

@Dao
public interface RegionsDao {
    @Query("SELECT * FROM regions_table")
    LiveData<List<Region>> getAllRegions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRegion(Region region);

    @Query("SELECT COUNT(*) FROM regions_table")
    int getDataCount();
}
