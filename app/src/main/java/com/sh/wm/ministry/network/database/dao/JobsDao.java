package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.jobs.Job;

import java.util.List;

@Dao
public interface JobsDao {
    @Query("SELECT * FROM jobs_table")
    LiveData<List<Job>> getAllJobs();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addJob(Job job);

    @Query("SELECT COUNT(*) FROM jobs_table")
    int getDataCount();
}
