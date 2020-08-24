package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.util.List;

@Dao
public interface TrainingProgramDao {
    @Query("SELECT * FROM training_programs_table")
    LiveData<List<TrainingProgram>> getAllTrainingPrograms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingProgram(TrainingProgram trainingProgram);

    @Query("SELECT COUNT(*) FROM training_programs_table")
    int getDataCount();
}
