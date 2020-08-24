package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;

import java.util.List;

@Dao
public interface JobTitlesDao {
    @Query("SELECT * FROM job_titles_table")
    LiveData<List<JobTitle>> getAllJobTitles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addJobTitle(JobTitle jobTitle);

    @Query("SELECT COUNT(*) FROM job_titles_table")
    int getDataCount();
}
