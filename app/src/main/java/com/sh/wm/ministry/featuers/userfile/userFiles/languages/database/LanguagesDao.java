package com.sh.wm.ministry.featuers.userfile.userFiles.languages.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.Language;

import java.util.List;

@Dao
public interface LanguagesDao {
    @Query("SELECT * FROM languages_table")
    LiveData<List<Language>> getAllLanguages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLanguage(Language language);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateAllLanguage(Language language);

    @Delete
    int deleteAllLanguage(Language language);

    @Query("SELECT EXISTS(SELECT * FROM languages_table)")
    boolean checkAllLanguages();

    @Query("SELECT COUNT(*) FROM languages_table")
    int getDataCount();
}
