package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;

import java.util.List;

@Dao
public interface TrainingInstituteDao {
    @Query("SELECT * FROM training_institutes_table")
    LiveData<List<TrainingInstitute>> getAllTrainingInstitutes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrainingInstitute(TrainingInstitute trainingInstitute);

    @Query("SELECT COUNT(*) FROM training_institutes_table")
    int getDataCount();
}
