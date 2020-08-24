package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;

import java.util.List;

@Dao
public interface EduProgramDao {
    @Query("SELECT * FROM edu_programs_table")
    LiveData<List<EduProgram>> getAllEduPrograms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEduProgram(EduProgram eduProgram);

    @Query("SELECT COUNT(*) FROM edu_programs_table")
    int getDataCount();
}
