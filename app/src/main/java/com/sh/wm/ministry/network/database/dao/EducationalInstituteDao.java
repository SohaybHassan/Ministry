package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;

import java.util.List;

@Dao
public interface EducationalInstituteDao {
    @Query("SELECT * FROM educational_institutes_table")
    LiveData<List<EducationalInstitute>> getAllEducationalInstitutes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEducationalInstitute(EducationalInstitute educationalInstitute);

    @Query("SELECT COUNT(*) FROM educational_institutes_table")
    int getDataCount();
}
