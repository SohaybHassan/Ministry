package com.sh.wm.ministry.network.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.Language;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.database.LanguagesDao;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.database.LanguagesTypeConverter;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.database.WorkStatusDao;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.WorkStatus;


@Database(entities = {Language.class, WorkStatus.class}, version = 1, exportSchema = false)
@TypeConverters({LanguagesTypeConverter.class})

public abstract class DataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "db_ministry";
    private static DataBase sInstance;

    public static DataBase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DataBase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();

        }
        return sInstance;
    }

    //        public abstract CountriesDao countriesDao();
    public abstract LanguagesDao languagesDao();
    public abstract WorkStatusDao workStatusDao();
}
