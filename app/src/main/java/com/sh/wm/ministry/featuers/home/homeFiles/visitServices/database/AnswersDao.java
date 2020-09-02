package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Answers;

import java.util.List;

@Dao
public interface AnswersDao {
    @Query("SELECT * FROM answers_table")
    LiveData<List<Answers>> getAllAnswers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAnswers (Answers answer);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateAnswers(Answers answer);

    @Delete
    int deleteAnswers(Answers answer);


    @Query("DELETE  FROM answers_table")
    void deleteAllAnswers();


    @Query("SELECT COUNT(*) FROM answers_table")
    int count();
}
