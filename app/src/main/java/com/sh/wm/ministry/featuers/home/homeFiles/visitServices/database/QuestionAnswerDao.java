package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.QuestionAnswer;

import java.util.List;

@Dao
public interface QuestionAnswerDao {
    @Query("SELECT * FROM answers_table")
    LiveData<List<QuestionAnswer>> getAllAnswers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAnswers (QuestionAnswer answer);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateAnswers(QuestionAnswer answer);

    @Delete
    int deleteAnswers(QuestionAnswer answer);


    @Query("DELETE  FROM answers_table")
    void deleteAllAnswers();


    @Query("SELECT COUNT(*) FROM answers_table")
    int count();
}
