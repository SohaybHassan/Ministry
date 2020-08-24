package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.VisitResult;

import java.util.List;

@Dao
public interface VisitResultDao {
    @Query("SELECT * FROM visit_result_table")
    LiveData<List<VisitResult>> getAllVisitsResults();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVisitResult (VisitResult visit);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateVisitResult(VisitResult visit);

    @Delete
    int deleteVisitResult(VisitResult visit);


    @Query("DELETE  FROM visit_result_table")
    void deleteAllVisitResult();


    @Query("SELECT COUNT(*) FROM visit_result_table")
    int count();
}
