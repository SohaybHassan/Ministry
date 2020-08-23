package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;

import java.util.List;

@Dao
public interface VisitDao {

    @Query("SELECT * FROM visits_table")
    LiveData<List<Visit>> getAllVisits();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVisit(Visit visit);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateVisit(Visit visit);

    @Delete
    int deleteVisit(Visit visit);


    @Query("DELETE  FROM visits_table")
    void deleteAllVisits();


}// end dao
