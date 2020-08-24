package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.directors.Director;

import java.util.List;

@Dao
public interface DirectorsDao {
    @Query("SELECT * FROM directors_table")
    LiveData<List<Director>> getAllDirectors();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addDirector(Director director);

    @Query("SELECT COUNT(*) FROM directors_table")
    int getDataCount();
}
