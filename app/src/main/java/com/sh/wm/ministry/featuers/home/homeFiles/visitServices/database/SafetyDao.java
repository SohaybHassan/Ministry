package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.SaftyQuestion;

import java.util.List;


@Dao
public interface SafetyDao {
    @Query("SELECT * FROM pal_laws")
    LiveData<List<SaftyQuestion>> getAllQuestions();

    @Query("SELECT * FROM pal_laws WHERE palLawSubjectID = :id ")
    LiveData<List<SaftyQuestion>> getQuestionsBySubId(int id);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSaftyQuestion(SaftyQuestion visit);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateSaftyQuestion(SaftyQuestion visit);

    @Delete
    int deleteSaftyQuestion(SaftyQuestion visit);


    @Query("DELETE  FROM pal_laws")
    void deleteAllSaftyQuestion();


    @Query("SELECT COUNT(*) FROM pal_laws")
    int count();
}
