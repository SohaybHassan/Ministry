package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.ReVisitResult;


import java.util.List;

@Dao
public interface ReVisitResultDao {
    @Query("SELECT * FROM re_visit_table")
    LiveData<List<ReVisitResult>> getAllReVisitsResults();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReVisitResult (ReVisitResult visit);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateReVisitResult(ReVisitResult visit);

    @Delete
    int deleteReVisitResult(ReVisitResult visit);


    @Query("DELETE  FROM re_visit_table")
    void deleteAllReVisitResult();


    @Query("SELECT COUNT(*) FROM re_visit_table")
    int count();
}
