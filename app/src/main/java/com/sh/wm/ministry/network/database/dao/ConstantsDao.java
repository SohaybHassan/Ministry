package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;

import java.util.List;

@Dao
public interface ConstantsDao {
    @Query("SELECT * FROM constants_table")
    LiveData<List<Constants>> getAllConstants();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addConstant(Constants constants);

    @Query("SELECT * FROM constants_table WHERE cONSTANTPARENTID = :parentID")
    LiveData<List<Constants>> getConstants(String parentID);

    @Query("SELECT COUNT(*) FROM constants_table WHERE cONSTANTPARENTID = :parentID")
    int getDataCount(String parentID);

    @Query("SELECT uPDATEDATE FROM constants_table WHERE cONSTANTPARENTID = :parentID")
    List<Object> getMaxDate(String parentID);

    @Delete
    int deleteConstants(Constants constants);
}
