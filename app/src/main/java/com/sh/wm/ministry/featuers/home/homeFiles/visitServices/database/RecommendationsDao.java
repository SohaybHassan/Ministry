package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Recommendations;

import java.util.List;

@Dao
public interface RecommendationsDao {
    @Query("SELECT * FROM recommendations_table")
    LiveData<List<Recommendations>> getAllRecommendations();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecommendations (Recommendations recommendations);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateRecommendations(Recommendations recommendations);

    @Delete
    int deleteRecommendations(Recommendations recommendations);


    @Query("DELETE  FROM recommendations_table")
    void deleteAllRecommendations();


    @Query("SELECT COUNT(*) FROM recommendations_table")
    int count();
}
