package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;

import java.util.List;

@Dao
public interface WorkStatusDao {
    @Query("SELECT * FROM work_status_table")
    LiveData<List<WorkStatus>> getAllWorkStatuses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addWorkStatus(WorkStatus workStatus);

    @Query("SELECT COUNT(*) FROM work_status_table")
    int getDataCount();
}
